package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Loggable
    @GetMapping("")
    List<Appointment> findAll() {

        return appointmentService.findAll();
    }

    @Loggable
    @GetMapping(value = "user/{id}")
    List<Appointment> findByUserId(@PathVariable Long id) {
        return appointmentService.findByPatientId(id);
    }

    @Loggable
    @GetMapping("/{id}")
    Appointment findById(@PathVariable Long id) {

        return appointmentService.findById(id);
    }

    @Loggable
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Appointment create(@RequestBody Appointment appointment) {

        return appointmentService.create(appointment);
    }

    @Loggable
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Appointment update(@RequestBody Appointment appointment) {

        return appointmentService.update(appointment);
    }

    @Loggable
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody Appointment appointment) {

        appointmentService.delete(appointment);
    }

}
