package com.cacuware.file.service;

import com.cacuware.file.exception.FileStorageException;
import com.cacuware.file.exception.MyFileNotFoundException;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import com.cacuware.file.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {
    @Autowired
    private FileRepository fileRepository;

    public File storeFile(MultipartFile file, int businessFile) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), Type.getByValue(businessFile), file.getBytes());

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(UUID fileId) {
        return fileRepository.findOne(fileId);
    }
}
