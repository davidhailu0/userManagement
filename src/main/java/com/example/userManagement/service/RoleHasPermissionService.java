package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.RoleHasPermission;
import com.example.userManagement.repository.RoleHasPermissionRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleHasPermissionService {
    @Autowired
    RoleHasPermissionRepo roleHasPermissionRepo;

    public List<RoleHasPermission> getAllRolesWithPermissions(){
        return roleHasPermissionRepo.findAll();
    }

    public Optional<RoleHasPermission> getRoleHasPermissionById(Long id){
        return roleHasPermissionRepo.findById(id);
    }

    public RoleHasPermission saveRoleHasPermission(RoleHasPermission roleHasPermission){
        return roleHasPermissionRepo.save(roleHasPermission);
    }

    public Optional<RoleHasPermission> updateRoleWithPermission(Long id, RoleHasPermission roleHasPermission) {
        if(!roleHasPermissionRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"RoleHasPermission with ID of "+id.toString()+" Not Found");
        }
        return Optional.of(roleHasPermissionRepo.save(roleHasPermission));
    }
}
