package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.HolidayDao;
import com.stefanini.appointmentapp.entities.Holiday;
import org.springframework.stereotype.Repository;

@Repository
public class HolidayDaoImpl extends GenericDAOImpl<Holiday> implements HolidayDao {
    @Override
    protected Class<Holiday> getEntityClass() {
        return Holiday.class;
    }
}
