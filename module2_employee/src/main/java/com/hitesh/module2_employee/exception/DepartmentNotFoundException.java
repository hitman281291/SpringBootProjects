package com.hitesh.module2_employee.exception;

/**
 * Simple runtime exception used to indicate "department not found".
 * This is NOT a Spring bean and must NOT be annotated with @Component etc.
 */
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
        super("Department not found");
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
