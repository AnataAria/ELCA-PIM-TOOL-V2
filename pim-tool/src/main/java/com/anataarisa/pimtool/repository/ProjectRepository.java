package com.anataarisa.pimtool.repository;

import com.anataarisa.pimtool.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Number> {

    @Query("SELECT u FROM PROJECT u WHERE u.name LIKE %:projectName%")
    Collection <Project> findProjectsByProjectName(@Param("projectName") String projectName);

    @Query("SELECT u FROM PROJECT u WHERE u.customer LIKE %:customerName%")
    Collection <Project> findProjectsByCustomerName(@Param("customerName") String customerName);

    @Query("SELECT u FROM PROJECT u WHERE u.status = :ProjectStatus")
    Collection<Project> findProjectsByStatus(@Param("ProjectStatus") String status);

    @Query("SELECT u FROM PROJECT u WHERE u.projectNumber = :ProjectNumber")
    Optional<Project> findProjectsByProjectNumber(@Param("ProjectNumber") Long projectNumber);


}
