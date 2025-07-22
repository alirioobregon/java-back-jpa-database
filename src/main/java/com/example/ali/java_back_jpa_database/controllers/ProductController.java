package com.example.ali.java_back_jpa_database.controllers;


import com.example.ali.java_back_jpa_database.ProductValidation;
import com.example.ali.java_back_jpa_database.entities.Product;
import com.example.ali.java_back_jpa_database.services.ProductService;
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
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080",originPatterns = "*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

//    @Autowired
//    private ProductValidation productValidation;

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
//        productValidation.validate(product, result);
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Product productNew = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Product product, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()){
            return validation(result);
        }
        product.setId(id);
        Optional<Product> update = service.update(id, product);
        if (update.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(update.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
//        Product newProduct = new Product();
//        newProduct.setId(id);
        Optional<Product> productOptional = service.delete(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
