package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Speciality;

import java.util.Set;


public interface SpecialityService {
    Set<Speciality> getList();

    Speciality getOne(long id);

    Speciality create(Speciality speciality);

    Speciality update(Speciality speciality);

    void delete(long specialityId);
}
