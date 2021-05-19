package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.DailySchedule;

import java.util.Set;

public interface DailyScheduleService {

    /**
     * Make a DailySchedule instance managed and persistent.
     * @param dailySchedule Instance of DailySchedule
     * @return Instance of DailySchedule
     */
    public DailySchedule create(DailySchedule dailySchedule);

    /**
     * Merge the state of the given entity into the current persistence context.
     * @param dailySchedule Instance of DailySchedule
     * @return Instance of DailySchedule
     */
    public DailySchedule update(DailySchedule dailySchedule);

    /**
     * Remove the DailySchedule instance if it is a managed entity instance
     * belonging to the current persistence context.
     * @param dailySchedule Instance of DailySchedule
     */
    public void delete(DailySchedule dailySchedule);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find DailySchedule instance by id.
     * @param id Long
     * @return Instance of DailySchedule.
     */
    public DailySchedule findById(Long id);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find all instances of DailySchedule.
     * @return Set&lt;DailyScheduleT&gt;
     */
    public Set<DailySchedule> findAll();
}
