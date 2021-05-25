package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserRoleDAO userRoleDAO;
    private final UserProfileDAO userProfileDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, UserRoleDAO userRoleDAO, UserProfileDAO userProfileDAO, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userRoleDAO = userRoleDAO;
        this.userProfileDAO = userProfileDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Loggable
    @Transactional
    @Override
    public User create(User user) {

        return userDao.create(user);
    public User create(RegistrationRequestDto dto) {
        User newUser = mapDtoToUser(dto);
        UserProfile newUserProfile = mapDtoToUserProfile(dto);
        newUserProfile.setUser(newUser);
        userProfileDAO.create(newUserProfile);

        return null;
    }

    @Loggable
    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Loggable
    @Transactional
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

    private User mapDtoToUser(RegistrationRequestDto userDto) {
        User user = new User();
        Long roleId = userDto.getRoleId();

        if (Objects.isNull(roleId)) {
            throw new IllegalArgumentException("Registration error: user role was not specified");
        }

        UserRole userRole = userRoleDAO.findById(roleId);
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(new ArrayList<>(Arrays.asList(userRole)));
        user.setStatus(userDto.getStatus());

        return user;
    }

    private UserProfile mapDtoToUserProfile(RegistrationRequestDto userDto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(userDto.getFirstName());
        userProfile.setLastName(userDto.getLastName());
        userProfile.setGender(userDto.getGender());
        userProfile.setOffice(userDto.getOffice());
        userProfile.setAddress(userDto.getAddress());
        userProfile.setAbout(userDto.getAbout());
        userProfile.setTelephone(userDto.getTelephone());
        userProfile.setDegree(userDto.getDegree());
        userProfile.setEmail(userDto.getLogin());
        userProfile.setDateOfBirth(userDto.getDateOfBirth());

        return userProfile;
    }
}
