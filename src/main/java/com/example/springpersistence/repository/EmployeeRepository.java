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

    // exercise first part
    @Query(value = "SELECT * FROM feb_intern_employee e WHERE e.years_of_experience IN (SELECT MAX(years_of_experience) " +
            "FROM feb_intern_employee)", nativeQuery = true)
    List<Employee> getMostExperiencedEmployee();

    //exercise second part
    @Query(value = "SELECT * FROM feb_intern_employee e WHERE e.years_of_experience IN (SELECT MAX(e.years_of_experience) FROM feb_intern_employee e WHERE e.department_id = ?1) and e.department_id = ?1", nativeQuery = true)
    List<Employee> getMostExperiencedEmployeeWithinDepartment(Long departmentId);

    //exercise third part
    @Query(value = "SELECT MAX(sum) FROM (SELECT SUM(years_of_experience) FROM feb_intern_employee e GROUP BY e.department_id) as A", nativeQuery = true)
    Long getMaxExperienceSum();
    @Query(value = "SELECT e.department_id FROM feb_intern_employee e GROUP BY e.department_id HAVING SUM(e.years_of_experience) = ?1", nativeQuery = true)
    List<Long> getMaxExperienceSumDepartment(Long experienceSum);

}
