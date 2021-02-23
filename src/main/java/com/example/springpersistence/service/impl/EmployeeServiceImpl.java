package com.example.springpersistence.service.impl;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Employee;
import com.example.springpersistence.repository.EmployeeRepository;
import com.example.springpersistence.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee, employeeResponseDto);
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto findById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), employeeResponseDto);
            return employeeResponseDto;
        } else {
            return null;
        }
    }

    @Override
    public EmployeeResponseDto updateEmployee(long id, EmployeeRequestDto employeeRequestDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setDepartmentName(employeeRequestDto.getDepartmentName());
            Employee savedEmployee = employeeRepository.save(employee);
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(savedEmployee, employeeResponseDto);
            return employeeResponseDto;
        } else {
            return null;
        }
    }

    @Override
    public EmployeeResponseDto deleteById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee, employeeResponseDto);
            employeeRepository.deleteById(id);
            return employeeResponseDto;
        } else {
            return null;
        }
    }
}
