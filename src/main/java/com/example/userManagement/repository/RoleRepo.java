package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    
}
