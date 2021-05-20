package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.SpecialityDAO;
import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.service.DepartmentService;
import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Set;


@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityDAO specialityDAO;
    private final DepartmentService departmentService;

    public SpecialityServiceImpl(SpecialityDAO specialityDAO, DepartmentService departmentService) {
        this.specialityDAO = specialityDAO;
        this.departmentService = departmentService;
    }

    @Loggable
    @Override
    public Set<Speciality> findAll() {
        return specialityDAO.findAll();
    }

    @Loggable
    @Override
    public Speciality findById(Long specialityId) {
        return specialityDAO.findById(specialityId);
    }

    @Transactional
    @Loggable
    @Override
    public Speciality create(Speciality speciality) {

        return specialityDAO.create(speciality);
    }

    @Transactional
    @Loggable
    @Override
    public Speciality update(Speciality speciality) {

        return specialityDAO.update(speciality);
    }

    @Transactional
    @Loggable
    @Override
    public void delete(Long specialityId) {
        Speciality specialityToDelete = specialityDAO.findById(specialityId);

        if (specialityToDelete == null) {
            throw new NoResultException("Department search: department with id = " + specialityId + " not found");
        }

        specialityDAO.delete(specialityToDelete);
    }
}
