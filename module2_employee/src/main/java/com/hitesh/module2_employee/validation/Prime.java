package com.hitesh.module2_employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PrimeValidator.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Prime {
    String message() default "must be a prime number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
