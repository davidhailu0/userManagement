package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.HajjUser;

@Repository
public interface HajjRepo extends JpaRepository<HajjUser,Long> {
    
}
