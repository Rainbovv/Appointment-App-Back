package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;
import com.stefanini.appointmentapp.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.UnexpectedRollbackException;
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

    @Loggable
    @PostMapping(value = "/auth/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody RegistrationRequestDto requestDto) {    	
    	try {
    		userService.create(requestDto);
			return ResponseEntity
		            .status(HttpStatus.CREATED)                 
		            .body(((UserDetailsServiceImpl) userDetailsService).login(new AuthenticationRequestDto(requestDto.getLogin(), requestDto.getPassword())));
		} catch (UnexpectedRollbackException e) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body("User with this email already exists");
		}
    }
}
