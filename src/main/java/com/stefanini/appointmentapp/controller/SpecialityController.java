package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Loggable
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specialities")
    public Set<Speciality> getList() {
        return specialityService.findAll();
    }

    @Loggable
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specialities/{specialityId}")
    public Speciality getOne(@PathVariable long specialityId) {
        return specialityService.findById(specialityId);
    }

    @Loggable
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specialities/department/{id}")
    public List<Speciality> getListByDepartmentId(@PathVariable long id) {
        return specialityService.findByDepartmentId(id);
    }

    @Loggable
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality create(@RequestBody Speciality speciality) {
        return specialityService.create(speciality);
    }

    @Loggable
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality update(@RequestBody Speciality speciality) {
        return specialityService.update(speciality);
    }

    @Loggable
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/specialities/{specialityId}")
    public void delete(@PathVariable Long specialityId) {
        specialityService.delete(specialityId);
    }
}
