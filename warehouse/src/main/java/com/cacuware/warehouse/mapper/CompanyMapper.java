package com.cacuware.warehouse.mapper;

import com.cacuware.warehouse.api.dto.CompanyDto;
import com.cacuware.warehouse.model.Company;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CompanyMapper {
    public static Company toEntity(CompanyDto companyDto) {
        Company company = Company.builder()
                .bulstat(companyDto.getBulstat())
                .contactEmail(companyDto.getContactEmail())
                .contactName(companyDto.getContactName())
                .contactNumber(companyDto.getContactNumber())
                .email(companyDto.getEmail())
                .mol(companyDto.getMol())
                .name(companyDto.getName())
                .build();
        if (Objects.nonNull(companyDto.getId())) {
            company.setId(companyDto.getId());
        }
        return company;
    }

    public static CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .bulstat(company.getBulstat())
                .contactEmail(company.getContactEmail())
                .contactName(company.getContactName())
                .contactNumber(company.getContactNumber())
                .email(company.getEmail())
                .mol(company.getMol())
                .name(company.getName())
                .build();
    }
}
