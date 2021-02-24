package com.example.springpersistence.service.impl;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.entity.Department;
import com.example.springpersistence.repository.DepartmentRepository;
import com.example.springpersistence.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto)
    {
        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDto, department);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDto);
        return departmentResponseDto;
    }

    @Override
    public Department getDepartmentById(long id)
    {
        return departmentRepository.findById(id).get();
    }
}
