package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.api.dto.ProjectDto;
import com.cacuware.warehouse.model.Car;
import com.cacuware.warehouse.model.Project;
import com.cacuware.warehouse.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/warehouse/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Project findProject(@PathVariable("id") UUID id) {
        return projectService.getOneById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(Pageable pageable) {
        List<ProjectDto> projects = projectService.findAllProjects(pageable.getSort());
        return ResponseEntity.ok().body(projects);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDto projectDto) throws URISyntaxException {
        Project Project = projectService.saveProject(projectDto);
        return ResponseEntity.created(new URI("/api/" + Project.getId()))
                .body(Project);
    }

    @PutMapping("/report")
    public ResponseEntity<List<ProjectDto>> report(@RequestBody List<ProjectDto> projectDtos) {
        List<ProjectDto> projectDtoList = projectService.report(projectDtos);
        return ResponseEntity.ok()
                .body(projectDtoList);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        projectService.deleteProject(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/archive")
    public ResponseEntity<List<Project>> archive() {
        List<Project> projects = projectService.findAllDeletedProjects();
        return ResponseEntity.ok().body(projects);
    }
}
