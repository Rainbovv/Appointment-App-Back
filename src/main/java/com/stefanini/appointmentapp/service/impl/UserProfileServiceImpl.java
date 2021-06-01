package com.stefanini.appointmentapp.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import com.stefanini.appointmentapp.annotation.Loggable;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);
    private final UserProfileDAO profileDao;

    public UserProfileServiceImpl(UserProfileDAO profileDao) {
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
    public UserProfile deleteById(Long id) {
        UserProfile profile = null;

        try {
            profile = profileDao.deleteById(id);
        } catch (NotFoundException e) {
            logger.error(e.getMessage());
        }

        return profile;
    }
}
