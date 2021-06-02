package com.stefanini.appointmentapp.security.userdetails;

import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CustomUserDetailsFactory {
    public CustomUserDetailsFactory() {
    }

    public static CustomUserDetails create(UserProfile profile) {

        return new CustomUserDetails(
                profile.getUser().getId(),
                profile.getFirstName(),
                profile.getUser().getLogin(),
                profile.getUser().getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(profile.getUser().getRoles())),
                profile.getUser().getStatus()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> userRoles) {
        return userRoles.stream()
                .map(role-> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }
}
