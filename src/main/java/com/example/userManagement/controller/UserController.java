package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.Users;
import com.example.userManagement.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin
@RequestMapping("api/v1/user")
@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Users registerUser(@Valid @RequestBody Users user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Optional<Users> updateUserInfo(@RequestBody Users user,@PathVariable Long id){
        return userService.updateUser(id,user);
    }
}
