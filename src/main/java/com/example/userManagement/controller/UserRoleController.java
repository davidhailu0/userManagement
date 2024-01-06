package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.UserRole;
import com.example.userManagement.service.UserRoleService;

import jakarta.validation.Valid;

@CrossOrigin
@RequestMapping("/api/v1/userRole")
@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRole(){
        return userRoleService.getAllUserRole();
    }

    @GetMapping("/{id}")
    public Optional<UserRole> getUserRoleById(@PathVariable Long id){
        return userRoleService.getUserRoleById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserRole registerUserRole(@Valid @RequestBody UserRole userRole){
        return userRoleService.saveUserRole(userRole);
    }

    @PutMapping("/{id}")
    public Optional<UserRole> updateUserRole(@RequestBody UserRole userRole,@PathVariable Long id){
        return userRoleService.updateUserRole(id,userRole);
    }
}
