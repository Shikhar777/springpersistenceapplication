package com.example.springpersistence.controller;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto saveDetails(@RequestBody EmployeeRequestDto employeeRequestDto)
    {
        return employeeService.saveDetails(employeeRequestDto);
    }

    @GetMapping(value = "/{id}")
    public EmployeeResponseDto findById(@PathVariable("id") long id)
    {
        return employeeService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") long id,@RequestBody EmployeeRequestDto employeeRequestDto)
    {
        return employeeService.updateEmployee(id, employeeRequestDto);
    }

    @DeleteMapping(value = "/{id}")
    public EmployeeResponseDto deleteById(@PathVariable("id") long id)
    {
        return  employeeService.deleteById(id);
    }

    @GetMapping(value = "/department/{id}")
    public List<EmployeeResponseDto> getEmployeeListByDepartment(@PathVariable("id") long departmentId)
    {
        return employeeService.getEmployeeListByDepartment(departmentId);
    }
}
