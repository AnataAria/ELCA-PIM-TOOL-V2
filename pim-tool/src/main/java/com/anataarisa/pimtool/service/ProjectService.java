package com.anataarisa.pimtool.service;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Project;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.model.exception.MandatoryIsEmptyException;
import com.anataarisa.pimtool.model.exception.ProjectNumberAlreadyExistsException;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.Set;

public interface ProjectService {
    public Optional<Project> getProjectByID(Long projectID);
    public Set<Project> findAllProjects();
    public Page<Project> findProjectInPage(Integer page);
    public Optional<Project> getProjectByProjectNumber(Long projectNumber);
    public Page<Project> findProjectSearchInPage(Integer page, String searchRequest, String requestStatus);
    public Optional<Project> createProject(ProjectDto project);

    public Optional<Project> updateProject(ProjectDto project);
    public void deleteProject(Long projectId);
}
