package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.dto.CreateAppointmentDTO;
import com.stefanini.appointmentapp.dto.UserAppointmentDTO;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentDao appointmentDao;
    UserDao userDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao, UserDao userDao) {
        this.appointmentDao = appointmentDao;
        this.userDao = userDao;
    }

    @Loggable
    @Transactional
    @Override
    public Appointment create(Appointment appointment) {
        return appointmentDao.create(appointment);
    }

    @Loggable
    @Transactional
    @Override
    public Appointment createWithDTO(CreateAppointmentDTO dto) {

        Appointment appointment = new Appointment();
        appointment.setDoctor(userDao.findById(dto.getDoctorId()));
        appointment.setPatient(userDao.findById(dto.getPatientId()));
        appointment.setStarTime(dto.getStartTime());
        appointment.setEndTime(dto.getStartTime().plusHours(1));
        appointment.setRemark(dto.getRemark());

        return appointmentDao.create(appointment);
    }

    @Loggable
    @Transactional
    @Override
    public Appointment update(Appointment appointment) {
        return appointmentDao.update(appointment);
    }

    @Loggable
    @Transactional
    @Override
    public void delete(Appointment appointment) {
        appointmentDao.delete(appointment);
    }

    @Loggable
    @Override
    public Appointment findById(Long id) {
        return appointmentDao.findById(id);
    }

    @Loggable
    @Override
    public List<UserAppointmentDTO> findByPatientId(Long id) {

        return appointmentDao.findByUserId(id, "patient");
    }

    @Override
    public List<UserAppointmentDTO> findByDoctorId(Long id) {

        return appointmentDao.findByUserId(id, "doctor");
    }

    @Loggable
    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }
}
