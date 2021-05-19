package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.WeeklyScheduleDao;
import com.stefanini.appointmentapp.entities.WeeklySchedule;
import com.stefanini.appointmentapp.service.WeeklyScheduleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class WeeklyScheduleServiceImpl implements WeeklyScheduleService {

    WeeklyScheduleDao weeklyScheduleDao;

    @Transactional
    @Override
    public WeeklySchedule create(WeeklySchedule weeklySchedule) {
        return weeklyScheduleDao.create(weeklySchedule);
    }

    @Transactional
    @Override
    public WeeklySchedule update(WeeklySchedule weeklySchedule) {
        return weeklyScheduleDao.update(weeklySchedule);
    }

    @Transactional
    @Override
    public void delete(WeeklySchedule weeklySchedule) {
        weeklyScheduleDao.delete(weeklySchedule);
    }

    @Override
    public WeeklySchedule findById(Long id) {
        return weeklyScheduleDao.findById(id);
    }

    @Override
    public Set<WeeklySchedule> findAll() {
        return weeklyScheduleDao.findAll();
    }
}
