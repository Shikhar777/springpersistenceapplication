package com.example.springpersistence.service.impl;

import com.example.springpersistence.dto.DepartmentRequestDto;
import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.entity.Department;
import com.example.springpersistence.entity.Employee;
import com.example.springpersistence.repository.DepartmentRepository;
import com.example.springpersistence.repository.EmployeeRepository;
import com.example.springpersistence.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public Department getDepartmentById(Long id)
    {
        return departmentRepository.findById(id).get();
    }

    @Transactional
    @Override
    public DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto)
    {
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);
        department.setDepartmentName(departmentRequestDto.getDepartmentName());
        Department savedDepartment = departmentRepository.save(department);

        employeeList.forEach(employee -> {
            employee.setEmployeeCode(departmentRequestDto.getDepartmentCode());
        });
        employeeRepository.saveAll(employeeList);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDto);
        return departmentResponseDto;
    }
}
