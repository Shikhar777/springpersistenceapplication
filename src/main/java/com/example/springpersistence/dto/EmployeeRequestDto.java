package com.example.springpersistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private Long id;
    private  String firstName;
    private String lastName;
    private String employeeCode;
    private Integer yearsOfExperience;

    private DepartmentRequestDto department;
}
