package com.example.ali.java_back_jpa_database.services;

import com.example.ali.java_back_jpa_database.entities.Product;
import com.example.ali.java_back_jpa_database.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productOptional = repository.findById(product.getId());
        productOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productOptional;
    }
}
