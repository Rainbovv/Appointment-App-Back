package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.entities.enums.RoleName;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


@Repository
public class UserRoleDAOImpl extends GenericDAOImpl<UserRole> implements UserRoleDAO {

	@Override
	protected Class<UserRole> getEntityClass() {
		return UserRole.class;
	}
	
	@Loggable
	@Override
	public UserRole findByName(String name) {
		Query query = entityManager.createQuery("SELECT r FROM " +
				getEntityClass().getName() + "" + " r WHERE r.name=:name");

		query.setParameter("name", RoleName.valueOf(name));

		return (UserRole) query.getSingleResult();
	}
}
