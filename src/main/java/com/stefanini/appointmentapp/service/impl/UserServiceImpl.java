package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;

import org.springframework.stereotype.Service;

import java.util.*;
import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Loggable
    @Transactional
    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Loggable
    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Loggable
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Loggable
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Loggable
    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
