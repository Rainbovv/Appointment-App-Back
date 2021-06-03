package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.service.UserProfileService;
import javassist.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileDAO profileDao;

    public UserProfileServiceImpl(UserProfileDAO profileDao, UserRoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.profileDao = profileDao;
    }

    @Loggable
    @Override
    public List<UserProfile> findAll() {
        return profileDao.findAll();
    }

    @Loggable
    @Transactional
    @Override
    public UserProfile create(UserProfile profile) {
        return profileDao.create(profile);
    }

    @Loggable
    @Transactional
    @Override
    public UserProfile update(UserProfile profile) {
        return profileDao.update(profile);
    }

    @Loggable
    @Override
    public UserProfile findById(Long id) {
        return profileDao.findById(id);
    }



    @Loggable
    @Override
    public UserProfile findByLogin(String login) {
        return profileDao.getByLogin(login);
    }

    @Loggable
    @Transactional
    @Override
    public void delete(UserProfile profile) {
        profileDao.delete(profile);

    }

    @Loggable
    @Transactional
    @Override
    public UserProfile deleteById(Long id) throws NotFoundException {

        return profileDao.deleteById(id);
    }

    @Loggable
    @Override
    public List<UserProfileDto> getPersonalProfiles() {
        return profileDao.getProfilesByRole("PERSONAL");
    }

    @Loggable
    @Override
    public List<UserProfileDto> getPatientsProfiles() {
        return profileDao.getProfilesByRole("PATIENT");
    }
}
