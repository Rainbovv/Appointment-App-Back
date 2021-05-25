package com.stefanini.appointmentapp.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTValidatorFilter extends OncePerRequestFilter{
	
	private String secret;
	private String header;
	
	public JWTValidatorFilter(String secret, String header) {
		super();
		this.secret = secret;
		this.header = header;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt = request.getHeader(header);
		
		if (jwt != null) {
			try {
				SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
				
				Claims claims = Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
						.parseClaimsJws(jwt)
						.getBody();
				String username = String.valueOf(claims.get("username"));
				String authorities = (String) claims.get("authorities");
				Authentication auth = new UsernamePasswordAuthenticationToken(username, null, 
						AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid Token received");
			}
		}
		filterChain.doFilter(request, response);
		
	}
	
	@Override protected boolean shouldNotFilter(HttpServletRequest request) {
		return request.getServletPath().equals("/api/sign-in") || request.getServletPath().equals("/api/sign-up");
	}

}
