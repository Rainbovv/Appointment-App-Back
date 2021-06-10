package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.AppointmentDao;
import com.stefanini.appointmentapp.dto.UserAppointmentDTO;
import com.stefanini.appointmentapp.entities.Appointment;
import com.stefanini.appointmentapp.entities.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AppointmentDaoImpl extends GenericDAOImpl<Appointment> implements AppointmentDao {

    @Override
    protected Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<UserAppointmentDTO> findByUserId(Long id, String userRole) {

        String profileRole = userRole.equals("patient") ? "doctor" : "patient";

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserAppointmentDTO> criteria = builder
                .createQuery(UserAppointmentDTO.class);

        Root<Appointment> appointmentRoot = criteria.from(getEntityClass());
        Root<UserProfile> profileRoot = criteria.from(UserProfile.class);

        criteria.where(builder.and(builder.equal(appointmentRoot.get(userRole).get("id"), id),
                builder.equal(profileRoot.get("user").get("id"),
                        appointmentRoot.get(profileRole).get("id"))));


        criteria.multiselect(appointmentRoot.get("id"),
                appointmentRoot.get("startTime"),
                appointmentRoot.get("endTime"),
                profileRoot.get("firstName"),
                profileRoot.get("lastName"),
                profileRoot.get("office"));

        return entityManager.createQuery(criteria).getResultList();
    }
}
