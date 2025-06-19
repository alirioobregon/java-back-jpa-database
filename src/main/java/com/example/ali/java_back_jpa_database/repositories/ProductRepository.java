package com.example.ali.java_back_jpa_database.repositories;

import com.example.ali.java_back_jpa_database.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
