package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String visa;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Long version;
}
