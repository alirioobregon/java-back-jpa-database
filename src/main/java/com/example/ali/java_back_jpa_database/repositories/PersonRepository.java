package com.example.ali.java_back_jpa_database.repositories;

import com.example.ali.java_back_jpa_database.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p")
    List<Person> searchByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

}
