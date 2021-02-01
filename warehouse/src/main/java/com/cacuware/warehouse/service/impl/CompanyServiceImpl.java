package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.CompanyDto;
import com.cacuware.warehouse.mapper.CompanyMapper;
import com.cacuware.warehouse.model.Car;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.repository.CompanyRepository;
import com.cacuware.warehouse.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository repository;

    @Override
    public Company saveCompany(CompanyDto companyDto) {
        return repository.save(CompanyMapper.toEntity(companyDto));
    }

    @Override
    public Company getOneById(UUID uuid) {
        return repository.getOne(uuid);
    }

    @Override
    public void deleteCompany(UUID uuid) {
        Company company = getOneById(uuid);
        company.setDeleted(true);
        repository.save(company);
    }

    @Override
    public List<Company> findAllCompanies(Sort sort) {
        return repository.findAll(sort);
    }
}
