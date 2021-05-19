package com.stefanini.appointmentapp.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.entities.UserProfile;

@Repository
public class UserProfileDAOImpl extends GenericDAOImpl<UserProfile> implements UserProfileDAO {

	@Override
	protected Class<UserProfile> getEntityClass() {
		return UserProfile.class;
	}

}
