package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.Role;
import com.example.userManagement.service.RoleService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Role registerNewRole(@Valid @RequestBody Role role){
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    public Optional<Role> updateRole(@RequestBody Role role,@PathVariable Long id){
        return roleService.updateRole(id,role);
    }
}
