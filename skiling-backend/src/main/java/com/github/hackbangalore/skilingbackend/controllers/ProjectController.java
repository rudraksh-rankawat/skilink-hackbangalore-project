package com.github.hackbangalore.skilingbackend.controllers;

import com.github.hackbangalore.skilingbackend.models.Project;
import com.github.hackbangalore.skilingbackend.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectID}")
    public Project getProject(@PathVariable String projectID) throws ExecutionException, InterruptedException {
        return projectService.getProject(projectID);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) throws ExecutionException, InterruptedException {
        return projectService.createProject(project);
    }

    @PutMapping
    public Project updateUser(@RequestBody Project project){
        return projectService.updateUser(project);
    }

    @DeleteMapping("/{projId}")
    public void deleteUser(@PathVariable String projId) {
        projectService.deleteUser(projId);
    }
}
