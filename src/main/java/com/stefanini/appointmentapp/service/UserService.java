package com.stefanini.appointmentapp.service;

import com.stefanini.appointmentapp.dto.RegistrationRequestDto;
import com.stefanini.appointmentapp.entities.User;
import java.util.List;

public interface UserService {

    /**
     * Persist an User using UserDaoImpl
     * @param user to persist
     * @return persisted user
     */
    User create(User user);

    /**
     * Updates User using UserDaoImpl
     * @param user to update
     * @return updated user
     */
    User update(User user);

    /**
     * Deletes User using UserDaoImpl
     * @param user to delete
     */
    void delete(User user);

    /**
     * Searches for persisted user by Id using UserDaoImpl
     * @param id of a User
     * @return user found ? User : null
     */
    User findById(Long id);

    /**
     * Searches for persisted user by login using UserDaoImpl
     * @param login of a User
     * @return user found ? User : null
     */
    User findByLogin(String login);

    /**
     * Search for all persisted users using UserDaoImpl
     * @return a List of persisted users
     */
    List<User> findAll();
}
