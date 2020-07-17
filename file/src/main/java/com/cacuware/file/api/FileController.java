package com.cacuware.file.api;

import com.cacuware.file.api.dto.UploadFileResponse;
import com.cacuware.file.model.File;
import com.cacuware.file.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class FileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService dbFileStorageService;

    @PostMapping("/uploadFile")
    @PreAuthorize("#oauth2.hasScope('read')")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("type") int type) {
        File dbFile = dbFileStorageService.storeFile(file, type);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId().toString())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    @PreAuthorize("#oauth2.hasScope('read')")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("types") List<Integer> types) {
        if (types.size() != files.length){
            return null;
        } else {
            return IntStream.range(0, files.length)
                    .mapToObj(i -> uploadFile(files[i], types.get(i)))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/downloadFile/{fileId}")
    @PreAuthorize("#oauth2.hasScope('read')")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = dbFileStorageService.getFile(UUID.fromString(fileId));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getFile()));
    }


}
