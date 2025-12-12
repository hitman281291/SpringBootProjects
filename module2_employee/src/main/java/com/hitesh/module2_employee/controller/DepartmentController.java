package com.hitesh.module2_employee.controller;

import com.hitesh.module2_employee.model.Department;
import com.hitesh.module2_employee.service.DepartmentService;
import com.hitesh.module2_employee.validation.Prime;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments()
    {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(
            @PathVariable Long id)
    {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping("/check/{value}")
    public ResponseEntity<String> checkPrime(@Prime @PathVariable Long value) {
        // If validation passes, just return success message.
        return ResponseEntity.ok(value + " is prime (validated)");
    }

    @PostMapping
    public ResponseEntity<Department> saveDepartment(
            @RequestBody @Valid Department department)
    {
        Department saved = departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestBody @Valid Department department)
    {
        department.setId(id);
        Department updated = departmentService.saveDepartment(department);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDepartment(
            @PathVariable Long id)
    {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();

    }

}
