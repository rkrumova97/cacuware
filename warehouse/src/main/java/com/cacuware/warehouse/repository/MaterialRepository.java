package com.cacuware.warehouse.repository;

import com.cacuware.warehouse.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<Material, UUID> {
    List<Material> findAllByDeletedTrue();
}
