package com.cacuware.warehouse.service;

import com.cacuware.warehouse.api.dto.ProjectDto;
import com.cacuware.warehouse.model.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    Project saveProject(ProjectDto projectDto);

    Project getOneById(UUID uuid);

    void deleteProject(UUID uuid);

    List<ProjectDto> findAllProjects(Sort sort);

    List<Project> findAllDeletedProjects();

    List<ProjectDto> report(List<ProjectDto> projectDtos);
}
