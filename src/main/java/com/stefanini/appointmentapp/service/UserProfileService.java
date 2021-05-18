package com.stefanini.appointmentapp.service;

import java.util.Set;

import com.stefanini.appointmentapp.entities.UserProfile;

public interface UserProfileService {
	Set<UserProfile> findAll();
	
	UserProfile create(UserProfile profile);
	
	UserProfile update(UserProfile profile);
	
	UserProfile findById(Long id);
	
	void delete(UserProfile profile);
}
