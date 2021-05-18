package com.stefanini.appointmentapp.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Holiday is an entity that represents days when employees are not available.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "holiday")
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start")
	private LocalDateTime start;
	
	@Column(name = "end")
	private LocalDateTime end;
	
	@Column(name = "description")
	private String description;
	
	/**
	 * Gets id.
	 * @return Long
	 */

	public Long getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 * @param id Long
	 */

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets start date.
	 * @return LocalDateTime
	 */

	public LocalDateTime getStart() {
		return start;
	}
	
	/**
	 * sets start date.
	 * @param start LocalDateTime
	 */

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
	/**
	 * Gets end date.
	 * @return LocalDateTime
	 */

	public LocalDateTime getEnd() {
		return end;
	}
	
	/**
	 * Sets end date.
	 * @param end LocalDateTime
	 */

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	/**
	 * Gets description.
	 * @return String
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Sets description.
	 * @param description String
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Holiday{" +
				"id=" + id +
				", start=" + start +
				", end=" + end +
				", description='" + description + '\'' +
				'}';
	}
}
