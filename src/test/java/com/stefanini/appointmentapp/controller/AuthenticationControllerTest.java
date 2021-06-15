package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.dto.AuthenticationRequestDto;
import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    private static final String USERNAME = "USERNAME";
    private static final String TOKEN = "TOKEN";
    private static final String PASSWORD = "PASSWORD";
    private static final String BAD_CREDENTIALS_MSG = "Invalid username or password";

    AuthenticationResponseDto responseDto;
    AuthenticationRequestDto requestDto;

    @Mock
    UserDetailsServiceImpl userDetailsService;

    @InjectMocks
    AuthenticationController authenticationController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        responseDto = new AuthenticationResponseDto(USERNAME, TOKEN);
        requestDto = new AuthenticationRequestDto(USERNAME, PASSWORD);

        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
    }

    @Test
    public void signInTest() throws Exception{

        when(userDetailsService.login(any())).thenReturn(responseDto);

        mockMvc.perform(post("/api/auth/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"login\" : \"USERNAME\", \"password\" : \"PASSWORD\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.username").value(USERNAME))
                .andExpect(jsonPath("$.token").value(TOKEN));
    }

    @Test
    public void badCredentialsTest() throws Exception{
        when(userDetailsService.login(any())).thenThrow(BadCredentialsException.class);

        mockMvc.perform(post("/api/auth/sign-in")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"login\" : \"user\", \"password\" : \"pass\"}"))
                .andExpect(status().isForbidden())
                .andExpect(content().string(BAD_CREDENTIALS_MSG));
    }
}