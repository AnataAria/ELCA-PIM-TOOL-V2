package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", columnDefinition = "bigint",length=19)
    private Long id;
    @OneToOne(targetEntity = Group.class, fetch = FetchType.LAZY)
    private Group groupProject;
    @Column(name="PROJECT_NUMBER",columnDefinition = "bigint", nullable = false,unique = true,length=19)
    private Long projectNumber;
    @Column(name="NAME", nullable = false, length = 50)
    private String name;
    @ManyToMany(
            targetEntity = Employee.class,
            fetch = FetchType.LAZY
    )
    @JoinTable(name="PROJECT_EMPLOYEE"
    , joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
    inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
    private Set<Employee> employees;
    @Column(name="CUSTOMER", nullable = false, length = 50)
    private String customer;
    @Column(name="STATUS", nullable = false, length = 3)
    private String status;
    @Column(name="START_DATE", nullable = false)
    private Date startDate;
    @Column(name="END_DATE")
    private Date endDate;
    @Column(name="VERSION", columnDefinition = "bigint", nullable = false)
    private Long version;

}
