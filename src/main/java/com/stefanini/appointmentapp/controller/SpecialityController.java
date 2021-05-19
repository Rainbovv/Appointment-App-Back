package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/specialities")
    public Set<Speciality> getList() {
        return specialityService.findAll();
    }

    @GetMapping("/specialities/{specialityId}")
    public Speciality getOne(@PathVariable long specialityId) {
        return specialityService.findById(specialityId);
    }

    @PostMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality create(@RequestBody Speciality speciality) {
        return specialityService.create(speciality);
    }

    @PutMapping(value = "/specialities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Speciality update(@RequestBody Speciality speciality) {
        return specialityService.update(speciality);
    }

    @DeleteMapping(value = "/specialities/{specialityId}")
    public void delete(@PathVariable Long specialityId) {
        specialityService.delete(specialityId);
    }
}
