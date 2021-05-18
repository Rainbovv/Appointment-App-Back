package com.stefanini.appointmentapp.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

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

	@Override
	public Set<UserProfile> findAll() {
		return profileDao.findAll();
	}
	
	@Transactional
	@Override
	public UserProfile create(UserProfile profile) {
		return profileDao.create(profile);
	}
	
	@Transactional
	@Override
	public UserProfile update(UserProfile profile) {
		return profileDao.update(profile);
	}

	@Override
	public UserProfile findById(Long id) {
		return profileDao.findById(id);
	}
	
	@Transactional
	@Override
	public void delete(UserProfile profile) {
		profileDao.delete(profile);
		
	}
}
