package com.stefanini.entities;

import java.sql.Time;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start")
	private Time start;
	
	@Column(name = "end")
	private Time end;

	/**
	 * Default DailySchedule constructor.
	 * Constructs and initializes a DailySchedule object.
	 */
	
	public DailySchedule() {
		super();
	}
	
	/**
	 * Constructs and initializes a DailySchedule object with start and end time.
	 * @param name String
	 */

	public DailySchedule(Time start, Time end) {
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
	
	public Time getStart() {
		return start;
	}
	
	/**
	 * Sets starting time.
	 * @param start Time
	 */

	public void setStart(Time start) {
		this.start = start;
	}
	
	/**
	 * Gets end time.
	 * @return Time
	 */

	public Time getEnd() {
		return end;
	}
	
	/**
	 * Sets end time.
	 * @param end Time
	 */

	public void setEnd(Time end) {
		this.end = end;
	}
	
	
}
