package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    Set<User> findAll() {

        return userService.findAll();
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody User user) {
    	logger.info(user.toString());
        return userService.create(user);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    User update(@RequestBody User user) {

        return userService.update(user);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody User user) {

        userService.delete(user);
    }

}
