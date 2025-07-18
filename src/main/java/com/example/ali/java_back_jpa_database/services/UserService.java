package com.example.ali.java_back_jpa_database.services;

import com.example.ali.java_back_jpa_database.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

}
