package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.mapper.MaterialMapper;
import com.cacuware.warehouse.model.Material;
import com.cacuware.warehouse.repository.MaterialRepository;
import com.cacuware.warehouse.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialRepository repository;

    @Override
    public Material saveMaterial(MaterialDto materialDto) {
        return repository.save(MaterialMapper.toEntity(materialDto));
    }

    @Override
    public Material getOneById(UUID uuid) {
        return repository.getOne(uuid);
    }

    @Override
    public void deleteMaterial(UUID uuid) {
        Material material = repository.getOne(uuid);
        material.setDeleted(true);
        repository.save(material);
    }

    @Override
    public List<Material> findAllMaterials(Sort sort) {
        return repository.findAll(sort);
    }
}
