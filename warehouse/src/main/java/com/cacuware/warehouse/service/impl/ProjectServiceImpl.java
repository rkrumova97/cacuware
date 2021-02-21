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

import java.util.ArrayList;
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
        return projectRepository.save(ProjectMapper.toEntity(projectDto, company));
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
    public List<ProjectDto> findAllProjects(Sort sort) {
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project projectDto : projectRepository.findAllByIsDeletedFalse()) {
            projectDtos.add(ProjectMapper.toDto(projectDto));
        }
        return projectDtos;
    }

    @Override
    public List<Project> findAllDeletedProjects() {
        return projectRepository.findAllByIsDeletedTrue();
    }

    @Override
    public List<ProjectDto> report(List<ProjectDto> projectDtos) {
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (ProjectDto projectDto : projectDtos) {
            Company company = service.getOneById(projectDto.getCompany());
            // Project p = projectRepository.getOne(projectDto.getId());
//            projectDto.getCars().addAll(p.getCar_id());
//            projectDto.getMaterials().addAll(p.getMaterial_id());
//            projectDto.getPeople().addAll(p.getPeople_id());
//            projectDto.getCars().addAll(p.getCar_id());
            Project project = projectRepository.save(ProjectMapper.toEntity(projectDto, company));
            projectDtoList.add(ProjectMapper.toDto(project));
        }
        return projectDtoList;
    }
}
