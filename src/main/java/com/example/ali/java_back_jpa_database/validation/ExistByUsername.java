package com.example.ali.java_back_jpa_database.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByUsername {
    String message() default "Ya existe en la Base de datos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
