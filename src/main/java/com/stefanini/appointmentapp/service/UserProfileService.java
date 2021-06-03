package com.stefanini.appointmentapp.service;

import java.util.List;

import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.UserProfile;
import javassist.NotFoundException;

public interface UserProfileService {
	List<UserProfile> findAll();
	
	UserProfile create(UserProfile profile);
	
	UserProfile update(UserProfile profile);
	
	UserProfile findById(Long id);

	UserProfile findByLogin(String login);
	
	void delete(UserProfile profile);

	UserProfile create(RegistrationRequestDto dto);

	UserProfile deleteById(Long id) throws NotFoundException;

	List<UserProfileDto> getPersonalProfiles();

	List<UserProfileDto> getPatientsProfiles();
}
