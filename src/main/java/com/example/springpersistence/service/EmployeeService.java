package com.example.springpersistence.service;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteById(Long id);
    List<EmployeeResponseDto> getEmployeeListByDepartment(Long departmentId);
    List<EmployeeResponseDto> findMostExperiencedEmployee();
}
