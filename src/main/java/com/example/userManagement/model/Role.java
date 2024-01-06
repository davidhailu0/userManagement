package com.example.userManagement.model;

import java.sql.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(sequenceName = "role_seq", allocationSize = 1, name = "role_seq")
    Long id;
    String name;
    String description;
    String status;
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    Users created_by;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    Users updated_by;
    Timestamp created_at;
    Timestamp updated_at;

    public Role(){

    }
}
