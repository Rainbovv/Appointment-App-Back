package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentDaoImpl extends GenericDAOImpl<Appointment> implements AppointmentDao {

    @Override
    protected Class<Appointment> getEntityClass() {
        return Appointment.class;
    }
}
