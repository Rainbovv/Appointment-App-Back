package com.stefanini.appointmentapp.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * DailySchedule is an entity that represents daily schedule for a clinic worker.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "daily_schedule")
public class DailySchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "start")
	private LocalDateTime start;

	@NotNull
	@Column(name = "end")
	private LocalDateTime end;

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

	@Override
	public String toString() {
		return "DailySchedule{" +
				"id=" + id +
				", start=" + start +
				", end=" + end +
				'}';
	}
}
