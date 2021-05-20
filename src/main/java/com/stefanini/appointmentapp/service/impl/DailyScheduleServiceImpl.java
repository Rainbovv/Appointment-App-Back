package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.DailyScheduleDao;
import com.stefanini.appointmentapp.entities.DailySchedule;
import com.stefanini.appointmentapp.service.DailyScheduleService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DailyScheduleServiceImpl implements DailyScheduleService {

    DailyScheduleDao dailyScheduleDao;

    @Loggable
    @Transactional
    @Override
    public DailySchedule create(DailySchedule dailySchedule) {
        return dailyScheduleDao.create(dailySchedule);
    }

    @Loggable
    @Transactional
    @Override
    public DailySchedule update(DailySchedule dailySchedule) {
        return dailyScheduleDao.update(dailySchedule);
    }

    @Loggable
    @Transactional
    @Override
    public void delete(DailySchedule dailySchedule) {
        dailyScheduleDao.delete(dailySchedule);
    }

    @Loggable
    @Override
    public DailySchedule findById(Long id) {
        return dailyScheduleDao.findById(id);
    }

    @Loggable
    @Override
    public List<DailySchedule> findAll() {
        return dailyScheduleDao.findAll();
    }
}
