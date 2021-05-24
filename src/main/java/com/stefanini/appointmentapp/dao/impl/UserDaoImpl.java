package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDAOImpl<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

	@Override
	public User findUserByLogin(String login) {
		Query query = entityManager.createQuery(
                "FROM " + getEntityClass().getName() + " u WHERE u.login=:login");
        query.setParameter("login", login);

        return (User)query.getSingleResult();
	}
}
