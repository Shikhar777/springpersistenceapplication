package com.example.springpersistence.service;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Employee;

public interface EmployeeService {

    EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(long id);
    EmployeeResponseDto updateEmployee(long id, EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteById(long id);
}
