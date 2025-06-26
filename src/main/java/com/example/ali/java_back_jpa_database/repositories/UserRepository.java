package com.example.ali.java_back_jpa_database.repositories;

import com.example.ali.java_back_jpa_database.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
