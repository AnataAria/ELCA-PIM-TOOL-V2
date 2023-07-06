package com.anataarisa.pimtool.utils;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.entity.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ApplicationMapper {
    public ApplicationMapper(){

    }

    public ProjectDto projectToProjectDto(Project project){
        ProjectDto dto = new ProjectDto();
        dto.setGroupId(project.getGroupProject().getId());
        dto.setProjectNumber(project.getProjectNumber());
        dto.setName(project.getName());
        dto.setCustomer(project.getCustomer());
        dto.setStatus(project.getStatus());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setVersion(project.getVersion());
        List<Employee> projectList = new ArrayList<>(project.getEmployees());
        Set<String> employeeVisa = new HashSet<>();
        if(projectList != null){
            for(Employee employee : projectList){
                employeeVisa.add(employee.getVisa());
            }
        }
        dto.setEmployeeVisa(new ArrayList<>(employeeVisa));
        return dto;
    }

    public Project projectDtoToProject(ProjectDto dto){
        Project project = new Project();
        project.setProjectNumber(dto.getProjectNumber());
        project.setName(dto.getName());
        project.setCustomer(dto.getCustomer());
        project.setStatus(dto.getStatus());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setVersion(dto.getVersion());
        return project;
    }

}
