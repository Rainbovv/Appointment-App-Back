package com.stefanini.appointmentapp.dao.impl;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.User;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;
import com.stefanini.appointmentapp.dao.UserProfileDAO;
import com.stefanini.appointmentapp.entities.UserProfile;

import javax.persistence.criteria.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Join<UserProfile, User> join = root.join("user");

        criteria.select(root);
        criteria.where(builder.equal(join.get("login"), login));

        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<UserProfileDto> getPersonalProfiles() {
        Iterator it = entityManager.createNativeQuery("select u.id as profile_id, ur.user_id as user_id,  first_name, last_name, email, telephone, r.id as role_id, r.name as roleName  from user u\n" +
                "join user_roles ur on u.id = ur.user_id\n" +
                "join profile p on u.id = p.user_id\n" +
                "join role r on ur.role_id = r.id\n" +
                "where role_id != 2;")
                .getResultList()
                .iterator();

        List<UserProfileDto> profiles = new ArrayList<>();

        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            UserProfileDto dto = new UserProfileDto();

            dto.setId(Long.parseLong(String.valueOf(tuple[0])));
            dto.setFirstName((String) tuple[1]);
            dto.setLastName((String) tuple[2]);
            dto.setEmail((String) tuple[3]);
            dto.setTelephone((String) tuple[4]);
            dto.setRoleId(Long.parseLong(String.valueOf(tuple[5])));
            dto.setRoleName((String) tuple[6]);

            profiles.add(dto);
        }

        return profiles;
    }

    @Override
    public List<UserProfileDto> getPatientsProfiles() {
        Iterator it = entityManager.createNativeQuery("select u.id as profile_id, ur.user_id as user_id,  first_name, last_name, email, telephone, r.id as role_id, r.name as roleName  from user u\n" +
                "join user_roles ur on u.id = ur.user_id\n" +
                "join profile p on u.id = p.user_id\n" +
                "join role r on ur.role_id = r.id\n" +
                "where role_id = 2;").getResultList().iterator();

        List<UserProfileDto> profiles = new ArrayList<>();

        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            UserProfileDto dto = new UserProfileDto();

            dto.setId(Long.parseLong(String.valueOf(tuple[0])));
            dto.setFirstName((String) tuple[1]);
            dto.setLastName((String) tuple[2]);
            dto.setEmail((String) tuple[3]);
            dto.setTelephone((String) tuple[4]);
            dto.setRoleId(Long.parseLong(String.valueOf(tuple[5])));
            dto.setRoleName((String) tuple[6]);

            profiles.add(dto);
        }

        return profiles;
    }
}
