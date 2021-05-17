package com.stefanini.entities;

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
 * Role is an entity that represents roles that users may have.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user_id;
	
	@Column(name = "name")
	private String name;

	/**
	 * Default Role constructor.
	 * Constructs and initializes a Role object.
	 */
	
	public Role() {
		super();
	}

	/**
	 * Constructs and initializes a Role object with name.
	 * @param name String
	 */
	
	public Role(User user_id, String name) {
		super();
		this.user_id = user_id;
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
	 * Gets user id.
	 * @return Long
	 */

	public User getUser_id() {
		return user_id;
	}
	
	/**
	 * Sets user id.
	 * @param user_id Long
	 */

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * Gets role name.
	 * @return String
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Sets role name.
	 * @param name String
	 */

	public void setName(String name) {
		this.name = name;
	}
}
