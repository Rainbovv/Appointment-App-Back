package com.stefanini.appointmentapp.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Appointment is an entity that represents appointments made by users.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private User patient;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;

	@NotNull
	@Column(name = "end_time")
	private LocalDateTime endTime;

	@NotNull
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "remark")
	private String remark;

	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@UpdateTimestamp
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	/**
	 * Gets id.
	 * @return BigInteger
	 */

	public Long getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 * @param id BigInteger
	 */

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets patient.
	 * @return User
	 */

	public User getPatient() {
		return patient;
	}
	
	/**
	 * Sets patient.
	 * @param patient User
	 */

	public void setPatient_id(User patient) {
		this.patient = patient;
	}
	
	/**
	 * Gets doctor.
	 * @return User
	 */

	public User getDoctor() {
		return doctor;
	}
	
	/**
	 * Sets doctor.
	 * @param doctor User
	 */

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * Gets end time.
	 * @return Time
	 */

	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets end time.
	 * @param endTime Time
	 */

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Gets start time.
	 * @return Time
	 */

	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets start time.
	 * @param startTime Time
	 */

	public void setStarTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Gets remark.
	 * @return String
	 */

	public String getRemark() {
		return remark;
	}
	
	/**
	 * Sets remark.
	 * @param remark String
	 */

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Gets data and time of creation.
	 * @return LocalDateTime
	 */

	public LocalDateTime getCreated() {
		return created;
	}
	
	/**
	 * Sets data and time of creation.
	 * @param created LocalDateTime
	 */

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	/**
	 * Gets data and time of last update.
	 * @return LocalDateTime
	 */

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	
	/**
	 * Sets data and time of last update.
	 * @param lastUpdate LocalDateTime
	 */

	public void setLast_update(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", patient=" + patient +
				", doctor=" + doctor +
				", endTime=" + endTime +
				", startTime=" + startTime +
				", remark='" + remark + '\'' +
				", created=" + created +
				", lastUpdate=" + lastUpdate +
				'}';
	}
}
