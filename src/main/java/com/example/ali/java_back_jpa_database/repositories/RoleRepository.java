package com.example.ali.java_back_jpa_database.repositories;

import com.example.ali.java_back_jpa_database.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
