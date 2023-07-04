package com.anataarisa.pimtool.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;
    @OneToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
    private Employee leader;
    @Column(name = "VERSION", nullable = false, columnDefinition = "bigint")
    private Long version;
}
