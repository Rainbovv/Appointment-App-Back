package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.User;
import org.springframework.stereotype.Repository;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.entities.UserProfile;

import javax.persistence.criteria.*;

@Repository
public class UserProfileDAOImpl extends GenericDAOImpl<UserProfile> implements UserProfileDAO {

	@Override
	protected Class<UserProfile> getEntityClass() {
		return UserProfile.class;
	}

	@Loggable
	@Override
	public UserProfile getByLogin(String login) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteria = builder.createQuery(getEntityClass());
		Root<UserProfile> root = criteria.from(getEntityClass());
		Join<UserProfile, User> join = root.join( "user" );

		criteria.select(root);
		criteria.where(builder.equal(join.get("login"), login));

		return entityManager.createQuery(criteria).getSingleResult();
	}
}
