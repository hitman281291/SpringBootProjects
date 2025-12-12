package com.hitesh.module2_employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        // no init required
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // allow null -> combine with @NotBlank/@NotNull when you require presence
        if (value == null) return true;

        if (value.length() < 10) return false;
        boolean hasUpper = value.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = value.chars().anyMatch(Character::isLowerCase);
        boolean hasSpecial = value.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

        return hasUpper && hasLower && hasSpecial;
    }
}
