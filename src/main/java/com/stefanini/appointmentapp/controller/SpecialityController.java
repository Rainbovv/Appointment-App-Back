package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specialities")
    public List<Speciality> getList() {
        return specialityService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specialities/{specialityId}")
    public Speciality getOne(@PathVariable long specialityId) {
        return specialityService.findById(specialityId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality create(@RequestBody Speciality speciality) {
        return specialityService.create(speciality);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality update(@RequestBody Speciality speciality) {
        return specialityService.update(speciality);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/specialities/{specialityId}")
    public void delete(@PathVariable Long specialityId) {
        specialityService.delete(specialityId);
    }
}
