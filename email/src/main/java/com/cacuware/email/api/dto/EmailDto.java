package com.cacuware.email.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
public class EmailDto {
    private String email;

    private String text;

    private String subject;

    private String fileName;

    private File file;
}
