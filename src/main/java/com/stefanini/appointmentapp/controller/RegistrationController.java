package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RegistrationController {
    private UserDetailsService userDetailsService;
    private UserService userService;

    public RegistrationController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/user/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthenticationResponseDto create(@RequestBody RegistrationRequestDto requestDto) {
        userService.create(requestDto);

        return ((UserDetailsServiceImpl) userDetailsService).login(new AuthenticationRequestDto(requestDto.getLogin(), requestDto.getPassword()));
    }
}
