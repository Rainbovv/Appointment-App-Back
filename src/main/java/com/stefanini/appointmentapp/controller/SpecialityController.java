package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.SpecialityService;
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

        return specialityService.getList();
    }

    @GetMapping("/specialities/{specialityId}")
    public Speciality getOne(@PathVariable long specialityId) {
        return specialityService.getOne(specialityId);
    }

    @PostMapping("/specialities")
    public Speciality create(@RequestBody Speciality speciality) {
        return specialityService.create(speciality);
    }

    @PutMapping("/specialities")
    public Speciality update(@RequestBody Speciality speciality) {
        return specialityService.update(speciality);
    }

    @DeleteMapping("/specialities/{specialityId}")
    public void delete(@PathVariable long specialityId) {
        specialityService.delete(specialityId);
    }
}
