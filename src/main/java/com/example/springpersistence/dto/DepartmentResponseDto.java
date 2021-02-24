package com.example.springpersistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// @Data -> instead of @Getter and @Setter we can write @Data
public class DepartmentResponseDto {

    private Long id;
    private String departmentName;
}
