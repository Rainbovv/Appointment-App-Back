package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Speciality;

import java.util.List;


public interface SpecialityService {
    /**
     * Method finds all existing specialities
     *
     * @return specialities set
     * @author Igor Filipenco
     */
    List<Speciality> findAll();

    /**
     * Method finds speciality by id
     *
     * @return speciality
     * @author Igor Filipenco
     */
    Speciality findById(Long id);

    /**
     * Method finds all persisted specialities by
     * department_id using SpecialityDAO
     * @param departmentId Long
     * @return List of found Speciality entities
     */
    List<Speciality> findByDepartmentId(Long departmentId);

    /**
     * Method creates department.
     * NOTE: do not forget to pass department with departmentId to link creating speciality
     * with existing department
     *
     * @return speciality
     * @author Igor Filipenco
     */
    Speciality create(Speciality speciality);

    /**
     * Method updates existing speciality
     *
     * @return speciality
     * @author Igor Filipenco
     */
    Speciality update(Speciality speciality);

    /**
     * Method deletes existing speciality
     *
     * @author Igor Filipenco
     */
    void delete(Long specialityId);
}
