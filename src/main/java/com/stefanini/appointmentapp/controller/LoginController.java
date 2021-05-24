package com.stefanini.appointmentapp.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;

@RestController
@RequestMapping(LoginController.BASE_URL)
public class LoginController {
	
	public static final String BASE_URL = "/api/login";
	
	private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping
	public User getUserDetailsAfterLogin(Principal principal) {
		return userService.findByLogin(principal.getName());
	}
	
	

}
