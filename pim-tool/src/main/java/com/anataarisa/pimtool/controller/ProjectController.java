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
        List<ProjectDto> list = projectService.findAllProjects().stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getProjectList(@RequestParam Number projectId, @RequestParam String name){
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
    @PostMapping("/")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto initProject){

        this.projectService.createProject(initProject);
        return new ResponseEntity<>(initProject,HttpStatus.OK);
    }
}
