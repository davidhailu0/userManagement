package com.example.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.model.HajjUser;
import com.example.userManagement.service.HajjService;

import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RequestMapping("/api/v1/hajjList")
@RestController
public class HajjController {
    @Autowired
    HajjService hajjService;

    @GetMapping
    public List<HajjUser> getAllHajjUser(){
        return hajjService.getAllHajjList();
    }

    @GetMapping("/{id}")
    public Optional<HajjUser> getHajjUserById(@PathVariable Long id){
        return hajjService.getHajjUserById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HajjUser registerUserInfo(@Valid @RequestBody HajjUser hajjUser){
        return hajjService.saveHajjUser(hajjUser);
    }
    @PutMapping("/{id}")
    public Optional<HajjUser> updateUserInfo(@RequestBody HajjUser hajjUser,@PathVariable Long id){
        if(!hajjService.exists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Hajj User Found");
        }
      return Optional.ofNullable(hajjService.saveHajjUser(hajjUser));
    }
}
