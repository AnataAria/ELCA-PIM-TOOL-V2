package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    @NotEmpty(message = "ID field should not be empty")
    @Max(value = 19, message ="Employee ID isn't valid")
    private Long id;
    @NotEmpty(message = "Visa field should not be empty")
    @Size(min = 3, max = 3, message = "Visa field should have 3 characters")
    private String visa;
    @NotEmpty(message = "First Name field should not be empty")
    @Size(min=3, max=50, message = "First name field length should be between 3 and 50")
    private String firstName;
    @NotEmpty(message = "Last Name field should not be empty")
    @Size(min=3, max=50, message = "Last name field length should be between 3 and 50")
    private String lastName;
    @NotNull(message = "Birthday field should not be empty")
    private Date birthDate;
    @NotEmpty(message = "Version field should not be empty")
    @Max(value = 10, message ="Version isn't valid")
    private Long version;
}
