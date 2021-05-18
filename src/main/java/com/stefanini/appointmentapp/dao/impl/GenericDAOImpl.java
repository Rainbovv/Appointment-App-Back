package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Set;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public Set<T> findAll() {
        return null;
    }
}
