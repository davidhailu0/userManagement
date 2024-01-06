package com.example.userManagement.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserRole{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userrole_seq")
    @SequenceGenerator(sequenceName = "userrole_seq", allocationSize = 1, name = "userrole_seq")
    Long id;
    @OneToOne
    @JoinColumn(name="role_id")
    Role role;
    @OneToOne
    @JoinColumn(name="user_id")
    Users user;
    @ManyToOne
    @JoinColumn(name = "assigned_by_id")
    Users assigned_by;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    Users updated_by;
    Timestamp created_at;
    Timestamp updated_at;
    String status;

    public UserRole(){

    }
}
