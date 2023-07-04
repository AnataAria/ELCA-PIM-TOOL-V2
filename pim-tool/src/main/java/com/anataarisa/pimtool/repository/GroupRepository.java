package com.anataarisa.pimtool.repository;

import com.anataarisa.pimtool.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Number> {
}
