package com.example.userManagement.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.userManagement.config.UserDetailInfo;
import com.example.userManagement.model.Branch;
import com.example.userManagement.model.Role;
import com.example.userManagement.model.UserRole;
import com.example.userManagement.repository.UserRoleRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.Users;
import com.example.userManagement.repository.UsersRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    UsersRepo userRepo;

    @Autowired
    UserRoleRepo userRoleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    void addUser(){
        userRepo.save(new Users("dawit","1234",passwordEncoder.encode("1234"),null,null,null,Timestamp.valueOf(LocalDateTime.now()),Timestamp.valueOf(LocalDateTime.now()),"Active"));
        userRepo.save(new Users("abdi","1234",passwordEncoder.encode("1234"),null,null,null,Timestamp.valueOf(LocalDateTime.now()),Timestamp.valueOf(LocalDateTime.now()),"Active"));
    }
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<Users> getUserById(Long id){
        return userRepo.findById(id);
    }

    public Users saveUser(Users userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userRepo.save(userInfo);
    }

    public Optional<Users> updateUser(Long id,Users updatedUser){
        if(!userRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User With ID of "+id.toString()+" Not Found");
        }
        Users user = userRepo.findById(id).get();
        if(!user.getPassword().equals(updatedUser.getPassword())){
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        return Optional.of(userRepo.save(updatedUser));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepo.findUsersByUsername(username);
        if(user.isPresent()){
            Optional<UserRole> role = userRoleRepo.findByUser(user.get());
            return role.map(value -> new UserDetailInfo(user.get())).orElseGet(() -> new UserDetailInfo(user.get()));
        }
        throw new UsernameNotFoundException("Username "+username+" Not Found");
    }
}
