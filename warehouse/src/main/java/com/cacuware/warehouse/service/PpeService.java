package com.cacuware.warehouse.service;

import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.model.PPE;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface PpeService {
    PPE savePpe(PpeDto ppeDto);

    PPE getOneById(UUID uuid);

    void deletePpe(UUID uuid);

    List<PPE> findAllPpes(Sort sort);

}
