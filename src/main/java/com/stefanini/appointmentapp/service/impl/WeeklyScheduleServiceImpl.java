package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.WeeklyScheduleDao;
import com.stefanini.appointmentapp.entities.WeeklySchedule;
import com.stefanini.appointmentapp.service.WeeklyScheduleService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeeklyScheduleServiceImpl implements WeeklyScheduleService {

    WeeklyScheduleDao weeklyScheduleDao;

    @Loggable
    @Transactional
    @Override
    public WeeklySchedule create(WeeklySchedule weeklySchedule) {
        return weeklyScheduleDao.create(weeklySchedule);
    }

    @Loggable
    @Transactional
    @Override
    public WeeklySchedule update(WeeklySchedule weeklySchedule) {
        return weeklyScheduleDao.update(weeklySchedule);
    }

    @Loggable
    @Transactional
    @Override
    public void delete(WeeklySchedule weeklySchedule) {
        weeklyScheduleDao.delete(weeklySchedule);
    }

    @Loggable
    @Override
    public WeeklySchedule findById(Long id) {
        return weeklyScheduleDao.findById(id);
    }

    @Loggable
    @Override
    public List<WeeklySchedule> findAll() {
        return weeklyScheduleDao.findAll();
    }
}
