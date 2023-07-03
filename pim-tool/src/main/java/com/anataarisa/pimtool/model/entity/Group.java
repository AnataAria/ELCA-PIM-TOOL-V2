package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "decimal")
    private Number id;
    @OneToOne(targetEntity = Employee.class, fetch = FetchType.LAZY, mappedBy = "ID")
    private Employee leader;
    @Column(name = "VERSION", nullable = false, columnDefinition = "decimal")
    private Number version;
}
