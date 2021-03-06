package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.GenericDAO;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Loggable
    @Override
    public T create(T entity) {

        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    @Loggable
    @Override
    public T update(T entity) {

        return entityManager.merge(entity);
    }

    @Loggable
    @Override
    public void delete(T entity) {

        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    @Loggable
    @Override
    public T deleteById(Long id) throws NotFoundException {
        T entity = findById(id);

        if (entity == null) {
            throw new NotFoundException("Delete error: entity with id = " + id + " not found and can't be deleted");
        }
        entityManager.remove(entity);

        return entity;
    }

    @Loggable
    @Override
    public T findById(Long id) {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() + " e WHERE e.id=:id");
        query.setParameter("id", id);

        return (T) query.getSingleResult();
    }

    @Loggable
    @Override
    public List<T> findAll() {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName());

        return query.getResultList();
    }
}
