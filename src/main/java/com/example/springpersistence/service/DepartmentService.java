package com.example.springpersistence.service;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.entity.Department;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);
    Department getDepartmentById(Long id);
    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);
}
