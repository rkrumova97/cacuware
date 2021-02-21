package com.cacuware.warehouse.repository;

import com.cacuware.warehouse.model.PPE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PpeRepository extends JpaRepository<PPE, UUID> {
    List<PPE> findAllByIsDeletedTrue();

    List<PPE> findAllByIsDeletedFalse();
}
