package com.anataarisa.pimtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GroupDto {
    private Long id;
    private Long groupNumberId;
    private Long version;
}
