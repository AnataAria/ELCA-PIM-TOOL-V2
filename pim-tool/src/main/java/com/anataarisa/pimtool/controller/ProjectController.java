package com.anataarisa.pimtool.controller;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
public class ProjectController extends AbstractApplicationController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{pageNumber}/")
    public ResponseEntity<List<ProjectDto>> getProjectList(@PathVariable Integer pageNumber) {
        List<ProjectDto> list = this.projectService.findProjectInPage(1).stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getProjectList(@RequestParam Long projectId){
        List<ProjectDto> list =null;
        if(projectId == null){
            list = projectService.findProjectInPage(1).stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto initProject){
        ProjectDto project = this.projectService.createProject(initProject).map(mapper::projectToProjectDto).get();
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto updateProject){
        ProjectDto project = this.projectService.updateProject(updateProject).map(mapper::projectToProjectDto).get();
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<?>deleteProject(@RequestParam Long deleteId){
        this.projectService.deleteProject(deleteId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
