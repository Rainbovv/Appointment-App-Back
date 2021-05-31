package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.entities.Appointment;

import java.util.List;

public interface AppointmentDao extends GenericDAO<Appointment> {

    /**
     * Searches for persisted appointments by patient_id
     * @param id Long
     * @return A List of found Appointment objects
     */
    List<Appointment> findByPatientId(Long id);
}
