package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    public AuthenticationController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Loggable
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto) {
		try {
			return ResponseEntity
		            .status(HttpStatus.CREATED)                 
		            .body(((UserDetailsServiceImpl)userDetailsService).login(requestDto));
		} catch (AuthenticationException e) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body("Invalid username or password");
		}
    }

    @Loggable
    @PostMapping("/sign-out")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContext = new SecurityContextLogoutHandler();
        securityContext.logout(request, response, null);
    }
}
