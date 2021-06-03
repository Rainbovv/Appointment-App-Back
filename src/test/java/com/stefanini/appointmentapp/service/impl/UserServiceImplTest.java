package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.dao.UserDao;
import com.stefanini.appointmentapp.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    static User user1;
    static User user2;

    @BeforeAll
    static void beforeAll() {
        user1 = new User();
        user1.setLogin("login1");
        user1.setPassword("password1");
        user1.setId(1L);

        user2 = new User();
        user2.setLogin("login2");
        user2.setPassword("password2");
        user2.setId(2L);
    }

    @Test
    void findAll(){
        List<User> returnUsers = new ArrayList<>();
        returnUsers.add(user1);
        returnUsers.add(user2);

        when(userDao.findAll()).thenReturn(returnUsers);

        List<User> foundUsers = userService.findAll();

        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());
    }

    @Test
    void findById() {

    }
}