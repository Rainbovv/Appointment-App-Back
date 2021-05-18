package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDAOImpl<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
