package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;


    @Override
    public Appointment create(Appointment appointment) {
        return appointmentDao.create(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentDao.update(appointment);
    }

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
