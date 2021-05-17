package com.stefanini.appointmentapp.entities;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DailySchedule is an entity that represents daily schedule for a clinic worker.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "daily_schedule")
public class DailySchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start")
	private LocalDateTime start;
	
	@Column(name = "end")
	private LocalDateTime end;

	/**
	 * Default DailySchedule constructor.
	 * Constructs and initializes a DailySchedule object.
	 */
	
	public DailySchedule() {
		super();
	}

	/**
	 * Constructs and initializes a DailySchedule object with start and end time.
	 * @param start LocalDateTime
	 * @param end LocalDateTime
	 */

	public DailySchedule(LocalDateTime start, LocalDateTime end) {
		super();
		this.start = start;
		this.end = end;
	}

	/**
	 * gets id.
	 * @return Long
	 */
	
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets Id.
	 * @param id Long
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets starting time.
	 * @return Time
	 */
	
	public LocalDateTime getStart() {
		return start;
	}
	
	/**
	 * Sets starting time.
	 * @param start Time
	 */

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
	/**
	 * Gets end time.
	 * @return Time
	 */

	public LocalDateTime getEnd() {
		return end;
	}
	
	/**
	 * Sets end time.
	 * @param end Time
	 */

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	
}
