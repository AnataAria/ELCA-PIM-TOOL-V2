package com.anataarisa.pimtool.service;

import com.anataarisa.pimtool.model.entity.Group;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface GroupService {
    public Optional<Group> findGroupById(Number groupId) throws EntitySearchNotFoundException;
}
