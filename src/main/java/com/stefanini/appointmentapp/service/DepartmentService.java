package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Department;

import java.util.Set;

public interface DepartmentService {
    Set<Department> getList();

    Department getOne(long id);

    Department create(Department department);

    Department update(Department department, long id);

    void delete(long departmentId);
}
