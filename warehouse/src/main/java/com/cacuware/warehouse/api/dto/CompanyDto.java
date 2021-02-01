package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
public class CompanyDto {
    private UUID id;

    private String name;

    private String email;

    private String mol;

    private boolean isDeleted;

    private String bulstat;

    private String contactName;

    private String contactEmail;

    private Integer contactNumber;
}
