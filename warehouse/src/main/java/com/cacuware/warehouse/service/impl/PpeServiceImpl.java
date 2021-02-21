package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.mapper.MaterialMapper;
import com.cacuware.warehouse.mapper.PpeMapper;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.model.Material;
import com.cacuware.warehouse.model.PPE;
import com.cacuware.warehouse.repository.PpeRepository;
import com.cacuware.warehouse.service.MaterialService;
import com.cacuware.warehouse.service.PpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PpeServiceImpl implements PpeService {
    @Autowired
    private PpeRepository repository;

    @Autowired
    private MaterialService service;

    @Override
    public PPE savePpe(PpeDto ppeDto) {
        Material material = service.saveMaterial(ppeDto.getMaterial());
        return repository.save(PpeMapper.toEntity(ppeDto, material));
    }

    @Override
    public PPE getOneById(UUID uuid) {
        return repository.getOne(uuid);
    }

    @Override
    public void deletePpe(UUID uuid) {
        PPE ppe = repository.getOne(uuid);
        ppe.setDeleted(true);
        repository.save(ppe);
    }

    @Override
    public List<PPE> findAllPpes(Sort sort) {
        return repository.findAllByIsDeletedFalse();
    }

    @Override
    public List<PPE> findAllDeletedPpes() {
        return repository.findAllByIsDeletedTrue();
    }

    @Override
    public List<PpeDto> report(List<PpeDto> ppeDtoList) {
        List<PpeDto> ppeDtos = new ArrayList<>();
        for (PpeDto ppeDto : ppeDtoList) {
            Material material = service.getOneById(ppeDto.getMaterial().getId());
            PPE ppe = repository.save(PpeMapper.toEntity(ppeDto, material));
            ppeDtos.add(PpeMapper.toDto(ppe));
        }
        return ppeDtos;
    }
}
