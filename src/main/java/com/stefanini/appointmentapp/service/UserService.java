package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.User;
import java.util.List;

public interface UserService {

    User create(User user);
    User update(User user);
    void delete(User user);
    User findById(Long id);
    User findByLogin(String login);
    List<User> findAll();
}
