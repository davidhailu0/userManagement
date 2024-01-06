package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.Permission;
import com.example.userManagement.repository.PermissionRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PermissionService {
    @Autowired
    PermissionRepo permissionRepo;

    public List<Permission> getAllPermission(){
        return permissionRepo.findAll();
    }

    public Optional<Permission> getPermissionById(Long id){
        return permissionRepo.findById(id);
    }

    public Permission savePermission(Permission permissionInfo){
        return permissionRepo.save(permissionInfo);
    }

    public Optional<Permission> updatePermission(Long id,Permission updatedPermission){
        if(!permissionRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Permission with ID of "+id.toString()+" not found");
        }
        return Optional.of(permissionRepo.save(updatedPermission));
    }
}
