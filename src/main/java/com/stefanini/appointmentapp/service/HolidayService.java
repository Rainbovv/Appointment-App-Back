package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.entities.Holiday;

import java.util.Set;

public interface HolidayService {

    /**
     * Make a Holiday instance managed and persistent.
     * Synchronize the persistence context into underlying database.
     * @param holiday Instance of Holiday
     * @return Instance of Holiday
     */
    public Holiday create(Holiday holiday);

    /**
     * Merge the state of the given entity into the current persistence context.
     * @param holiday Instance of Holiday
     * @return Instance of Holiday
     */
    public Holiday update(Holiday holiday);

    /**
     * Remove the Holiday instance if it is a managed entity instance belonging to the current persistence context.
     * @param holiday Instance of Holiday
     */
    public void delete(Holiday holiday);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find Holiday instance by id.
     * @param id Long
     * @return Instance of Holiday
     */
    public Holiday findById(Long id);

    /**
     * Create an instance of Query for executing a Java Persistence query language statement.
     * Find all instances of Holiday.
     * @return Set&lt;HolidayT&gt;
     */
    public Set<Holiday> findAll();
}
