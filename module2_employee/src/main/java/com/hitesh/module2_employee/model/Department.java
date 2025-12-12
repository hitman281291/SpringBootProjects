package com.hitesh.module2_employee.model;

import com.hitesh.module2_employee.validation.Prime;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Department {

    @Positive
    private Long id;

    @NotBlank(message="title required")
    @Size(min = 2, max = 50)
    private String title;

    @NotNull(message="isActive required")
    private Boolean isActive;

    @PastOrPresent(message="createdAt must be past or present")
    private LocalDateTime createdAt;

    // example prime field
    @Prime(message = "primeCode must be a prime number")
    private Long primeCode;
}