package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.HolidayDao;
import com.stefanini.appointmentapp.entities.Holiday;
import com.stefanini.appointmentapp.service.HolidayService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    HolidayDao holidayDao;

    /**
     * Constructs and initiates HolidayServiceImpl object with HolidayDao object.
     * @param holidayDao Instance of HolidayDao
     */
    public HolidayServiceImpl(HolidayDao holidayDao) {
        this.holidayDao = holidayDao;
    }

    @Loggable
    @Transactional
    @Override
    public Holiday create(Holiday holiday) {
        return holidayDao.create(holiday);
    }

    @Loggable
    @Transactional
    @Override
    public Holiday update(Holiday holiday) {
        return holidayDao.update(holiday);
    }

    @Loggable
    @Transactional
    @Override
    public void delete(Holiday holiday) {
        holidayDao.delete(holiday);
    }

    @Loggable
    @Override
    public Holiday findById(Long id) {
        return holidayDao.findById(id);
    }

    @Loggable
    @Override
    public List<Holiday> findAll() {
        return holidayDao.findAll();
    }
}
