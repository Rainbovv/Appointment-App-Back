package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private UserDetailsService userDetailsService;

    public AuthenticationController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Loggable
    @PostMapping("/login")
    public AuthenticationResponseDto login(@RequestBody AuthenticationRequestDto requestDto) {
        return ((UserDetailsServiceImpl)userDetailsService).login(requestDto);
    }

    @Loggable
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContext = new SecurityContextLogoutHandler();
        securityContext.logout(request, response, null);
    }
}
