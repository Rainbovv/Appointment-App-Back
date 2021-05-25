package com.stefanini.appointmentapp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.stefanini.appointmentapp.entities.User;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.service.UserService;

@Component
public class AppointmentAuthenticationProvider implements AuthenticationProvider{
	
	private PasswordEncoder passwordEncoder;
	private UserService userService;
	
	public AppointmentAuthenticationProvider(PasswordEncoder passwordEncoder, UserService userService) {
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		User user = userService.findByLogin(username);
		if (user != null) {
			if (passwordEncoder.matches(password, user.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				for (UserRole role : user.getRoles()) {
					authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
				}
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		} else {
			throw new BadCredentialsException("Invalid username!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
