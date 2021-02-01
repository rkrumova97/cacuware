package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.mapper.PpeMapper;
import com.cacuware.warehouse.model.PPE;
import com.cacuware.warehouse.repository.PpeRepository;
import com.cacuware.warehouse.service.PpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PpeServiceImpl implements PpeService {
    @Autowired
    private PpeRepository repository;

    @Override
    public PPE savePpe(PpeDto ppeDto) {
        return repository.save(PpeMapper.toEntity(ppeDto));
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
        return repository.findAll(sort);
    }
}
