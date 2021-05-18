package com.stefanini.appointmentapp.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToMany()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Set<User> users = new HashSet<>();
	
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
	
	public Role(Set<User> users, String name) {
		super();
		this.users = users;
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
	 * Gets users.
	 * @return Set<User>
	 */

	public Set<User> getUsers() {
		return users;
	}
	
	/**
	 * Sets users.
	 * @param users Set<User>
	 */

	public void setUsers(Set<User> users) {
		this.users = users;
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
