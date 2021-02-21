package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.mapper.MaterialMapper;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.model.Material;
import com.cacuware.warehouse.repository.MaterialRepository;
import com.cacuware.warehouse.service.CompanyService;
import com.cacuware.warehouse.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialRepository repository;

    @Autowired
    private CompanyService service;

    @Override
    public Material saveMaterial(MaterialDto materialDto) {
        Company company = service.getOneById(materialDto.getDelivery());
        return repository.save(MaterialMapper.toEntity(materialDto, company));
    }

    @Override
    public List<MaterialDto> report(List<MaterialDto> materialDtos) {
        List<MaterialDto> materials = new ArrayList<>();
        for (MaterialDto materialDto : materialDtos) {
            Company company = service.getOneById(materialDto.getDelivery());
            Material material = repository.save(MaterialMapper.toEntity(materialDto, company));
            materials.add(MaterialMapper.toDto(material));
        }
        return materials;
    }

    @Override
    public Material getOneById(UUID uuid) {
        return repository.getOne(uuid);
    }

    @Override
    public void deleteMaterial(UUID uuid) {
        Material material = repository.findById(uuid);
        material.setDeleted(true);
        repository.save(material);
    }

    @Override
    public List<MaterialDto> findAllMaterials() {
        List<MaterialDto> materialDtos = new ArrayList<>();
        for (Material material : repository.findAllByIsDeletedFalse()) {
            materialDtos.add(MaterialMapper.toDto(material));
        }
        return materialDtos;
    }

    @Override
    public List<Material> findAllDeletedMaterials() {
        return repository.findAllByIsDeletedTrue();
    }
}
