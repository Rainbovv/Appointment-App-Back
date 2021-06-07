package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.SpecialityDAO;
import com.stefanini.appointmentapp.entities.Speciality;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class SpecialityDAOImpl extends GenericDAOImpl<Speciality> implements SpecialityDAO {
    @Override
    protected Class<Speciality> getEntityClass() {
        return Speciality.class;
    }

    @Override
    public List<Speciality> getListByDepartmentId(Long departmentId) {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() + " e WHERE e.department.id=:id");
        query.setParameter("id", departmentId);

        return query.getResultList();
    }
}
