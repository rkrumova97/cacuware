package com.cacuware.file.api;

import com.cacuware.file.api.dto.EmployeeDto;
import com.cacuware.file.api.dto.UploadFileResponse;
import com.cacuware.file.api.dto.VacationDto;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import com.cacuware.file.service.FileStorageService;
import com.cacuware.file.service.GenerateFileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.ArrayList;
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
                dbFile.getFileBusinessType().toString(), file.getContentType(), file.getSize()));
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
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = dbFileStorageService.getFile(UUID.fromString(fileId));
        return getResponseEntity(dbFile);
    }

    private ResponseEntity<byte[]> getResponseEntity(File dbFile) {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(dbFile.getFile().length);
        respHeaders.setContentType(MediaType.parseMediaType(dbFile.getFileType()));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= \" " + dbFile.getFileName() + "\"");
        return new ResponseEntity<>(dbFile.getFile(), respHeaders, HttpStatus.OK);
    }

    @GetMapping("/getFiles")
    public ResponseEntity<List<UploadFileResponse>> getFiles() {
        return ResponseEntity.ok(dbFileStorageService.getFilesData());
    }

    @GetMapping("/getFilesByIds")
    public ResponseEntity<List<UploadFileResponse>> getFiles(@RequestParam("ids") List<UUID> files) {
        return ResponseEntity.ok(dbFileStorageService.getFilesByIDs(files));
    }

    @GetMapping("/getFileTypes")
    public ResponseEntity<List<String>> getFileTypes() {
        return ResponseEntity.ok(Type.getAllNames());
    }

    @GetMapping("/generateDocuments")
    @Consumes("application/json")
    public ResponseEntity<List<UploadFileResponse>> generateDocuments(@RequestParam("employee") String employee) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        final EmployeeDto employeeDto =
                objectMapper.readValue(employee, EmployeeDto.class);
        List<UUID> ids = new ArrayList<>();
        File contract = generateFileService.createContract(employeeDto);
        ids.add(contract.getId());
        File gdpr = generateFileService.createGDPR(employeeDto);
        ids.add(gdpr.getId());
        File instruction = generateFileService.createInstruction(employeeDto);
        ids.add(instruction.getId());
        File requestHire = generateFileService.createRequestHire();
        ids.add(requestHire.getId());
        return getFiles(ids);
    }

    @GetMapping("/fireDocuments")
    @Consumes("application/json")
    public ResponseEntity<?> generateFireDocuments(@RequestParam("employee") String employee) throws Exception {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        EmployeeDto employeeDto = om.readValue(employee, EmployeeDto.class);
        File fireDocument = generateFileService.createFireDocument(employeeDto);
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(fireDocument.getFile().length);
        respHeaders.setContentType(MediaType.parseMediaType(fireDocument.getFileType()));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= \" " + fireDocument.getFileName() + "\"");
        return new ResponseEntity<>(fireDocument, respHeaders, HttpStatus.OK);
    }

    @GetMapping("/vacationDocuments")
    public void generateVacationDocuments(@RequestParam("employee") EmployeeDto employee, @RequestParam("vacation") VacationDto vacationDto, HttpServletResponse response) throws Exception {

    }
}
