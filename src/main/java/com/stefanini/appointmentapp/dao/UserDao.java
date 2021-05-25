package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.entities.User;

public interface UserDao extends GenericDAO<User> {

    /**
     * Searches for persisted user by login
     * @param login of an persisted User
     * @return found user
     */
    User findByLogin(String login);
}
