package com.cacuware.warehouse.mapper;

import com.cacuware.warehouse.api.dto.ProjectDto;
import com.cacuware.warehouse.model.Project;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectMapper {
    public static Project toEntity(ProjectDto projectDto) {
        Project person = Project.builder()
                .company(CompanyMapper.toEntity(projectDto.getCompany()))
                .cars(projectDto.getCars())
                .files(projectDto.getFiles())
                .materials(projectDto.getMaterials())
                .people(projectDto.getPeople())
                .build();
        if (Objects.nonNull(projectDto.getId())) {
            person.setId(projectDto.getId());
        }
        return person;
    }

    public static ProjectDto toDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .company(CompanyMapper.toDto(project.getCompany()))
                .cars(project.getCars())
                .files(project.getFiles())
                .materials(project.getMaterials())
                .people(project.getPeople())
                .build();
    }
}
