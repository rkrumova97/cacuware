package com.cacuware.file.service;

import com.cacuware.file.api.dto.UploadFileResponse;
import com.cacuware.file.exception.FileStorageException;
import com.cacuware.file.exception.MyFileNotFoundException;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import com.cacuware.file.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileStorageService {
    @Autowired
    private FileRepository fileRepository;

    public File storeFile(MultipartFile file, String businessFile) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            int number;
            if (fileName.contains("№")) {
                number = Character.getNumericValue(fileName.charAt(fileName.indexOf("№") + 1));
            } else {
                number = findCount(Type.getByName(businessFile)) + 1;
            }

            File dbFile = new File(fileName, file.getContentType(), Type.getByName(businessFile), file.getBytes(), number);

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(UUID fileId) {
        return fileRepository.findOne(fileId);
    }

    public List<UploadFileResponse> getFilesData() {
        List<UploadFileResponse> list = new ArrayList<>();
        fileRepository.findAll().forEach(file -> list.add(UploadFileResponse.builder()
                .id(file.getId())
                .size(file.getFile().length)
                .fileName(file.getFileName())
                .fileType(file.getFileType())
                .fileDownloadUri(ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(file.getId().toString())
                        .toUriString())
                .fileBusinessType(file.getFileBusinessType().toString())
                .build()));
        return list;
    }

    public int findCount(Type type) {
        if (Objects.nonNull(fileRepository.findFirstByFileBusinessType(type))) {
            return Objects.nonNull(fileRepository.findFirstByFileBusinessType(type).getCounter()) ?
                    fileRepository.findFirstByFileBusinessType(type).getCounter() : 1;
        } else return 1;
    }

    public List<File> getFiles(List<UUID> ids) {
        List<File> files = new ArrayList<>();
        ids.forEach(e -> {
            files.add(getFile(e));
        });
        return files;
    }

    public List<UploadFileResponse> getFilesByIDs(List<UUID> ids) {
        List<UploadFileResponse> list = new ArrayList<>();
        ids.forEach(id -> {
            File file = getFile(id);
            list.add(UploadFileResponse.builder()
                    .id(file.getId())
                    .size(file.getFile().length)
                    .fileName(file.getFileName())
                    .fileType(file.getFileType())
                    .fileDownloadUri(ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/downloadFile/")
                            .path(file.getId().toString())
                            .toUriString())
                    .build());
        });
        return list;
    }
}
