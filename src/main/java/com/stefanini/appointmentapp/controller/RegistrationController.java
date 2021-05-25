package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody RegistrationRequestDto user) {

        return userService.create(user);
    }
}
