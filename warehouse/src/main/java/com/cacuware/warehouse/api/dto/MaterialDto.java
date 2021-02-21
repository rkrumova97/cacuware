package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class MaterialDto {
    private UUID id;

    private String measurement;

    private String quantity;

    private Integer singlePrice;

    private Integer value;

    private Integer incomeInvoiceNumber;

    private Integer moneySpent;

    private Integer outcomeInvoiceNumber;

    private LocalDate date;

    private Float left;

    private String type;

    private boolean isDeleted;

    private UUID delivery;
}
