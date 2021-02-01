package com.cacuware.warehouse.mapper;

import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.model.Material;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MaterialMapper {
    public static Material toEntity(MaterialDto materialDto) {
        Material material = Material.builder()
                .type(materialDto.getType())
                .date(materialDto.getDate())
                .incomeInvoiceNumber(materialDto.getIncomeInvoiceNumber())
                .left(materialDto.getLeft())
                .measurement(materialDto.getMeasurement())
                .moneySpent(materialDto.getMoneySpent())
                .outcomeInvoiceNumber(materialDto.getOutcomeInvoiceNumber())
                .quantity(materialDto.getQuantity())
                .singlePrice(materialDto.getSinglePrice())
                .value(materialDto.getValue())
                .build();
        if (Objects.nonNull(materialDto.getId())) {
            material.setId(materialDto.getId());
        }
        return material;
    }

    public static MaterialDto toDto(Material material) {
        return MaterialDto.builder()
                .id(material.getId())
                .type(material.getType())
                .date(material.getDate())
                .incomeInvoiceNumber(material.getIncomeInvoiceNumber())
                .left(material.getLeft())
                .measurement(material.getMeasurement())
                .moneySpent(material.getMoneySpent())
                .outcomeInvoiceNumber(material.getOutcomeInvoiceNumber())
                .quantity(material.getQuantity())
                .singlePrice(material.getSinglePrice())
                .value(material.getValue())
                .build();
    }
}
