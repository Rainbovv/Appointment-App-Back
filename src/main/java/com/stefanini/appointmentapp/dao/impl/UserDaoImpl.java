package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class UserDaoImpl extends GenericDAOImpl<User> implements UserDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByLogin(String login) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:login");
        query.setParameter("login", login);

        return (User)query.getSingleResult();
    }
}
