package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.SpecialityDAO;
import com.stefanini.appointmentapp.entities.Department;
import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Set;


@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityDAO specialityDAO;

    public SpecialityServiceImpl(SpecialityDAO specialityDAO) {
        this.specialityDAO = specialityDAO;
    }

    @Override
    public Set<Speciality> getList() {
        return specialityDAO.findAll();
    }

    @Override
    public Speciality getOne(long specialityId) {
        return specialityDAO.findById(specialityId);
    }

    @Override
    public Speciality create(Speciality speciality) {
        return specialityDAO.create(speciality);
    }

    @Override
    public Speciality update(Speciality speciality) {
        return specialityDAO.update(speciality);
    }

    @Override
    public void delete(long specialityId) {
        Speciality specialityToDelete = specialityDAO.findById(specialityId);

        if (specialityToDelete == null) {
            throw new NoResultException("Department search: department with id = " + specialityId + " not found");
        }

        specialityDAO.delete(specialityToDelete);
    }
}
