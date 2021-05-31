package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AppointmentDaoImpl extends GenericDAOImpl<Appointment> implements AppointmentDao {

    @Override
    protected Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<Appointment> findByPatientId(Long id) {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() + " e WHERE e.patient =:id");
        query.setParameter("id", id);

        return query.getResultList();
    }
}
