package com.example.springpersistence.repository;

import com.example.springpersistence.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
