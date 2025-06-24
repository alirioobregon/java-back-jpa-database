package com.example.ali.java_back_jpa_database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    private String name;

    private String document;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    public Client(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
