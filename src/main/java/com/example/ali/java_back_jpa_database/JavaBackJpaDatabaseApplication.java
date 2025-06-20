package com.example.ali.java_back_jpa_database;

import com.example.ali.java_back_jpa_database.entities.Person;
import com.example.ali.java_back_jpa_database.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JavaBackJpaDatabaseApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaBackJpaDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        create();
    }

    @Transactional
    public void create() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String lastName = scanner.next();
        String document = scanner.next();
        String programming = scanner.next();
        scanner.close();

        Person person = new Person(null, name, lastName, document, programming);
        Person newPerson = personRepository.save(person);
        System.out.println(newPerson);
    }

    public void findData() {
        List<Person> personList = (List<Person>) personRepository.findByProgrammingLanguage("Kotlin");
//        List<Person> personList = (List<Person>) personRepository.findAll();

        personList.forEach(person -> {
            System.out.println(person.getProgrammingLanguage());
        });
    }
}
