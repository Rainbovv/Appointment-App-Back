package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.entities.enums.RoleName;

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
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserRole> criteria = builder.createQuery(getEntityClass());
		Root<UserRole> root = criteria.from(getEntityClass());

		criteria.select(root).where(root.get("name").in(RoleName.valueOf(name)));

		return entityManager.createQuery(criteria).getSingleResult();
	}
}
