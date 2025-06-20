package com.example.ali.java_back_jpa_database.entities;

import com.example.ali.java_back_jpa_database.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty(message = "{NotEmpty.product.name}")
    @IsRequired(message = "{NotEmpty.product.name}")
    private String name;

    @Min(500)
    @NotNull
    private Double price;

//    @NotBlank(message = "{NotBlank.product.description}")
    @IsRequired()
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
