package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("")
    Set<Appointment> findAll() {

        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    Appointment findById(@PathVariable Long id) {

        return appointmentService.findById(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Appointment create(@RequestBody Appointment appointment) {

        return appointmentService.create(appointment);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Appointment update(@RequestBody Appointment appointment) {

        return appointmentService.update(appointment);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody Appointment appointment) {

        appointmentService.delete(appointment);
    }

}
