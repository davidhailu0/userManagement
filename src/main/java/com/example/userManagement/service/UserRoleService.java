package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.UserRole;
import com.example.userManagement.repository.UserRoleRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepo userRoleRepo;

    public List<UserRole> getAllUserRole(){
        return userRoleRepo.findAll();
    }

    public Optional<UserRole> getUserRoleById(Long id){
        return userRoleRepo.findById(id);
    }

    public UserRole saveUserRole(UserRole userRole){
        return userRoleRepo.save(userRole);
    }

    public Optional<UserRole> updateUserRole(Long id,UserRole userRole){
        if(!userRoleRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Role With ID of "+id.toString()+" Not Found");
        }
        return Optional.of(userRoleRepo.save(userRole));
    }
}
