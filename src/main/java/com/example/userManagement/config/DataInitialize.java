package com.example.userManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.userManagement.repository.UsersRepo;

@Component
public class DataInitialize implements CommandLineRunner{

    @Autowired
    UsersRepo userRepository;
    @Override
    public void run(String... args) throws Exception {
        
    }

}