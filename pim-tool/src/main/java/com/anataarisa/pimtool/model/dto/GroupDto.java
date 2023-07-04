package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GroupDto {
    @NotEmpty(message = "Group ID must not be empty")
    @Max(value = 19, message = "Group ID must smaller than 19 characters")
    private Long id;
    @NotEmpty(message = "Group leader ID must not be empty")
    private Long groupNumberId;
    @NotEmpty(message = "Group version must not be empty")
    @Max(value = 19, message = "Group version must smaller than 19 characters")
    private Long version;
}
