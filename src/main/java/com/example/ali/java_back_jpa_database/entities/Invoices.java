package com.example.ali.java_back_jpa_database.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double total;

    @JoinColumn(name = "id_client")
    @ManyToOne
    private Client client;

    public Invoices() {

    }

    public Invoices(String description, Double total) {
        this.description = description;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
