package com.anataarisa.pimtool.service.impl;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.entity.Project;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.model.exception.MandatoryIsEmptyException;
import com.anataarisa.pimtool.model.exception.PermissionNotAllowException;
import com.anataarisa.pimtool.model.exception.ProjectNumberAlreadyExistsException;
import com.anataarisa.pimtool.repository.EmployeeRepository;
import com.anataarisa.pimtool.repository.GroupRepository;
import com.anataarisa.pimtool.repository.ProjectRepository;
import com.anataarisa.pimtool.service.EmployeeService;
import com.anataarisa.pimtool.service.GroupService;
import com.anataarisa.pimtool.service.ProjectService;
import com.anataarisa.pimtool.utils.ApplicationMapper;
import com.anataarisa.pimtool.validation.ApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final GroupService groupService;
    private final EmployeeService employeeService;
    private final ApplicationValidator<ProjectDto> applicationValidator;
    private final ApplicationMapper mapper;

    private final Integer maxPageSize = 5;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, GroupService groupService, EmployeeService employeeService, ApplicationMapper mapper, ApplicationValidator applicationValidator) {
        this.projectRepository = projectRepository;
        this.groupService = groupService;
        this.employeeService = employeeService;
        this.mapper = mapper;
        this.applicationValidator = applicationValidator;
    }


    @Override
    public Optional<Project> getProjectByID(Long projectID) {
        Optional<Project> project = projectRepository.findById(projectID);
        if(project.isEmpty()) throw new EntitySearchNotFoundException("Project with ID " + projectID + " does not exist", Set.of("Project with ID" + projectID + " does not exist"));
        return project;
    }
    @Override
    public Optional<Project> getProjectByProjectNumber(Long ID){
        Optional<Project> project = projectRepository.findProjectsByProjectNumber(ID);
        if(project.isEmpty()) throw new EntitySearchNotFoundException("Project with number ID " + ID + " does not exist", Set.of("Project with Project Number" + ID + " does not exist"));
        return project;
    }

    @Override
    public Set<Project> findAllProjects() {
        return new HashSet<>(this.projectRepository.findAll());
    }

    @Override
    public Page<Project> findProjectInPage(Integer page) {
        Sort sort = Sort.by("id").ascending().and(Sort.by("startDate").ascending());
        Pageable pageable = PageRequest.of(page - 1, maxPageSize, sort);
        return projectRepository.findAll(pageable);
    }

    @Override
    public Page<Project> findProjectSearchInPage(Integer page, String searchRequest, String requestStatus) {
        Sort sort = Sort.by("id").ascending().and(Sort.by("startDate").ascending());
        Set<Project> list = new HashSet<>();
        Pageable pageable = PageRequest.of(page - 1, maxPageSize, sort);
        if(requestStatus == null){
            list.addAll(new HashSet<>(projectRepository.findProjectsByProjectName(searchRequest)));
            list.addAll(new HashSet<>(projectRepository.findProjectsByCustomerName(searchRequest)));
        }
        return new PageImpl<>(new ArrayList<>(list),pageable,list.size());
    }


    @Override
    public Optional<Project> createProject(ProjectDto projectDto){
        Project project;
        Set<String> errorsMessage = applicationValidator.validate(projectDto);
        if(!errorsMessage.isEmpty()){
            throw new MandatoryIsEmptyException("Mandatory field isn't valid", errorsMessage);
        }
        project = mapper.projectDtoToProject(projectDto);
        project.setGroupProject(groupService.findGroupById(projectDto.getGroupId()).get());
        project.setEmployees(employeeService.getEmployeesByVisa(new HashSet<>(projectDto.getEmployeeVisa())));
        try{
            project = projectRepository.saveAndFlush(project);
        }catch(Exception e){
            throw new ProjectNumberAlreadyExistsException("Project Numerator already exists", Set.of("This project number is already in use by another project"));
        }
        return Optional.of(project);
    }
    @Override
    public Optional<Project> updateProject(ProjectDto projectDto){
        Project project;
        Set<String> errorsMessage = applicationValidator.validate(projectDto);
        if(!errorsMessage.isEmpty()){
            throw new MandatoryIsEmptyException("Please fill all required fields");
        }
        project = mapper.projectDtoToProject(projectDto);
        project.setGroupProject(groupService.findGroupById(projectDto.getGroupId()).get());
        project.setEmployees(employeeService.getEmployeesByVisa(new HashSet<>(projectDto.getEmployeeVisa())));
        Optional<Project> temp = projectRepository.findProjectsByProjectNumber(project.getProjectNumber());
        if(temp.isEmpty()){
            throw new EntitySearchNotFoundException("Not found project with this number" + project.getId(), Set.of("Project number:" + project.getProjectNumber() + "does not exist"));
        }
        project.setId(temp.get().getId());
        return Optional.of(projectRepository.saveAndFlush(project));
    }

    public void deleteProject(Long projectId){
        Project project;
        try{
            project = projectRepository.findById(projectId).orElseThrow();
            String status = project.getStatus();
            if(!status.equalsIgnoreCase("NEW")){
                throw new PermissionNotAllowException("Only status new can be deleted",Set.of("Project ID:" + projectId + " without NEW status can't be deleted") );
            }
        }catch(NoSuchElementException e){
            throw new EntitySearchNotFoundException("Project with ID" + projectId + " does not exists", Set.of("Project ID:" + projectId + "does not exist"));
        }
        projectRepository.deleteById(projectId);
    }
}
