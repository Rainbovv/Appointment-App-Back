package com.stefanini.appointmentapp.security.userdetails;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.security.jwt.JwtTokenProvider;
import com.stefanini.appointmentapp.service.UserProfileService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserProfileService profileService;


    public UserDetailsServiceImpl(AuthenticationManager authenticationManager,
                                  JwtTokenProvider jwtTokenProvider,
                                  UserProfileService profileService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.profileService = profileService;
    }

    @Loggable
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserProfile profile =  profileService.findByLogin(login);

        if (profile == null) {
            throw new UsernameNotFoundException("User with login " + login + " not exists");
        }

        return CustomUserDetailsFactory.create(profile);
    }

    public AuthenticationResponseDto login(AuthenticationRequestDto requestDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(requestDto.getLogin(),
                        requestDto.getPassword()));

        return jwtTokenProvider.createToken(authentication);
    }

}
