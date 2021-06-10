package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplTest {

    @Mock
    UserProfileDAO profileDAO;

    @Mock
    UserRoleDAO roleDAO;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserProfileServiceImpl profileService;


    @Test
    void createWithDto() {
        RegistrationRequestDto dto = new RegistrationRequestDto("login", "password", 0, "PATIENT");
        UserProfile profile = new UserProfile();
        profile.setId(1L);

        when(roleDAO.findByName(anyString())).thenReturn(new UserRole());
        when(profileDAO.create(any())).thenReturn(profile);

        UserProfile newProfile = profileService.create(dto);

        assertNotNull(newProfile);
        assertEquals(1L, newProfile.getId());
    }
}