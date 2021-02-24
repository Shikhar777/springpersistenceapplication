package com.example.springpersistence.service;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(long id);
    EmployeeResponseDto updateEmployee(long id, EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteById(long id);
    List<EmployeeResponseDto> getEmployeeListByDepartment(long departmentId);
}
