package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.User;

import java.util.Set;

public interface UserService {

    public User create(User user);
    public User update(User user);
    public void delete(User user);
    public User findById(Long id);
    public Set<User> findAll();
}
