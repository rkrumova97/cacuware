package com.cacuware.file.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse {
    private UUID id;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
