package com.cacuware.warehouse.service.impl;


import com.cacuware.warehouse.api.dto.ProjectDto;
import com.cacuware.warehouse.mapper.ProjectMapper;
import com.cacuware.warehouse.model.Project;
import com.cacuware.warehouse.repository.ProjectRepository;
import com.cacuware.warehouse.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(ProjectDto projectDto) {
        return projectRepository.save(ProjectMapper.toEntity(projectDto));
    }

    @Override
    public Project getOneById(UUID uuid) {
        return projectRepository.getOne(uuid);
    }

    @Override
    public void deleteProject(UUID uuid) {
        Project project = projectRepository.getOne(uuid);
        project.setDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAllProjects(Sort sort) {
        return projectRepository.findAll(sort);
    }
}
