package com.stefanini.appointmentapp.dto;

import java.time.LocalDateTime;

public class CreateAppointmentDTO {

    private Long patientId;
    private Long doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String remark;

    public CreateAppointmentDTO(Long patientId, Long doctorId, LocalDateTime endTime,
                                LocalDateTime startTime, String remark) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark = remark;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CreateAppointmentDTO{" +
                "patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
