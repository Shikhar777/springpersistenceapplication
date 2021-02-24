package com.example.springpersistence.controller;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.entity.Department;
import com.example.springpersistence.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
