package com.stefanini.appointmentapp.dto;


public class RegistrationRequestDto {
    private String login;
    private String password;
    private int status;
    private Long roleId;

    public RegistrationRequestDto(String login, String password, int status, Long roleId) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
