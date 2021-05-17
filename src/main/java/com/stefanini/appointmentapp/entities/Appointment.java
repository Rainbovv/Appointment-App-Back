package com.stefanini.appointmentapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private User patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	/**
	 * Default Role constructor.
	 * Constructs and initializes a Role object.
	 */
	
	public Appointment() {
		super();
	}
	
	/**
	 * Constructs and initializes an Appointment object with patient id, doctor id, start time, end time, remark, data and time of creation,
	 * and data and time of last update.
	 * @param patient BigInteger
	 * @param doctor BigInteger
	 * @param endTime Time
	 * @param startTime Time
	 * @param remark String
	 * @param created LocalDataTime
	 * @param lastUpdate LocalDataTime
	 */

	public Appointment(User patient, User doctor, LocalDateTime endTime, LocalDateTime startTime, String remark,
			LocalDateTime created, LocalDateTime lastUpdate) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.endTime = endTime;
		this.startTime = startTime;
		this.remark = remark;
		this.created = created;
		this.lastUpdate = lastUpdate;
	}
	
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
	
	
}