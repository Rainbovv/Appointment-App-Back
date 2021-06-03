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

    List<UserProfileDto> getProfilesByRole(String profileRole);
}
