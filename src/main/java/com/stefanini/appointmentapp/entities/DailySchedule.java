package com.stefanini.appointmentapp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

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
	private LocalTime start;

	@NotNull
	@Column(name = "end")
	private LocalTime end;

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
	
	public LocalTime getStart() {
		return start;
	}
	
	/**
	 * Sets starting time.
	 * @param start Time
	 */

	public void setStart(LocalTime start) {
		this.start = start;
	}
	
	/**
	 * Gets end time.
	 * @return Time
	 */

	public LocalTime getEnd() {
		return end;
	}
	
	/**
	 * Sets end time.
	 * @param end Time
	 */

	public void setEnd(LocalTime end) {
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
