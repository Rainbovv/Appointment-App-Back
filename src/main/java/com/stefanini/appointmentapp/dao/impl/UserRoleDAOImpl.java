package com.stefanini.appointmentapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.entities.UserRole;

@Repository
public class UserRoleDAOImpl extends GenericDAOImpl<UserRole> implements UserRoleDAO {

	@Override
	protected Class<UserRole> getEntityClass() {
		return UserRole.class;
	}

}
