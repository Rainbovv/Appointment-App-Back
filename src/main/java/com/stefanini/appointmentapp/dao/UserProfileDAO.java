package com.stefanini.appointmentapp.dao;

import com.stefanini.appointmentapp.entities.UserProfile;

public interface UserProfileDAO extends GenericDAO<UserProfile> {

    /**
     * Searches persisted profile by user_login
     * @param login of type String
     * @return entity of type UserProfile
     */
    public UserProfile getByLogin(String login);
}
