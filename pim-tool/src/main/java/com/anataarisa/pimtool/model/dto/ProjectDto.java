package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {

    @NotNull(message = "Group ID field should not be null")
    @Max(value = 19, message ="Group ID size must be smaller than 19")
    private Long groupId;

    @NotNull(message = "Project Number field should not be null")
    @Max(value = 19, message ="Project Number size must be smaller than 19")
    private Long projectNumber;

    @NotEmpty(message = "Project Name field should not be empty")
    @Size(min = 3, max = 50, message = "Project Name field size should be between 3 and 50")
    private String name;

    @NotEmpty(message = "Customer Name field should not be empty")
    @Size(min = 3, max = 50, message = "Customer Name field size should be between 3 and 50")
    private String customer;

    private String status;

    @NotNull(message = "Start Date field should not be null")
    private Date startDate;

    private Date endDate;

    @Max(value = 10, message ="Version size must be smaller than 10")
    private Long version;

    private List<String> employeeVisa;
}
