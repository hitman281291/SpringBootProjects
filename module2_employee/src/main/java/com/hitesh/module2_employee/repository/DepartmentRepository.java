package com.hitesh.module2_employee.repository;

import com.hitesh.module2_employee.model.Department;

import java.util.List;

public interface DepartmentRepository {

    //get all departments
    List<Department> findAll();

    //get all departments based on ID
    Department findById(Long id);

    //save department
    Department save(Department department);

    //Delete department
    void deleteById(Long id);
}
