package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Long>{
    
}
