package com.stefanini.appointmentapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department is an entity that represents departments in clinic.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	/**
	 * Default Department constructor.
	 * Constructs and initializes a Department object.
	 */
	
	public Department() {
		super();
	}
	
	/**
	 * Constructs and initializes a Department object with name.
	 * @param name String
	 */
	
	public Department(String name) {
		this.name = name;
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
	 * Gets name.
	 * @return String
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * @param name String
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}
