package com.stefanini.appointmentapp.entities;

import java.sql.Date;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start")
	private Date start;
	
	@Column(name = "end")
	private Date end;
	
	@Column(name = "description")
	private String description;

	/**
	 * Default Holiday constructor.
	 * Constructs and initializes a Holiday object.
	 */
	
	public Holiday() {
	}

	/**
	 * Constructs and initializes a Holiday object with start, end, and description.
	 * @param start LocalDateTime
	 * @param end LocalDateTime
	 * @param description String
	 */

	public Holiday(Date start, Date end, String description) {
		super();
		this.start = start;
		this.end = end;
		this.description = description;
	}
	
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
	 * @return Date
	 */

	public Date getStart() {
		return start;
	}
	
	/**
	 * sets start date.
	 * @param start Date
	 */

	public void setStart(Date start) {
		this.start = start;
	}
	
	/**
	 * Gets end date.
	 * @return Date
	 */

	public Date getEnd() {
		return end;
	}
	
	/**
	 * Sets end date.
	 * @param end Date
	 */

	public void setEnd(Date end) {
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
	
	

}
