package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ProjectDto {
    private UUID id;

    private CompanyDto company;

    private boolean isDeleted;

    private List<UUID> people;

    private List<UUID> files;

    private List<UUID> cars;

    private List<UUID> materials;

}
