package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.WeeklyScheduleDao;
import com.stefanini.appointmentapp.entities.WeeklySchedule;
import org.springframework.stereotype.Repository;

@Repository
public class WeeklyScheduleDaoImpl extends GenericDAOImpl<WeeklySchedule> implements WeeklyScheduleDao {
    @Override
    protected Class<WeeklySchedule> getEntityClass() {
        return WeeklySchedule.class;
    }
}
