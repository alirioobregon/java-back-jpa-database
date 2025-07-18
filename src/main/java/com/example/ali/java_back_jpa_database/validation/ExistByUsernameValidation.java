package com.example.ali.java_back_jpa_database.validation;

import com.example.ali.java_back_jpa_database.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistByUsernameValidation implements ConstraintValidator<ExistByUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (userService == null) {
            return true;
        }

        return !userService.existsByUsername(value);
    }
}
