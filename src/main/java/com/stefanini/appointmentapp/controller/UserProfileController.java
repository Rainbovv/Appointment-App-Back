package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.Response;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.service.UserProfileService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PutMapping("/login")
    public UserProfile getProfileByLogin(@RequestBody Map<String, String> request) {

        return profileService.findByLogin(request.get("login"));
    }

    @Loggable
    @GetMapping("/patients")
    public List<UserProfileDto> getPatientsProfiles() {
        return profileService.getPatientsProfiles();
    }

    @Loggable
    @GetMapping("/personal")
    public List<UserProfileDto> getPersonalProfiles() {
        return profileService.getPersonalProfiles();
    }

    @Loggable
    @GetMapping("/speciality/{speciality}")
    public List<UserProfile> getListBySpeciality(@PathVariable String speciality) {
        return profileService.getListBySpeciality(speciality);
    }

    @Loggable
    @PostMapping
    public UserProfile createNewProfile(@RequestBody UserProfile profile) {
        return profileService.create(profile);
    }

    @Loggable
    @PutMapping("")
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
    public ResponseEntity<Response> deleteProfileById(@PathVariable Long id) throws NotFoundException {
        profileService.deleteById(id);

        return ResponseEntity.ok(new Response(HttpStatus.OK, "User profile with id = " + id + " was deleted"));
    }
}
