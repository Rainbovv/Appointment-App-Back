package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentDao appointmentDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
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

//    @Loggable
    @Override
    public List<Appointment> findByPatientId(Long id) {
        return appointmentDao.findByPatientId(id);
    }

    @Loggable
    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }
}
