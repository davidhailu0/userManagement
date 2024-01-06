package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.UserDetail;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail,Long> {
    
}
