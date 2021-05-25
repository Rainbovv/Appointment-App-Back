package com.stefanini.appointmentapp.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.header}")
	private String header;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors()
			.and().csrf().disable()
			.addFilterBefore(new JWTValidatorFilter(secret, header), BasicAuthenticationFilter.class)
			.addFilterAfter(new JWTGeneratorFilter(), BasicAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers("/api/users").hasAnyAuthority("ADMIN", "DOCTOR")
				.antMatchers("/api/profiles").hasAuthority("ADMIN")
				.antMatchers("/api/roles").hasAuthority("DOCTOR");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Collections.singletonList("https://localhost:3000"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.setExposedHeaders(Arrays.asList("Authorization"));
		config.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
