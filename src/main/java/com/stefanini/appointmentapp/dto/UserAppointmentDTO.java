package com.stefanini.appointmentapp.dto;

import java.time.LocalDateTime;

public class UserAppointmentDTO {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String firstName;
    private String lastName;
    private int office;

    public UserAppointmentDTO(Long id, LocalDateTime startTime, LocalDateTime endTime,
                              String firstName, String lastName, int office) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "UserAppointmentDTO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", office=" + office +
                '}';
    }
}
