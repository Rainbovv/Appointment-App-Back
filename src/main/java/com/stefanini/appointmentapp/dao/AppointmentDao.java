package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.dto.UserAppointmentDTO;
import com.stefanini.appointmentapp.entities.Appointment;

import java.util.List;

public interface AppointmentDao extends GenericDAO<Appointment> {

    /**
     * Searches for persisted appointments by doctor_id or patient_id
     * @param id Long
     * @param userRole String
     * @return A List of UserAppointmentDTO
     */
    List<UserAppointmentDTO> findByUserId(Long id, String userRole);
}
