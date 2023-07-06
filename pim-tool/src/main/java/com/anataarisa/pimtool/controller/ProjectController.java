package com.anataarisa.pimtool.controller;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Project;
import com.anataarisa.pimtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ProjectController extends AbstractApplicationController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

//    @GetMapping("/")
//    public ResponseEntity<List<ProjectDto>> getProjectList(@RequestParam Long projectId){
//        List<ProjectDto> list =null;
//        if(projectId == null){
//            list = projectService.findProjectInPage(1).stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
//        }
//        return new ResponseEntity<>(list,HttpStatus.OK);
//    }
    @GetMapping("/projects/")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        List<ProjectDto> list = this.projectService.findAllProjects().stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/projects/{pageNumber}/")
    public ResponseEntity<List<ProjectDto>> getProjectList(@PathVariable Integer pageNumber) {
        List<ProjectDto> list = this.projectService.findProjectInPage(pageNumber).stream().map(mapper::projectToProjectDto).collect(Collectors.toList());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

//    @GetMapping("/{pageNumber}/search")
//    public ResponseEntity<List<ProjectDto>> getProjectListThrowsPage(@PathVariable Integer pageNumber,  @RequestParam String query){
//        th
//        return new RepsponseEntity<>(List<ProjectDto>);
//    }

    @PostMapping("/project/")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto initProject){
        ProjectDto project = this.projectService.createProject(initProject).map(mapper::projectToProjectDto).get();
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @GetMapping("/project")
    public ResponseEntity<ProjectDto> getProjectByProjectNumber(@RequestParam Long projectId){
        ProjectDto project = mapper.projectToProjectDto(this.projectService.getProjectByProjectNumber(projectId).get());
        return new ResponseEntity<>(project, HttpStatus.OK);
    }


    @PutMapping("/project")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto updateProject){
        ProjectDto project = this.projectService.updateProject(updateProject).map(mapper::projectToProjectDto).get();
        return new ResponseEntity<>(project,HttpStatus.OK);
    }
    
    @DeleteMapping("/project")
    public ResponseEntity<?>deleteProject(@RequestParam Long deleteId){
        this.projectService.deleteProject(deleteId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
