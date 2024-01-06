package com.example.userManagement.model;

import java.sql.Timestamp;

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
@Getter
@Setter
public class Permission{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perm_seq")
    @SequenceGenerator(sequenceName = "perm_seq", allocationSize = 1, name = "perm_seq")
    Long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    Users created_by;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    Users updated_by;
    Timestamp created_at;
    Timestamp updated_at;
    String status;

    public Permission(){

    }
}
