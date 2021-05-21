package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Loggable
    @GetMapping("")
    List<User> findAll() {
        return userService.findAll();
    }

    @Loggable
    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @Loggable
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody User user) {

        return userService.create(user);

    }

    @Loggable
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    User update(@RequestBody User user) {

        return userService.update(user);
    }

    @Loggable
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody User user) {

        userService.delete(user);
    }

}
