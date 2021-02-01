package com.cacuware.warehouse.service;

import com.cacuware.warehouse.api.dto.CompanyDto;
import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.model.Material;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface MaterialService {
    Material saveMaterial(MaterialDto materialDto);

    Material getOneById(UUID uuid);

    void deleteMaterial(UUID uuid);

    List<Material> findAllMaterials(Sort sort);
}
