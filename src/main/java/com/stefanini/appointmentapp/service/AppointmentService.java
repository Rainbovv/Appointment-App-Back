package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.dto.CreateAppointmentDTO;
import com.stefanini.appointmentapp.dto.UserAppointmentDTO;
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
     * Gets a CreateAppointmentDTO, maps to Appointments
     * and persits it using AppointmentDaoImpl
     * @param dto of Type CreateAppointmentDTO to persist
     * @return persisted appointment
     */
    Appointment createWithDTO(CreateAppointmentDTO dto);

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

    /**
     * Searches for persisted appointments by
     * patient_id using AppointmentDaoImpl
     * @param id Long
     * @return A List of UserAppointmentDTO
     */
    List<UserAppointmentDTO> findByPatientId(Long id);

    /**
     * Searches for persisted appointments by
     * doctor_id using AppointmentDaoImpl
     * @param id Long
     * @return A List of UserAppointmentDTO
     */
    List<UserAppointmentDTO> findByDoctorId(Long id);
}
