package com.stefanini.appointmentapp.security.userdetails;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CustomUserDetailsFactory {
    public CustomUserDetailsFactory() {
    }

    public static CustomUserDetails create(User user) {
        return new CustomUserDetails(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getStatus()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> userRoles) {
        return userRoles.stream()
                .map(role-> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }
}
