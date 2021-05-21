package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment create(Appointment appointment);
    Appointment update(Appointment appointment);
    void delete(Appointment appointment);
    Appointment findById(Long id);
    List<Appointment> findAll();
}
