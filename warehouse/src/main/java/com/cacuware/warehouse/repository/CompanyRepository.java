package com.cacuware.warehouse.repository;

import com.cacuware.warehouse.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    List<Company> findAllByIsDeletedTrue();

    List<Company> findAllByIsDeletedFalse();

    Company findById(UUID uuid);
}
