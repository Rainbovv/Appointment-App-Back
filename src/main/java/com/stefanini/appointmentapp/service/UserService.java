package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.User;

import java.util.Set;

public interface UserService {
    User create(RegistrationRequestDto user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    User findByLogin(String login);

    Set<User> findAll();
}
