package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.security.DTO.SignUpRequestDto;
import com.stefanini.appointmentapp.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;
    UserRoleDAO userRoleDao;
    UserProfileDAO userProfileDao;
    PasswordEncoder passwordEncoder;

    

	public UserServiceImpl(UserDao userDao, UserRoleDAO userRoleDao, UserProfileDAO userProfileDao,
			PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
		this.userProfileDao = userProfileDao;
		this.passwordEncoder = passwordEncoder;
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
    public List<User> findAll() {
        return userDao.findAll();
    }
    
    @Loggable
    @Override
    public User findByLogin(String login) {
    	return userDao.findUserByLogin(login);
    }
    
    @Loggable
    @Transactional
	@Override
	public User registerNewUser(SignUpRequestDto signUpRequestDto) {
		User userToCreate = new User();
		userToCreate.setLogin(signUpRequestDto.getEmail());
		userToCreate.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
		userToCreate.setStatus(1);
		UserRole role = userRoleDao.findById(signUpRequestDto.getRoleId());
		userToCreate.getRoles().add(role);
		User createdUser = userDao.create(userToCreate);
		
		UserProfile profileToCreate = new UserProfile();
		profileToCreate.setEmail(signUpRequestDto.getEmail());
		profileToCreate.setFirstName(signUpRequestDto.getFirstName());
		profileToCreate.setLastName(signUpRequestDto.getLastName());
		profileToCreate.setDateOfBirth(signUpRequestDto.getDateOfBirth());
		profileToCreate.setGender(signUpRequestDto.getGender());
		profileToCreate.setTelephone(signUpRequestDto.getPhoneNumber());
		profileToCreate.setUser(createdUser);
		
		userProfileDao.create(profileToCreate);
		
		return createdUser;
	}
}
