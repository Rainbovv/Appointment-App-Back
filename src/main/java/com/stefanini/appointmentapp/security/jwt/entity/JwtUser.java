package com.stefanini.appointmentapp.security.jwt.entity;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(User user) {
        this.user = user;
        this.authorities = convertAuthorities(user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
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
        return user.getStatus() == 0;
    }

    private Collection<GrantedAuthority> convertAuthorities(Collection<UserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }
}
