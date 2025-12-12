package com.hitesh.module2_employee.repository;

import com.hitesh.module2_employee.model.Department;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDepartmentRepository implements DepartmentRepository {

    private final Map<Long, Department> storage = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<Department> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Department findById(Long id) {
        return storage.get(id);
    }

    @Override
    public Department save(Department department) {

        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }

        // ===== CREATE =====
        if (department.getId() == null) {
            long id = idGenerator.incrementAndGet();
            department.setId(id);
            department.setCreatedAt(LocalDateTime.now());
            storage.put(id, department);

            // keep generator in sync
            idGenerator.updateAndGet(curr -> Math.max(curr, id));

            return department;
        }

        // ===== UPDATE =====
        Department existing = storage.get(department.getId());
        if (existing != null) {

            // preserve createdAt from existing record
            department.setCreatedAt(existing.getCreatedAt());

            storage.put(department.getId(), department);

            // keep generator consistent
            idGenerator.updateAndGet(curr -> Math.max(curr, department.getId()));

            return department;
        }

        // ===== NOT FOUND =====
        throw new RuntimeException("Department not found");
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}
