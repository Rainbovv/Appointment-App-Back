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

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserAppointmentDTO> criteria = builder
                .createQuery(UserAppointmentDTO.class);

        Root<Appointment> appointmentRoot = criteria.from(getEntityClass());
        Root<UserProfile> doctorRoot = criteria.from(UserProfile.class);
        Root<UserProfile> patientRoot = criteria.from(UserProfile.class);

        criteria.where(builder.and(builder
                                    .equal(appointmentRoot.get(userRole).get("id"),
                                            id)),
                        builder.and(
                            builder.equal(doctorRoot.get("user").get("id"),
                                    appointmentRoot.get("doctor").get("id")),

                            builder.equal(patientRoot.get("user").get("id"),
                                    appointmentRoot.get("patient").get("id"))));

        Selection<String> firstNameSelection;
        Selection<String> lastNameSelection;

        if (userRole.equals("patient")) {
            firstNameSelection = doctorRoot.get("firstName");
            lastNameSelection = doctorRoot.get("lastName");
        }
        else {
            firstNameSelection = patientRoot.get("firstName");
            lastNameSelection = patientRoot.get("lastName");
        }

        criteria.multiselect(appointmentRoot.get("id"),
                appointmentRoot.get("startTime"),
                appointmentRoot.get("endTime"),
                firstNameSelection,
                lastNameSelection,
                doctorRoot.get("office"));

        return entityManager.createQuery(criteria).getResultList();
    }
}
