package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.DailyScheduleDao;
import com.stefanini.appointmentapp.entities.DailySchedule;
import com.stefanini.appointmentapp.service.DailyScheduleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class DailyScheduleServiceImpl implements DailyScheduleService {

    DailyScheduleDao dailyScheduleDao;

    @Transactional
    @Override
    public DailySchedule create(DailySchedule dailySchedule) {
        return dailyScheduleDao.create(dailySchedule);
    }

    @Transactional
    @Override
    public DailySchedule update(DailySchedule dailySchedule) {
        return dailyScheduleDao.update(dailySchedule);
    }

    @Transactional
    @Override
    public void delete(DailySchedule dailySchedule) {
        dailyScheduleDao.delete(dailySchedule);
    }

    @Override
    public DailySchedule findById(Long id) {
        return dailyScheduleDao.findById(id);
    }

    @Override
    public Set<DailySchedule> findAll() {
        return dailyScheduleDao.findAll();
    }
}
