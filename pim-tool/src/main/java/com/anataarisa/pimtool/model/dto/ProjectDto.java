package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private Long groupId;
    private Long projectNumber;
    private String name;
    private String customer;
    private String status;
    private Date startDate;
    private Date endDate;
    private Long version;
    private List<String> employeeVisa;
}
