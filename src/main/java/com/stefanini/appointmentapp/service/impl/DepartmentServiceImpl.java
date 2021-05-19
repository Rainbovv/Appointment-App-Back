package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.DepartmentDAO;
import com.stefanini.appointmentapp.entities.Department;
import com.stefanini.appointmentapp.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Set;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public Set<Department> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentDAO.findById(id);
    }

    @Transactional
    @Override
    public Department create(Department department) {
        return departmentDAO.create(department);
    }

    @Transactional
    @Override
    public void delete(long departmentId) {
        Department departmentToDelete = departmentDAO.findById(departmentId);

        if (departmentToDelete == null) {
            throw new NoResultException("Department delete: department with id = " + departmentId + " not found");
        }

        departmentDAO.delete(departmentToDelete);
    }

    @Transactional
    @Override
    public Department update(Department department) {
        return departmentDAO.update(department);
    }
}
