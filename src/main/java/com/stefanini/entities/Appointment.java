package com.stefanini.entities;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private BigInteger id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private User patient_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor_id;
	
	@Column(name = "end_time")
	private Time end_time;
	
	@Column(name = "start_time")
	private Time start_time;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "last_update")
	private LocalDateTime last_update;

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
	 * @param patient_id BigInteger
	 * @param doctor_id BigInteger
	 * @param end_time Time
	 * @param start_time Time
	 * @param remark String
	 * @param created LocalDataTime
	 * @param last_update LocalDataTime
	 */

	public Appointment(User patient_id, User doctor_id, Time end_time, Time start_time, String remark,
			LocalDateTime created, LocalDateTime last_update) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.end_time = end_time;
		this.start_time = start_time;
		this.remark = remark;
		this.created = created;
		this.last_update = last_update;
	}
	
	/**
	 * Gets id.
	 * @return BigInteger
	 */

	public BigInteger getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 * @param id BigInteger
	 */

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	/**
	 * Gets patient.
	 * @return User
	 */

	public User getPatient_id() {
		return patient_id;
	}
	
	/**
	 * Sets patient.
	 * @param patient_id User
	 */

	public void setPatient_id(User patient_id) {
		this.patient_id = patient_id;
	}
	
	/**
	 * Gets doctor.
	 * @return User
	 */

	public User getDoctor_id() {
		return doctor_id;
	}
	
	/**
	 * Sets doctor.
	 * @param doctor_id User
	 */

	public void setDoctor_id(User doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	/**
	 * Gets end time.
	 * @return Time
	 */

	public Time getEnd_time() {
		return end_time;
	}
	
	/**
	 * Sets end time.
	 * @param end_time Time
	 */

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	
	/**
	 * Gets start time.
	 * @return Time
	 */

	public Time getStart_time() {
		return start_time;
	}
	
	/**
	 * Sets start time.
	 * @param start_time Time
	 */

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
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

	public LocalDateTime getLast_update() {
		return last_update;
	}
	
	/**
	 * Sets data and time of last update.
	 * @param last_update LocalDateTime
	 */

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
	
	
}
