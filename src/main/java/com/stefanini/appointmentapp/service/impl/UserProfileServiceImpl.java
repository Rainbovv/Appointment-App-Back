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
    private final UserRoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    public UserProfileServiceImpl(UserProfileDAO profileDao, UserRoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.profileDao = profileDao;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
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
    public UserProfile create(RegistrationRequestDto dto){
        User newUser = mapDtoToUser(dto);
        UserProfile newUserProfile = mapDtoToUserProfile(dto);
        newUserProfile.setUser(newUser);

        return profileDao.create(newUserProfile);
    }

    @Loggable
    @Transactional
    @Override
    public UserProfile update(UserProfile profile) {

        profile.getUser().setPassword(profileDao
                .findById(profile.getId()).getUser().getPassword());

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

    private User mapDtoToUser(RegistrationRequestDto userDto) {
        User user = new User();
        String role = userDto.getRole();

        if (Objects.isNull(role)) {
            throw new IllegalArgumentException("Registration error: user role was not specified");
        }
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singletonList(roleDAO.findByName(role)));
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
