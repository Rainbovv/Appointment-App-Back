package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AppointmentDaoImpl extends GenericDAOImpl<Appointment> implements AppointmentDao {

    @Override
    protected Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<Appointment> findByPatientId(Long id) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Appointment> criteria = builder.createQuery(getEntityClass());
        Root<Appointment> root = criteria.from(getEntityClass());
        Join<Appointment, User> join = root.join( "patient" );
        criteria.select(root);
        criteria.where(builder.equal(join.get("id"), id));

        return entityManager.createQuery(criteria).getResultList();
    }
}
