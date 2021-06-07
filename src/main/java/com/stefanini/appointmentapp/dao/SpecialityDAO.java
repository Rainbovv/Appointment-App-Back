package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.entities.Speciality;

import java.util.List;

public interface SpecialityDAO extends GenericDAO<Speciality> {

    /**
     * Method finds all persisted specialities by department_id
     * @param departmentId Long
     * @return List of found Speciality entities
     */
    List<Speciality> getListByDepartmentId(Long departmentId);
}
