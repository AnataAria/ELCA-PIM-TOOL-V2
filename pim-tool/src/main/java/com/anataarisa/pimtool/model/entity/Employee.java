package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;
    @Column(name = "VISA", nullable = false)
    private String visa;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDay;
    @Column(name = "VERSION", columnDefinition = "bigint", nullable = false)
    private Long version;

    public Employee(String visa, String firstName, String lastName, Date birthDay, Long version) {
        this.visa = visa;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.version = version;
    }
}
