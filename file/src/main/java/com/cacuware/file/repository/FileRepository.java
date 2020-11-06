package com.cacuware.file.repository;

import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<File, UUID> {
    File findFirstByFileBusinessType(Type fileBusinessType);
}
