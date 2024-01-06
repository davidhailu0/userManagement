package com.example.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userManagement.model.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long>{
    
}
