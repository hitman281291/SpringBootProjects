package com.hitesh.module2_employee.impl;

import com.hitesh.module2_employee.exception.DepartmentNotFoundException;
import com.hitesh.module2_employee.model.Department;
import com.hitesh.module2_employee.repository.DepartmentRepository;
import com.hitesh.module2_employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Department dept = departmentRepository.findById(id);
        if (dept == null) {
            throw new DepartmentNotFoundException("Department with id " + id + " not found");
        }
        return dept;
    }

    public Department saveDepartment(Department department) {
        if (department.getId() != null) {
            // trying to update — must exist
            Department existing = departmentRepository.findById(department.getId());
            if (existing == null) {
                // throw the custom exception (not a plain RuntimeException)
                throw new DepartmentNotFoundException("Department with id " + department.getId() + " not found");
            }
        }
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department)
    {
        Department existing = departmentRepository.findById(id);
        if (existing == null) {
            System.out.println("Department not found for id: "+id);
            throw new DepartmentNotFoundException();
        }
        else
        {
            department.setId(id);
            department.setCreatedAt(existing.getCreatedAt());
            Department result = departmentRepository.save(department);
            return result;
        }
    }

    public void deleteDepartment(Long id) {

       Department departmentId = departmentRepository.findById(id);
       if (departmentId == null){
           throw new DepartmentNotFoundException("Department with id " + id + " not found");
       }
       else{
           departmentRepository.deleteById(id);
       }

    }

}
