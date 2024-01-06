package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userManagement.model.UserDetail;
import com.example.userManagement.repository.UserDetailRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserDetailService {
    @Autowired
    UserDetailRepo userDetailRepo;

    public List<UserDetail> getAllUserDetail(){
        return userDetailRepo.findAll();
    }

    public Optional<UserDetail> getUserDetailById(@PathVariable Long id){
        return userDetailRepo.findById(id);
    }

    public UserDetail saveUserDetail(UserDetail userDetail){
        return userDetailRepo.save(userDetail);
    }

    public Optional<UserDetail> updateUserDetail(Long id,UserDetail userDetail){
       if(!userDetailRepo.existsById(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Detail With ID of "+id.toString()+" Not Found");
       }
       return Optional.of(userDetailRepo.save(userDetail));
    }
}
