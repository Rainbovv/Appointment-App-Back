package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * Method finds all existing departments
     *
     * @return departments set
     * @author Igor Filipenco
     */
    List<Department> findAll();

    /**
     * Method finds department by id
     *
     * @return department
     * @author Igor Filipenco
     */
    Department findById(Long id);

    /**
     * Method creates department
     *
     * @return department
     * @author Igor Filipenco
     */
    Department create(Department department);

    /**
     * Method updates existing department
     *
     * @return department
     * @author Igor Filipenco
     */
    Department update(Department department);

    /**
     * Method deletes existing department
     *
     * @author Igor Filipenco
     */
    void delete(long departmentId);
}
