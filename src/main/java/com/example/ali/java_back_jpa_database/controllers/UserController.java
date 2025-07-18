package com.example.ali.java_back_jpa_database.controllers;

import com.example.ali.java_back_jpa_database.entities.User;
import com.example.ali.java_back_jpa_database.entities.response.ResponseGeneric;
import com.example.ali.java_back_jpa_database.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return validation(result);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        } catch (Exception e) {
            ResponseGeneric responseGeneric = new ResponseGeneric();
            responseGeneric.setError(e.getMessage());
            responseGeneric.setStatusCode(HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(responseGeneric);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        try {
            user.setAdmin(false);
            return create(user, result);
        } catch (Exception e) {
            ResponseGeneric responseGeneric = new ResponseGeneric();
            responseGeneric.setError(e.getMessage());
            responseGeneric.setStatusCode(HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(responseGeneric);
        }
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
