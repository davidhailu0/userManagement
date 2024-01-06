package com.example.userManagement.model;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RoleHasPermission{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolehas_seq")
    @SequenceGenerator(sequenceName = "rolehas_seq", allocationSize = 1, name = "rolehas_seq")
    Long id;
    @OneToOne
    @JoinColumn(name="role_id")
    Role role;
    @OneToMany
    @JoinColumn(name="permission_id")
    Permission[] permission;
    @OneToOne
    @JoinColumn(name = "created_by_id")
    Users created_by;
    @OneToOne
    @JoinColumn(name = "updated_by_id")
    Users updated_by;
    Timestamp created_at;
    Timestamp updated_at;
    String status;

    public RoleHasPermission(){

    }
}
