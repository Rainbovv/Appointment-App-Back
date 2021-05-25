package com.stefanini.appointmentapp.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.appointmentapp.security.DTO.ResponseDto;
import com.stefanini.appointmentapp.security.DTO.SignInRequestDto;
import com.stefanini.appointmentapp.security.DTO.SignUpRequestDto;
import com.stefanini.appointmentapp.service.UserService;

@RestController
public class AuthenticationController {
	
	private AuthenticationManager authManager;
	private JWTTokenProvider jwtTokenProvider;
	private UserService userService;
	
	public AuthenticationController(AuthenticationManager authManager, 
									JWTTokenProvider jwtTokenProvider,
									UserService userService) {
		this.authManager = authManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@PostMapping("/api/sign-in")
	public ResponseDto userSignIn(@RequestBody SignInRequestDto signInRequestDto) {
		try {
			ResponseDto response = new ResponseDto();
			Authentication auth = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							signInRequestDto.getUserName(), 
							signInRequestDto.getPassword()
					));
			SecurityContextHolder.getContext().setAuthentication(auth);
			response.setJWTKey(jwtTokenProvider.createToken());
			response.setUserName(signInRequestDto.getUserName());
			return response;
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid login or password");
		}
		
	}
	
	@PostMapping("/api/sign-up")
	public ResponseDto userSignUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		ResponseDto response = new ResponseDto();
		userService.registerNewUser(signUpRequestDto);
		Authentication auth = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						signUpRequestDto.getEmail(), 
						signUpRequestDto.getPassword()
				));
		SecurityContextHolder.getContext().setAuthentication(auth);
		response.setJWTKey(jwtTokenProvider.createToken());
		response.setUserName(signUpRequestDto.getEmail());
		return response;
	}
}
