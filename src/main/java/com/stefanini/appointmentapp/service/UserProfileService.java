package com.stefanini.appointmentapp.service;

import java.util.List;

import com.stefanini.appointmentapp.entities.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAll();
	
	UserProfile create(UserProfile profile);
	
	UserProfile update(UserProfile profile);
	
	UserProfile findById(Long id);

	UserProfile findByLogin(String login);
	
	void delete(UserProfile profile);

	UserProfile deleteById(Long id);
}
