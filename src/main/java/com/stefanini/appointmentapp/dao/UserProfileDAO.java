package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.dto.UserProfileDto;
import com.stefanini.appointmentapp.entities.UserProfile;

import java.util.List;

public interface UserProfileDAO extends GenericDAO<UserProfile> {

    /**
     * Searches persisted profile by user_login
     * @param login of type String
     * @return entity of type UserProfile
     */
    UserProfile getByLogin(String login);

    /**
     * Searches persisted profiles by users role
     * @param profileRole of type String
     * @return List of UserProfile entities
     */
    List<UserProfileDto> getProfilesByRole(String profileRole);


    /**
     * Searches persisted profiles by speciality
     * @param speciality of type String
     * @return List of UserProfile entities
     */
    List<UserProfile> getListBySpeciality(String speciality);
}
