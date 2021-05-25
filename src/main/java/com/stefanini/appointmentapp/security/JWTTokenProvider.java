package com.stefanini.appointmentapp.security;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTTokenProvider {
	
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String createToken() {
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return Jwts.builder().setIssuer("Appointment App").setSubject("JWT Token")
				.claim("username", auth.getName())
				.claim("authorities", populateAuthorities(auth.getAuthorities()))
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration))
				.signWith(key).compact();
	}

	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
		for (GrantedAuthority authority : collection) {
			authoritiesSet.add(authority.getAuthority());
		}
		return String.join(",", authoritiesSet);
	}
	
}
