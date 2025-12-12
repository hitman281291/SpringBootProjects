package com.hitesh.module2_employee.service;

import com.hitesh.module2_employee.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department saveDepartment(Department department);

    Department updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);
}
