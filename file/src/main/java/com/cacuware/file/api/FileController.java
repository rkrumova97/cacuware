package com.cacuware.file.api;

import com.cacuware.file.api.dto.UploadFileResponse;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import com.cacuware.file.service.FileStorageService;
import com.cacuware.file.service.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.Produces;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class FileController {

    @Autowired
    private FileStorageService dbFileStorageService;

    @Autowired
    private GenerateFileService generateFileService;

    @PostMapping("/uploadFile")
    @Produces("application/json")
    public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
        File dbFile = dbFileStorageService.storeFile(file, type);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId().toString())
                .toUriString();

        return ResponseEntity.ok(new UploadFileResponse(dbFile.getId(), dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize()));
    }

    @PostMapping("/uploadMultipleFiles")
    public List<ResponseEntity<UploadFileResponse>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("types") List<String> types) {
        if (types.size() != files.length) {
            return null;
        } else {
            return IntStream.range(0, files.length)
                    .mapToObj(i -> uploadFile(files[i], types.get(i)))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = dbFileStorageService.getFile(UUID.fromString(fileId));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getFile()));
    }

    @GetMapping("/getFiles")
    public ResponseEntity<List<UploadFileResponse>> getFiles() {
        return ResponseEntity.ok(dbFileStorageService.getFilesData());
    }

    @GetMapping("/getFileTypes")
    public ResponseEntity<List<String>> getFileTypes() {
        return ResponseEntity.ok(Type.getAllNames());
    }

    @GetMapping("/getWord")
    public ResponseEntity<?> getWord() throws Exception {
        generateFileService.createWord();
        return ResponseEntity.ok().build();
    }


}
