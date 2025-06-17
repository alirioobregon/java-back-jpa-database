package com.example.ali.java_back_jpa_database;

import com.example.ali.java_back_jpa_database.entities.Person;
import com.example.ali.java_back_jpa_database.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JavaBackJpaDatabaseApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaBackJpaDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Person> personList = (List<Person>) personRepository.findByProgrammingLanguage("Kotlin");
//        List<Person> personList = (List<Person>) personRepository.findAll();

        personList.forEach(person -> {
            System.out.println(person.getProgrammingLanguage());
        });
    }
}
