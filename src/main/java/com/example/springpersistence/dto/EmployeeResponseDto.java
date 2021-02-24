package com.example.springpersistence.dto;

import com.example.springpersistence.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {

    private long id;
    private  String firstName;
    private String lastName;

    private DepartmentResponseDto department;

    public void setDepartmentFromEntity(Department departmentEntity)
    {
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(departmentEntity.getId());
        departmentResponseDto.setDepartmentName(departmentEntity.getDepartmentName());
        this.department = departmentResponseDto;
    }
}
