package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserDaoImpl extends GenericDAOImpl<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Loggable
    public User findByLogin(String login) {
        Query query = entityManager.createQuery(
                "FROM " + User.class.getName() + " e WHERE e.login=:login");
        query.setParameter("login", login);

        return (User)query.getSingleResult();
    }
}
