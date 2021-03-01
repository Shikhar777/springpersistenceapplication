package com.example.springpersistence.controller;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Department;
import com.example.springpersistence.service.DepartmentService;
import com.example.springpersistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto)
    {
        return departmentService.createDepartment(departmentRequestDto);
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id)
    {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping(value = "/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequestDto departmentRequestDto)
    {
        return departmentService.updateDepartment(departmentId, departmentRequestDto);
    }

    @GetMapping(value = "/{departmentId}/employee/mostExperienced")
    public List<EmployeeResponseDto> findMostExperiencedEmployeeWithinDepartment(@PathVariable("departmentId") Long departmentId)
    {
        return departmentService.findMostExperiencedEmployeeWithinDepartment(departmentId);
    }

    @GetMapping(value = "/mostExperienced")
    public List<Department> findMaxExperienceSumDepartment()
    {
        return departmentService.findMaxExperienceSumDepartment();
    }
}
