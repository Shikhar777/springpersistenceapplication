package com.example.springpersistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {

    private long id;
    private  String firstName;
    private String lastName;
    private String departmentName;
}
