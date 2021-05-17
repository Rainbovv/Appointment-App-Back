package com.stefanini.appointmentapp.dao;

import java.util.Set;

public interface GenericDAO<T> {
    T create(T t);

    T update(T t);

    void delete(T t);

    T findById(Long id);

    Set<T> findAll();

}
