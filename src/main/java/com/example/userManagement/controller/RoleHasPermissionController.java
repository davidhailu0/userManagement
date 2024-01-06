package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.RoleHasPermission;
import com.example.userManagement.service.RoleHasPermissionService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/rolesHasPermission")
public class RoleHasPermissionController {
    @Autowired
    RoleHasPermissionService roleHasPermissionService;

    @GetMapping
    public List<RoleHasPermission> getAllRolesWithPermissions(){
        return roleHasPermissionService.getAllRolesWithPermissions();
    }

    @GetMapping("/{id}")
    public Optional<RoleHasPermission> getRolesWithPermissionById(@PathVariable Long id){
        return roleHasPermissionService.getRoleHasPermissionById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RoleHasPermission registerRoleWithPermission(@Valid @RequestBody RoleHasPermission roleHasPermission){
        return roleHasPermissionService.saveRoleHasPermission(roleHasPermission);
    }

    @PutMapping("/{id}")
    public Optional<RoleHasPermission> updateRoleWithPermission(@RequestBody RoleHasPermission roleHasPermission,@PathVariable Long id){
        return roleHasPermissionService.updateRoleWithPermission(id,roleHasPermission);
    }
}
