package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor

@Entity(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Number id;
    private String visa;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private Number version;
}
