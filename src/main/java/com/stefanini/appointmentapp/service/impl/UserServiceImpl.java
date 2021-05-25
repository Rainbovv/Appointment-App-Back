package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserRoleDAO userRoleDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, UserRoleDAO userRoleDAO, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userRoleDAO = userRoleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User create(RegistrationRequestDto newUser) {
        User user = new User();
        Long roleId = newUser.getRoleId();

        if (Objects.isNull(roleId)) {
            throw new IllegalArgumentException("Registration error: user role was not specified");
        }

        UserRole userRole = userRoleDAO.findById(roleId);

        user.setLogin(newUser.getLogin());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRoles(new ArrayList<>(Arrays.asList(userRole)));
        user.setStatus(newUser.getStatus());

        return userDao.create(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public Set<User> findAll() {
        return userDao.findAll();
    }
}
