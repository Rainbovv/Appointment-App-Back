package com.stefanini.appointmentapp.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import com.stefanini.appointmentapp.annotation.Loggable;
import org.springframework.stereotype.Service;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	
	private final UserProfileDAO profileDao;
	
	public UserProfileServiceImpl (UserProfileDAO profileDao) {
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
	@Transactional
	@Override
	public void delete(UserProfile profile) {
		profileDao.delete(profile);
		
	}
}
