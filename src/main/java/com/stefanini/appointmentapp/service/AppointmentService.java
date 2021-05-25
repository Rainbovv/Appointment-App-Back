package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Appointment;
import java.util.List;

public interface AppointmentService {

    /**
     * Persists an Appointment using AppointmentDaoImpl
     * @param appointment to persist
     * @return persisted appointment
     */
    Appointment create(Appointment appointment);

    /**
     * Updates an Appointment using AppointmentDaoImpl
     * @param appointment to update
     * @return updated appointment
     */
    Appointment update(Appointment appointment);

    /**
     * Deletes an Appointment using AppointmentDaoImpl
     * @param appointment to delete
     */
    void delete(Appointment appointment);

    /**
     * Searches for persisted appointment by Id using AppointmentDaoImpl
     * @param id of an Appointment
     * @return user found ? Appointment : null
     */
    Appointment findById(Long id);

    /**
     * Searches for all persisted appointment using AppointmentDaoImpl
     * @return a List of persisted appointments
     */
    List<Appointment> findAll();
}
