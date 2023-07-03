package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Number id;
    @OneToOne(targetEntity = Group.class, fetch = FetchType.LAZY, mappedBy = "ID")
    private Group groupProject;
    @Column(name="PROJECT_NUMBER", )
    private Number projectNumber;
    private String name;
    @ManyToMany(
            targetEntity = Employee.class,
            fetch = FetchType.LAZY
    )
    @JoinTable(name="PROJECT_EMPLOYEE"
    , joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
    inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
    private Set<Employee> employees;
    private String customer;
    private String status;
    private Date startDate;
    private Date endDate;
    private Number version;

}
