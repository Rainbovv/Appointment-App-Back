package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Appointment;

import java.util.Set;

public interface AppointmentService {

    public Appointment create(Appointment appointment);
    public Appointment update(Appointment appointment);
    public void delete(Appointment appointment);
    public Appointment findById(Long id);
    public Set<Appointment> findAll();
}
