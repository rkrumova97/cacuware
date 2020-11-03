package com.cacuware.file.api;

import com.cacuware.file.api.dto.EmployeeDto;
import com.cacuware.file.api.dto.UploadFileResponse;
import com.cacuware.file.api.dto.VacationDto;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import com.cacuware.file.service.FileStorageService;
import com.cacuware.file.service.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = dbFileStorageService.getFile(UUID.fromString(fileId));
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

    @GetMapping("/getFileTypes")
    public ResponseEntity<List<String>> getFileTypes() {
        return ResponseEntity.ok(Type.getAllNames());
    }

    @GetMapping("/hireDocuments/{employee}")
    public void generateHireDocuments(@PathVariable EmployeeDto employee, HttpServletResponse response) throws Exception {
        File contract = generateFileService.createContract(employee);
        File instruction = generateFileService.createInstruction(employee);
        File requestHire = generateFileService.createRequestHire();
        File gdpr = generateFileService.createGDPR(employee);
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());

        ZipEntry zipEntry = new ZipEntry(contract.getFileName());
        zipEntry.setSize(contract.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(contract.getFile(), zipOut);
        zipOut.closeEntry();

        zipEntry = new ZipEntry(instruction.getFileName());
        zipEntry.setSize(instruction.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(instruction.getFile(), zipOut);
        zipOut.closeEntry();

        zipEntry = new ZipEntry(requestHire.getFileName());
        zipEntry.setSize(requestHire.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(requestHire.getFile(), zipOut);
        zipOut.closeEntry();

        zipEntry = new ZipEntry(gdpr.getFileName());
        zipEntry.setSize(gdpr.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(gdpr.getFile(), zipOut);
        zipOut.closeEntry();

        zipOut.finish();
        zipOut.close();
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"zipfiles\"");
    }

    @GetMapping("/fireDocuments/{employee}")
    public ResponseEntity<?> generateFireDocuments(@PathVariable EmployeeDto employee) throws Exception {
        File fireDocument = generateFileService.createFireDocument(employee);
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(fireDocument.getFile().length);
        respHeaders.setContentType(MediaType.parseMediaType(fireDocument.getFileType()));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= \" " + fireDocument.getFileName() + "\"");
        return new ResponseEntity<>(fireDocument, respHeaders, HttpStatus.OK);
    }

    @GetMapping("/vacationDocuments/{employee}")
    public void generateVacationDocuments(@PathVariable EmployeeDto employee, @PathVariable VacationDto vacationDto, HttpServletResponse response) throws Exception {
        File vacationDocument = generateFileService.createVacationDocument(employee);
        File vacationRequest = generateFileService.createVacationRequest(employee, vacationDto);

        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());

        ZipEntry zipEntry = new ZipEntry(vacationDocument.getFileName());
        zipEntry.setSize(vacationDocument.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(vacationDocument.getFile(), zipOut);
        zipOut.closeEntry();

        zipEntry = new ZipEntry(vacationRequest.getFileName());
        zipEntry.setSize(vacationRequest.getFile().length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(vacationRequest.getFile(), zipOut);
        zipOut.closeEntry();

        zipOut.finish();
        zipOut.close();
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"zipfiles\"");
    }
}
