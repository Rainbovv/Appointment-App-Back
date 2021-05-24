package com.stefanini.appointmentapp.security.jwt.dto;


public class AuthenticationResponseDTO {
    private String username;
    private String token;

    public AuthenticationResponseDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthenticationResponseDTO{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
