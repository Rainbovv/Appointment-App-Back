package com.stefanini.appointmentapp.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.service.UserProfileService;

@RestController
@RequestMapping(UserProfileController.BASE_URL)
public class UserProfileController {
	
	public static final String BASE_URL = "/api/profiles";
	
	private final UserProfileService profileService;
	
	public UserProfileController(UserProfileService profileService) {
		this.profileService = profileService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<UserProfile> getProfiles() {
		return profileService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserProfile getProfileById(@PathVariable Long id) {
		return profileService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserProfile createNewProfile(@RequestBody UserProfile profile) {
		return profileService.create(profile);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserProfile updateProfile(@RequestBody UserProfile profile) {
		return profileService.update(profile);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProfile(@RequestBody UserProfile profile) {
		profileService.delete(profile);
	}
}
