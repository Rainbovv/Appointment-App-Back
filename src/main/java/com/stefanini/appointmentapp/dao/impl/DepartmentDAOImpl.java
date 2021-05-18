package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.DepartmentDAO;
import com.stefanini.appointmentapp.entities.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDAOImpl extends GenericDAOImpl<Department> implements DepartmentDAO {
    @Override
    protected Class<Department> getEntityClass() {
        return Department.class;
    }
}
