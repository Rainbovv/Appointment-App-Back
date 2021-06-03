package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.entities.enums.RoleName;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserProfileDAOImpl extends GenericDAOImpl<UserProfile> implements UserProfileDAO {

    @Override
    protected Class<UserProfile> getEntityClass() {
        return UserProfile.class;
    }

    @Override
    public UserProfile getByLogin(String login) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> criteria = builder.createQuery(getEntityClass());
        Root<UserProfile> root = criteria.from(getEntityClass());
        Join<UserProfile, User> join = root.join("user");

        criteria.select(root);
        criteria.where(builder.equal(join.get("login"), login));

        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<UserProfileDto> getPersonalProfiles() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfileDto> criteria = builder
                .createQuery(UserProfileDto.class);

        Root<User> userRoot = criteria.from(User.class);
        Root<UserProfile> profileRoot = criteria.from(getEntityClass());
        Join<User, UserRole> join = userRoot.join("roles");

        criteria.where(builder.and(builder.notEqual(join.get("name"), RoleName.valueOf("PATIENT")),
                builder.equal(profileRoot.get("user").get("id"),
                        userRoot.get("id"))));

        criteria.multiselect(
                userRoot.get("id"),
                profileRoot.get("id"),
                profileRoot.get("firstName"),
                profileRoot.get("lastName"),
                profileRoot.get("email"),
                profileRoot.get("telephone"),
                join.get("id"),
                join.get("name")
        );

        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<UserProfileDto> getPatientsProfiles() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfileDto> criteria = builder
                .createQuery(UserProfileDto.class);

        Root<User> userRoot = criteria.from(User.class);
        Root<UserProfile> profileRoot = criteria.from(getEntityClass());
        Join<User, UserRole> join = userRoot.join("roles");

        criteria.where(builder.and(builder.equal(join.get("name"), RoleName.valueOf("PATIENT")),
                builder.equal(profileRoot.get("user").get("id"),
                        userRoot.get("id"))));

        criteria.multiselect(
                userRoot.get("id"),
                profileRoot.get("id"),
                profileRoot.get("firstName"),
                profileRoot.get("lastName"),
                profileRoot.get("email"),
                profileRoot.get("telephone"),
                join.get("id"),
                join.get("name")
        );

        return entityManager.createQuery(criteria).getResultList();
    }
}
