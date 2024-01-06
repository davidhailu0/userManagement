package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.Branch;
import com.example.userManagement.service.BranchService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/branch")
public class BranchController{
    @Autowired
    BranchService branchService;
    
    @GetMapping
    public List<Branch> getAllBranches(){
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public Optional<Branch> getBranchById(@PathVariable Long id){
        return branchService.getBranchById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Branch registerNewBranch(@Valid @RequestBody Branch newBranch){
        return branchService.saveBranch(newBranch);
    }

    @PutMapping("/{id}")
    public Optional<Branch> updateBranch(@RequestBody Branch updatedBranch,@PathVariable Long id){
        return branchService.updateBranch(id,updatedBranch);
    }
}