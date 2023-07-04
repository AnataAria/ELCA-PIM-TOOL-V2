package com.anataarisa.pimtool.service;

import com.anataarisa.pimtool.model.dto.ProjectDto;
import com.anataarisa.pimtool.model.entity.Project;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.Set;

public interface ProjectService {
    public Optional<Project> getProjectByID(Number projectID) throws EntitySearchNotFoundException;
    public Set<Project> findAllProjects();
    public Page<Project> findProjectInPage(Integer page);
    public Page<Project> findProjectSearchInPage(Integer page);
    public Optional<Project> createProject(ProjectDto project);
}
