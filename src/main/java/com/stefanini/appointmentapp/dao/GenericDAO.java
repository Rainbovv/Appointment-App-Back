package com.stefanini.appointmentapp.dao;

import java.util.List;

public interface GenericDAO<T> {

    /**
     *
     * @param t an entity to persist
     * @return persisted t entity
     */
    T create(T t);

    T update(T t);

    void delete(T t);

    T findById(Long id);

    List<T> findAll();
}
