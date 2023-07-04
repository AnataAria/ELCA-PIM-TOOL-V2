package com.anataarisa.pimtool.service.impl;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.entity.Project;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.repository.EmployeeRepository;
import com.anataarisa.pimtool.repository.GroupRepository;
import com.anataarisa.pimtool.repository.ProjectRepository;
import com.anataarisa.pimtool.service.EmployeeService;
import com.anataarisa.pimtool.service.GroupService;
import com.anataarisa.pimtool.service.ProjectService;
import com.anataarisa.pimtool.utils.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final GroupService groupService;
    private final EmployeeService employeeService;

    private final ApplicationMapper mapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, GroupService groupService, EmployeeService employeeService, ApplicationMapper mapper){
        this.projectRepository = projectRepository;
        this.groupService = groupService;
        this.employeeService = employeeService;
        this.mapper = mapper;
    }


    @Override
    public Optional<Project> getProjectByID(Number projectID) {
        return projectRepository.findById(projectID);
    }

    @Override
    public Set<Project> findAllProjects() {;
        return this.projectRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Page<Project> findProjectInPage(Integer page) {

        return null;
    }

    @Override
    public Page<Project> findProjectSearchInPage(Integer page) {
        return null;
    }

    @Override
    public Optional<Project> createProject(ProjectDto project) {
        Project data = null;
        try{
            data = mapper.projectDtoToProject(project);
            List<String> projectVisa = project.getEmployeeVisa();
            if(projectVisa != null){
                Set<Employee> employee = employeeService.getEmployeesByVisa(new HashSet<>(projectVisa));
                if(employee != null){
                    data.setEmployees(employee);
                }
            }

        }catch(EntitySearchNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){

        }
        try{
            if (data != null) {
                projectRepository.saveAndFlush(data);
            }
        }catch(Exception e){

        }

        return Optional.of(data);
    }


}
