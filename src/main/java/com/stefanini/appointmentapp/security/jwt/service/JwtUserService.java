package com.stefanini.appointmentapp.security.jwt.service;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.security.jwt.entity.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserService implements UserDetailsService {

    private final UserDao userDao ;

    public JwtUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByLogin(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new JwtUser(user);
    }
}
