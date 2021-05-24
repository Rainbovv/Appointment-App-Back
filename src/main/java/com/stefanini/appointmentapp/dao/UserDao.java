package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.entities.User;

public interface UserDao extends GenericDAO<User> {
	
	public User findUserByLogin(String login);
}
