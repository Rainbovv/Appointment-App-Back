package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.DailyScheduleDao;
import com.stefanini.appointmentapp.entities.DailySchedule;
import org.springframework.stereotype.Repository;

@Repository
public class DailyScheduleDaoImpl extends GenericDAOImpl<DailySchedule> implements DailyScheduleDao {
    @Override
    protected Class<DailySchedule> getEntityClass() {
        return DailySchedule.class;
    }
}
