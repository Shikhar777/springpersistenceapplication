package com.example.springpersistence.repository;


import com.example.springpersistence.entity.Department;
import com.example.springpersistence.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByDepartment(Department department); // method 1
    List<Employee> findByDepartment_Id(Long departmentId); // method 2
    @Query("SELECT e FROM FebInternEmployee e WHERE e.department.id = ?1")
    List<Employee> findEmployeeListByDepartmentId(Long departmentId); // using @Query Annotation

    @Query(value = "SELECT * FROM feb_intern_employee e WHERE e.department_id = ?1" , nativeQuery = true)
    List<Employee> findEmployeeListByNativeQuery(Long departmentId); // using native query


}
