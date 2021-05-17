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

/**
 * Speciality is an entity that represents a speciality from a department.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "speciality")
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department", referencedColumnName = "id")
	private Department department;

	/**
	 * Default Speciality constructor.
	 * Constructs and initializes a Speciality object.
	 */
	
	public Speciality() {
		super();
	}
	
	/**
	 * Constructs and initializes a Speciality object with name and department.
	 * @param name String
	 * @param department Department
	 */

	public Speciality(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
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
	 *  Sets name.
	 * @param name String
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets department.
	 * @return Department
	 */

	public Department getDepartment() {
		return department;
	}
	
	/**
	 * Sets department.
	 * @param department Department
	 */

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
