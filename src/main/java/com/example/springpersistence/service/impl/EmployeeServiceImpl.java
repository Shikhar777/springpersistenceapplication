package com.example.springpersistence.service.impl;

import com.example.springpersistence.dto.DepartmentResponseDto;
import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponseDto;
import com.example.springpersistence.entity.Department;
import com.example.springpersistence.entity.Employee;
import com.example.springpersistence.repository.DepartmentRepository;
import com.example.springpersistence.repository.EmployeeRepository;
import com.example.springpersistence.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto, employee);
        Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDto.getDepartment().getId());
        if(departmentOptional.isPresent())
        {
            employee.setDepartment(departmentOptional.get());
        }
        else {
            Department department = new Department();
            department.setDepartmentName(employeeRequestDto.getDepartment().getDepartmentName());
            employee.setDepartment(department);
        }
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee, employeeResponseDto);
//        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
//        departmentResponseDto.setId(savedEmployee.getDepartment().getId());
//        departmentResponseDto.setDepartmentName(savedEmployee.getDepartment().getDepartmentName());
        employeeResponseDto.setDepartmentFromEntity(employee.getDepartment());
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto findById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), employeeResponseDto);
            employeeResponseDto.setDepartmentFromEntity(employeeOptional.get().getDepartment());
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
            employee.setFirstName(employeeRequestDto.getFirstName());
            employee.setLastName(employeeRequestDto.getLastName());
            Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDto.getDepartment().getId());
            if(departmentOptional.isPresent())
            {
                employee.setDepartment(departmentOptional.get());
            }
            else {
                Department department = new Department();
                department.setDepartmentName(employeeRequestDto.getDepartment().getDepartmentName());
                employee.setDepartment(department);
            }
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
            employeeResponseDto.setDepartmentFromEntity(employeeOptional.get().getDepartment());
            employeeRepository.deleteById(id);
            return employeeResponseDto;
        } else {
            return null;
        }
    }

    @Override
    public List<EmployeeResponseDto> getEmployeeListByDepartment(long departmentId)
    {
//        Department department = departmentRepository.findById(departmentId).get();
//        List<Employee> employeeList = employeeRepository.findByDepartment(department);
        //List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);
        //List<Employee> employeeList = employeeRepository.findEmployeeListByDepartmentId(departmentId);
        List<Employee> employeeList = employeeRepository.findEmployeeListByNativeQuery(departmentId);
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();
        for(Employee employee : employeeList)
        {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee, employeeResponseDto);
            employeeResponseDto.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDtoList.add(employeeResponseDto);
        }
        return employeeResponseDtoList;
    }
}
