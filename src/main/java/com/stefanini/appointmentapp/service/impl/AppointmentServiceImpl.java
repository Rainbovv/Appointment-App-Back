package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentDao appointmentDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Transactional
    @Override
    public Appointment create(Appointment appointment) {
        return appointmentDao.create(appointment);
    }

    @Transactional
    @Override
    public Appointment update(Appointment appointment) {
        return appointmentDao.update(appointment);
    }

    @Transactional
    @Override
    public void delete(Appointment appointment) {
        appointmentDao.delete(appointment);
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentDao.findById(id);
    }

    @Override
    public Set<Appointment> findAll() {
        return appointmentDao.findAll();
    }
}
