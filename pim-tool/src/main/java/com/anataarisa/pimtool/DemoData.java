package com.anataarisa.pimtool;

import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.entity.Group;
import com.anataarisa.pimtool.repository.EmployeeRepository;
import com.anataarisa.pimtool.repository.GroupRepository;
import com.anataarisa.pimtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
@Component
public class DemoData {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final GroupRepository groupRepository;
    @Autowired
    public DemoData(EmployeeRepository employeeRepository, ProjectRepository projectRepository, GroupRepository groupRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.groupRepository = groupRepository;
    }

    public void addEmployee(){
        Number a = 1;
        Employee e = new Employee(
                "AAA",
                "Nguyen",
                "Quang Vinh",
                Date.valueOf("2003-06-09"),
                1L
        );
        Employee b = new Employee(
                "BBB",
                "Nguyen",
                "Arisa",
                Date.valueOf("2003-06-09"),
                1L
        );
        Employee c = new Employee(
                "CCC",
                "Nguyen",
                "Anata",
                Date.valueOf("2003-06-09"),
                1L
        );
        employeeRepository.saveAll(List.of(e,b,c));
    }

    public void addGroup(){
        Group a = new Group(
                1L,
                new Employee(
                        1L,
                        "AAA",
                        "Nguyen",
                        "Quang Vinh",
                        Date.valueOf("2003-06-09"),
                        1L
                ),
                1L
        );
        Group b = new Group(
                2L,
                new Employee(
                        1L,
                        "AAA",
                        "Nguyen",
                        "Quang Vinh",
                        Date.valueOf("2003-06-09"),
                        1L
                ),
                2L
        );
        Group c = new Group(
                3L,
                new Employee(
                        1L,
                        "AAA",
                        "Nguyen",
                        "Quang Vinh",
                        Date.valueOf("2003-06-09"),
                        1L
                ),
                3L
        );
        groupRepository.saveAll(List.of(a,b,c));
    }
}
