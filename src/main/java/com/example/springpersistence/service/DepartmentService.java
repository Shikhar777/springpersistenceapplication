package com.example.springpersistence.service;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);
    Department getDepartmentById(Long id);
    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);
    List<EmployeeResponseDto> findMostExperiencedEmployeeWithinDepartment(Long departmentId);
    List<Department> findMaxExperienceSumDepartment();
}
