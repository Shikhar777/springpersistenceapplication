package com.example.springpersistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDto {

    private Long id;
    private String departmentName;
    private String departmentCode;
    private Integer depYearsOfExperience;
}
