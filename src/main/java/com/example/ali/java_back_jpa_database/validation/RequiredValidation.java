package com.example.ali.java_back_jpa_database.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequiredValidation implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return s != null && !s.isEmpty() && s.isBlank();
        return StringUtils.hasText(s);
    }
}
