package com.hitesh.module2_employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<Prime, Long> {

    @Override
    public void initialize(Prime constraintAnnotation) {
        // no init required
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // allow null (use @NotNull if you want to force presence)
        if (value == null) return true;

        if (value <= 1) return false;
        if (value == 2) return true;
        if (value % 2 == 0) return false;

        long limit = (long) Math.sqrt(value);
        for (long i = 3; i <= limit; i += 2) {
            if (value % i == 0) return false;
        }
        return true;
    }
}
