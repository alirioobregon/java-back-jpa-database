package com.example.ali.java_back_jpa_database.repositories;

import com.example.ali.java_back_jpa_database.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {


    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);


}
