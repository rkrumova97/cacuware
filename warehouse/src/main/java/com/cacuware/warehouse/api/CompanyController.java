package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.CompanyDto;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/warehouse/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Company findCompany(@PathVariable("id") UUID id) {
        return companyService.getOneById(id);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompaniess(Pageable pageable) {
        List<Company> people = companyService.findAllCompanies(pageable.getSort());
        return ResponseEntity.ok().body(people);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody CompanyDto companyDto) throws URISyntaxException {
        Company company = companyService.saveCompany(companyDto);
        return ResponseEntity.created(new URI("/api/" + company.getId()))
                .body(company);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        companyService.deleteCompany(uuid);
        return ResponseEntity.noContent().build();
    }
}
