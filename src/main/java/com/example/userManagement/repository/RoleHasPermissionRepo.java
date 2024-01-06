package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.RoleHasPermission;

@Repository
public interface RoleHasPermissionRepo extends JpaRepository<RoleHasPermission,Long>{
    
}
