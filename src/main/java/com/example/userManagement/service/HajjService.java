package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.HajjUser;
import com.example.userManagement.repository.HajjRepo;

@Service
public class HajjService{
    @Autowired
    HajjRepo hajjRepo;

    @PostConstruct
    void addHajjUser(){
        hajjRepo.save(new HajjUser("FJB2309401974788", "Mubarikn", "Eo5PJmNz", "MOHAMED", "AMIN", "JEMAL", "0911623221", "EP73637", "04/22/1985", "Regular", true, 10.00, "FTU", "002", "PiassaNur", "Eo5PJmNz", "ELIYAS GIRMA MOHAMMED ", "002FTRQ230940022", "0016688920101", "10", "00166889", null, "04/04/2023", "04/04/2023", "JUHART", "0", "ABASBE", "04-APR-2023", "001", "ETB", "04-APR-23 03.36.01.418488 PM"));
    }
    public List<HajjUser> getAllHajjList(){
        return hajjRepo.findAll();
    }

    public Optional<HajjUser> getHajjUserById(Long id){
        return hajjRepo.findById(id);
    }

    public boolean exists(Long id){
        return hajjRepo.existsById(id);
    }
    public HajjUser saveHajjUser(HajjUser hajjUser){
        return hajjRepo.saveAndFlush(hajjUser);
    }

}