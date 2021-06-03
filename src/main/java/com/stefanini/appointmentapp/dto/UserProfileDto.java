package com.stefanini.appointmentapp.dto;

import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.entities.enums.RoleName;

public class UserProfileDto {
    Long userId;
    Long profileId;
    String firstName;
    String lastName;
    String email;
    String telephone;
    Long roleId;
    RoleName roleName;

    public UserProfileDto() {}

    public UserProfileDto(Long userId, Long profileId,
                          String firstName, String lastName,
                          String email, String telephone,
                          Long roleId, RoleName roleName) {
        this.userId = userId;
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserProfileDto{" +
                "userId=" + userId +
                ", profileId=" + profileId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
