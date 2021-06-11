package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.CreateAppointmentDTO;
import com.stefanini.appointmentapp.dto.UserAppointmentDTO;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Loggable
    @GetMapping("")
    List<Appointment> findAll() {

        return appointmentService.findAll();
    }

    @Loggable
    @GetMapping(value = "patient/{id}")
    List<UserAppointmentDTO> findByPatientId(@PathVariable Long id) {
        return appointmentService.findByPatientId(id);
    }

    @Loggable
    @GetMapping(value = "doctor/{id}")
    List<UserAppointmentDTO> findByDoctorId(@PathVariable Long id) {
        return appointmentService.findByDoctorId(id);
    }

    @Loggable
    @GetMapping("/{id}")
    Appointment findById(@PathVariable Long id) {

        return appointmentService.findById(id);
    }

    @Loggable
    @PostMapping(value = "/dto", consumes = MediaType.APPLICATION_JSON_VALUE)
    Appointment createWithDTO (@RequestBody CreateAppointmentDTO dto) {

        return appointmentService.createWithDTO(dto);
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
