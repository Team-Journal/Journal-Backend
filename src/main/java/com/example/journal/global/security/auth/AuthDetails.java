package com.example.journal.global.security.auth;

import com.example.journal.domain.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@RequiredArgsConstructor
public class AuthDetails implements UserDetails {
    private final User user;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getAuthority().name()));
        return authorities;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public String getUsername(){
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
