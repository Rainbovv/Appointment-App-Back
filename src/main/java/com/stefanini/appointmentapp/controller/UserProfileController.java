package com.stefanini.appointmentapp.controller;

import java.util.List;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Loggable
    @GetMapping
    public List<UserProfile> getProfiles() {
        return profileService.findAll();
    }

    @Loggable
    @GetMapping("/{id}")
    public UserProfile getProfileById(@PathVariable Long id) {
        return profileService.findById(id);
    }

    @Loggable
    @PostMapping
    public UserProfile createNewProfile(@RequestBody UserProfile profile) {
        return profileService.create(profile);
    }

    @Loggable
    @PutMapping("/{id}")
    public UserProfile updateProfile(@RequestBody UserProfile profile) {
        return profileService.update(profile);
    }

    @Loggable
    @DeleteMapping
    public void deleteProfile(@RequestBody UserProfile profile) {
        profileService.delete(profile);
    }

    @Loggable
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProfileById(@PathVariable Long id) {
        profileService.deleteById(id);

        return ResponseEntity.ok(new Response(HttpStatus.OK, "User profile with id = " + id + " was deleted"));
    }
}
