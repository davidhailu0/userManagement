package com.example.userManagement.repository;

import com.example.userManagement.model.Role;
import com.example.userManagement.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.UserRole;

import java.util.Optional;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
    Optional<UserRole> findByUser(Users user);
}