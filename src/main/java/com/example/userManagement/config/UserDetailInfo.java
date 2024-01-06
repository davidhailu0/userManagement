package com.example.userManagement.config;

import com.example.userManagement.model.Role;
import com.example.userManagement.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetailInfo implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    private String status;

    public UserDetailInfo(Users user){
        username = user.getUsername();
        password = user.getPassword();
//        authorities = Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
        status = user.getStatus();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
