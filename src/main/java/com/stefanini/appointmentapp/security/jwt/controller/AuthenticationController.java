package com.stefanini.appointmentapp.security.jwt.controller;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.security.jwt.dto.AuthenticationRequestDTO;
import com.stefanini.appointmentapp.security.jwt.dto.AuthenticationResponseDTO;
import com.stefanini.appointmentapp.security.jwt.JwtTokenProvider;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api/users")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO requestDTO) {
        try {
            String username = requestDTO.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    requestDTO.getPassword()));

            User user = userService.findByLogin(username);

            if (user == null)
                throw new UsernameNotFoundException("User with login: " + username + " not found!");

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            AuthenticationResponseDTO response = new AuthenticationResponseDTO(username, token);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid login or password");
        }
    }
}
