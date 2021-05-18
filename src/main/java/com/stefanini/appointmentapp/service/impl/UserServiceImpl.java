package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Set<User> findAll() {
        return userDao.findAll();
    }
}
