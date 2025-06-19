package com.example.ali.java_back_jpa_database.controllers;


import com.example.ali.java_back_jpa_database.entities.Product;
import com.example.ali.java_back_jpa_database.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product productNew = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Optional<Product> update = service.findById(id);
        if (update.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Product newProduct = new Product();
        newProduct.setId(id);
        Optional<Product> productOptional = service.delete(newProduct);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
