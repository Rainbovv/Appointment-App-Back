package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.GenericDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected abstract Class<T> getEntityClass();

    @Override
    public T create(T entity) {

        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    @Override
    public T update(T entity) {

        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {

        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    @Override
    public T findById(Long id) {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() + " e WHERE e.id=:id");
        query.setParameter("id", id);

        return (T)query.getSingleResult();
    }

    @Override
    public Set<T> findAll() {
        Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() );

        return (Set<T>) query.getResultStream().collect(Collectors.toSet());
    }
}
