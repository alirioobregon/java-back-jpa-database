package com.example.ali.java_back_jpa_database.services;

import com.example.ali.java_back_jpa_database.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);

    Optional<Product> delete(Product product);
}
