package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.ProjectDto;
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
    public ResponseEntity<List<Project>> getAllProjects(Pageable pageable) {
        List<Project> projects = projectService.findAllProjects(pageable.getSort());
        return ResponseEntity.ok().body(projects);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDto projectDto) throws URISyntaxException {
        Project Project = projectService.saveProject(projectDto);
        return ResponseEntity.created(new URI("/api/" + Project.getId()))
                .body(Project);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        projectService.deleteProject(uuid);
        return ResponseEntity.noContent().build();
    }
}
