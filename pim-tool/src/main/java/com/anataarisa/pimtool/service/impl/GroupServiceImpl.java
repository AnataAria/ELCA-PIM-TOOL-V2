package com.anataarisa.pimtool.service.impl;

import com.anataarisa.pimtool.model.entity.Group;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.repository.GroupRepository;
import com.anataarisa.pimtool.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }


    @Override
    public Optional<Group> findGroupById(Number groupId) throws EntitySearchNotFoundException {
        Optional<Group> group = groupRepository.findById(groupId);
        if(group.isEmpty()) throw new EntitySearchNotFoundException("Can't find this group ID");
        return group;
    }
}
