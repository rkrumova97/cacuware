package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CarDto {

    private UUID id;
    private String type;
    private String brand;
    private String number;
    private String engineVolume;
    private String insurance;
    private LocalDate insuranceExpiryDate;
    private String examination;
    private LocalDate examinationExpiryDate;
    private String vignette;
    private LocalDate vignetteExpiryDate;
    private String repair;
    private LocalDate repairDate;
    private String repairMoney;
    private Integer kilometers;
    private Float fuel;
    private Integer norm;
    private List<UUID> material;
}
