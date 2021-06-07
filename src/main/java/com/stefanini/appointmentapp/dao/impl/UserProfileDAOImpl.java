package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.Speciality;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserProfile;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.entities.enums.RoleName;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserProfileDAOImpl extends GenericDAOImpl<UserProfile> implements UserProfileDAO {

    @Loggable
    @Override
    protected Class<UserProfile> getEntityClass() {
        return UserProfile.class;
    }

    @Loggable
    @Override
    public UserProfile getByLogin(String login) {

        Query query = entityManager.createQuery("SELECT p FROM " +
                getEntityClass().getName() + " p WHERE p.user.login=:login");
        query.setParameter("login", login);

        return (UserProfile) query.getSingleResult();
    }

    @Loggable
    @Override
    public List<UserProfileDto> getProfilesByRole(String profileRole) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfileDto> criteria = builder
                .createQuery(UserProfileDto.class);

        Root<User> userRoot = criteria.from(User.class);
        Root<UserProfile> profileRoot = criteria.from(getEntityClass());
        Join<User, UserRole> join = userRoot.join("roles");

        Expression<Boolean> expression = null;

        switch (profileRole) {
            case "PATIENT":
                expression = builder.equal(join.get("name"), RoleName.valueOf("PATIENT"));
                break;
            case "PERSONAL":
                expression = builder.notEqual(join.get("name"), RoleName.valueOf("PATIENT"));
        }
        criteria.where(builder.and(
                expression,
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
    public List<UserProfile> getListBySpeciality(String speciality) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> criteria = builder.createQuery(getEntityClass());
        Root<UserProfile> root = criteria.from(getEntityClass());
        Join<UserProfile, Speciality> join = root.join("specialities");

        criteria.where(builder.equal(join.get("name"), speciality));

        return entityManager.createQuery(criteria).getResultList();
    }
}
