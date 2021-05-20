package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.WeeklySchedule;

import java.util.List;

public interface WeeklyScheduleService {

    /**
     * Make a Holiday instance managed and persistent.
     * Synchronize the persistence context into underlying database.
     * @param weeklySchedule Instance of WeeklySchedule
     * @return Instance of WeeklySchedule
     */
    WeeklySchedule create(WeeklySchedule weeklySchedule);

    /**
     * Merge the state of the given entity into the current persistence context.
     * @param weeklySchedule Instance of WeeklySchedule
     * @return Instance of WeeklySchedule
     */
    WeeklySchedule update(WeeklySchedule weeklySchedule);

    /**
     * Remove the WeeklySchedule instance if it is a managed entity instance
     * belonging to the current persistence context.
     * @param weeklySchedule Instance of WeeklySchedule
     */
    void delete(WeeklySchedule weeklySchedule);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find WeeklySchedule instance by id.
     * @param id Long
     * @return Instance of WeeklySchedule
     */
    WeeklySchedule findById(Long id);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find all instances of WeeklySchedule.
     * @return Set&lt;WeeklyScheduleT&gt;
     */
    List<WeeklySchedule> findAll();
}
