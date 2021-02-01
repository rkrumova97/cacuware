package com.cacuware.warehouse.api.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
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

    private Integer left;

    private String type;

    private boolean isDeleted;
}
