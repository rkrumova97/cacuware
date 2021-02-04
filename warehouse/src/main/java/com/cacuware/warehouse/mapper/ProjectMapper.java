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
                .car_id(projectDto.getCars())
                .file_id(projectDto.getFiles())
                .material_id(projectDto.getMaterials())
                .people_id(projectDto.getPeople())
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
                .cars(project.getCar_id())
                .files(project.getFile_id())
                .materials(project.getMaterial_id())
                .people(project.getPeople_id())
                .build();
    }
}
