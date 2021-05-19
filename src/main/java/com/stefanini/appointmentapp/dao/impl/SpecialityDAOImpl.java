package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.SpecialityDAO;
import com.stefanini.appointmentapp.entities.Speciality;
import org.springframework.stereotype.Repository;


@Repository
public class SpecialityDAOImpl extends GenericDAOImpl<Speciality> implements SpecialityDAO {
    @Override
    protected Class<Speciality> getEntityClass() {
        return Speciality.class;
    }
}
