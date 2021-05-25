package com.stefanini.appointmentapp.dao;

import java.util.List;

public interface GenericDAO<T> {

    /**
     * Persists an entity
     * @param t an entity to persist
     * @return persisted t entity
     */
    T create(T t);

    /**
     * Updates entity
     * @param t an entity to update
     * @return updated entity
     */
    T update(T t);

    /**
     * Deletes entity
     * @param t an entity to delete
     */
    void delete(T t);

    /**
     * Searches for entity by given id
     * @param id of an persisted entity
     * @return found entity
     */
    T findById(Long id);

    /**
     * Searches for persisted entities
     * @return a List of all persisted entities
     */
    List<T> findAll();
}
