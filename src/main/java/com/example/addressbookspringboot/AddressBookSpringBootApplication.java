package com.example.addressbookspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookSpringBootApplication.class, args);
        System.out.println("Welcome to AddressBook App.");
    }
}
