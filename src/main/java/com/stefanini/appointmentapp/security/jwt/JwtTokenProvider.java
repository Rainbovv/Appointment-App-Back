package com.stefanini.appointmentapp.security.jwt;

import com.stefanini.appointmentapp.dto.AuthenticationResponseDto;
import com.stefanini.appointmentapp.security.userdetails.CustomUserDetails;
import com.stefanini.appointmentapp.security.userdetails.CustomUserDetailsFactory;
import com.stefanini.appointmentapp.service.UserProfileService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    private final UserProfileService profileService;

    public JwtTokenProvider(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public AuthenticationResponseDto createToken(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = getRoleNames(userDetails.getAuthorities());

        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("roles", roles);

        Date currentDate = new Date();
        Date validTillDate = new Date(currentDate.getTime() + validityTimeMillis);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentDate)
                .setExpiration(validTillDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return new AuthenticationResponseDto(userDetails.getId(),
                userDetails.getFirstName(), userDetails.getUsername(), token, roles);
    }

    public boolean validateToken(String token) {

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        return !claimsJws.getBody().getExpiration().before(new Date());
    }

    public Authentication getAuthentication(String token) {

        UserDetails userDetails = CustomUserDetailsFactory
                .create(profileService.findByLogin(getUserLogin(token)));

        return new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
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
