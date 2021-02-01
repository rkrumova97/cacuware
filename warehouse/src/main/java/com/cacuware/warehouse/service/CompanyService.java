package com.cacuware.warehouse.service;

import com.cacuware.warehouse.api.dto.CompanyDto;
import com.cacuware.warehouse.model.Company;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    Company saveCompany(CompanyDto companyDto);

    Company getOneById(UUID uuid);

    void deleteCompany(UUID uuid);

    List<Company> findAllCompanies(Sort sort);
}
