package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.security.userdetails.UserDetailsServiceImpl;
import com.stefanini.appointmentapp.service.UserProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    private static final String USERNAME = "USERNAME";
    private static final String TOKEN = "TOKEN";
    private static final String DUPLICATE_EMAIL_MSG = "User with this email already exists";
    private static final String USER_CREATED = "User successfully created";

    RegistrationRequestDto requestDto;
    AuthenticationResponseDto responseDto;
    UserProfile userProfile;

    @Mock
    UserDetailsServiceImpl userDetailsService;

    @Mock
    UserProfileService userProfileService;

    @InjectMocks
    RegistrationController registrationController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        responseDto = new AuthenticationResponseDto(USERNAME, TOKEN);
        requestDto = new RegistrationRequestDto();
        requestDto.setLogin(USERNAME);
        userProfile = new UserProfile();
        userProfile.setEmail(USERNAME);

        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
    }

    @Test
    public void signUpPatientSuccessTest() throws Exception {
        when(userProfileService.create((RegistrationRequestDto) any())).thenReturn(userProfile);
        when(userDetailsService.login(any())).thenReturn(responseDto);

        mockMvc.perform(post("/api/auth/sign-up")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"login\" : \"user\", \"creator\" : \"PATIENT\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(USERNAME))
                .andExpect(jsonPath("$.token").value(TOKEN));
    }

    @Test
    public void signUpAdminSuccessTest() throws Exception {
        when(userProfileService.create((RegistrationRequestDto) any())).thenReturn(userProfile);

        mockMvc.perform(post("/api/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"login\" : \"user\", \"creator\" : \"ADMIN\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(USER_CREATED));
    }

    @Test
    public void signUpDuplicateEmail() throws Exception {
        when(userProfileService.create((RegistrationRequestDto) any())).thenReturn(userProfile);
        when(userDetailsService.login(any())).thenThrow(UnexpectedRollbackException.class);

        mockMvc.perform(post("/api/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"login\" : \"user\", \"creator\" : \"PATIENT\"}"))
                .andExpect(status().isForbidden())
                .andExpect(content().string(DUPLICATE_EMAIL_MSG));
    }
}