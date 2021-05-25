package com.stefanini.appointmentapp.security.jwt;

import com.stefanini.appointmentapp.security.userdetails.CustomUserDetails;
import com.stefanini.appointmentapp.security.userdetails.CustomUserDetailsFactory;
import com.stefanini.appointmentapp.service.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
public class JwtTokenProvider {
    @Value("${jwt.token.secret}")
    private String secret;
    @Value("${jwt.token.expired}")
    private long validityTimeMillis;
    private UserService userService;

    public JwtTokenProvider(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("roles", getRoleNames(userDetails.getAuthorities()));

        Date currentDate = new Date();
        Date validTillDate = new Date(currentDate.getTime() + validityTimeMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentDate)
                .setExpiration(validTillDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            if (claimsJws.getBody().getExpiration().before(new Date())) {
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("Jwt token time is expired");
        }
    }

    public Authentication getAuthentication(String token) {
        String userLogin = getUserLogin(token);
        UserDetails userDetails = CustomUserDetailsFactory.create(userService.findByLogin(userLogin));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserLogin(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    private List<String> getRoleNames(Collection<? extends GrantedAuthority> userRoles) {
        List<String> roleNames = new ArrayList<>();

        userRoles.forEach(userRole -> roleNames.add(userRole.getAuthority()));

        return roleNames;
    }
}
