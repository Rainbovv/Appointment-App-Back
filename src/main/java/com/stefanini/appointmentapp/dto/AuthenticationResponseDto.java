package com.stefanini.appointmentapp.dto;


public class AuthenticationResponseDto {
    private Long id;
    private String firstName;
    private String username;
    private String token;

    public AuthenticationResponseDto(Long id, String firstName, String username, String token) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.token = token;
    }

    public AuthenticationResponseDto(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "AuthenticationResponseDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
