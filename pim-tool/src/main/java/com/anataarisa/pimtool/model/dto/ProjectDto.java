package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {
    @NotEmpty(message = "ID field should not be null")
    @Max(value = 19, message ="Project ID isn't valid")
    private Long id;

    @NotEmpty(message = "Group ID field should not be null")
    @Max(value = 19, message ="Group ID isn't valid")
    private Long groupId;

    @NotEmpty(message = "Project Number field should not be null")
    @Max(value = 19, message ="Project Number isn't valid")
    private Long projectNumber;

    @NotEmpty(message = "Project Name field should not be empty")
    @Min(value = 3, message = "Project Name length field should longer than 3 characters")
    @Max(value = 19, message ="Project Name isn't valid")
    private String name;

    @NotEmpty(message = "Customer Name field should not be empty")
    @Min(value = 3, message ="Customer Name length field should longer than 3 characters")
    @Max(value = 50, message = "Customer Name length field shouldn't more than 50 characters")
    private String customer;

    private String status;

    @NotNull(message = "Start Date field should not be null")
    private Date startDate;

    private Date endDate;

    @Max(value = 10, message ="Project ID isn't valid")
    private Long version;

    private List<String> employeeVisa;
}
