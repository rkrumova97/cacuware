package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PpeDto {
    private UUID id;

    private MaterialDto material;

    private String size;

    private String type;

    private boolean isDeleted;

    private List<UUID> people;
}
