package com.stefanini.appointmentapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stefanini.appointmentapp.entities.SecurityUser;
import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.service.UserService;

@Service
public class AppointmentUserDetails implements UserDetailsService{
	
	private final UserService userService;
	Logger logger = LoggerFactory.getLogger(AppointmentUserDetails.class);
	
	
	public AppointmentUserDetails(UserService userService) {
		this.userService = userService;
	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("###############", username);
		User user = userService.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		return new SecurityUser(user);
	}

}
