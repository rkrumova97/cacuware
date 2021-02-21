package com.cacuware.warehouse.service.impl;


import com.cacuware.warehouse.api.dto.ProjectDto;
import com.cacuware.warehouse.mapper.ProjectMapper;
import com.cacuware.warehouse.model.Company;
import com.cacuware.warehouse.model.Project;
import com.cacuware.warehouse.repository.ProjectRepository;
import com.cacuware.warehouse.service.CompanyService;
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

    @Autowired
    private CompanyService service;

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Company company = service.getOneById(projectDto.getCompany());
        return projectRepository.save(ProjectMapper.toEntity(projectDto,company));
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
        return projectRepository.findAllByIsDeletedFalse();
    }

    @Override
    public List<Project> findAllDeletedProjects() {
        return projectRepository.findAllByIsDeletedTrue();
    }
}
