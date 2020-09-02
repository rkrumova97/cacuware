package com.cacuware.hrms.repository;

import com.cacuware.hrms.model.SecurityData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SecurityDataRepository extends JpaRepository<SecurityData, UUID> {
    Optional<SecurityData> findById(UUID id);
}
