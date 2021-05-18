package com.stefanini.appointmentapp.entities;

import com.stefanini.appointmentapp.entities.enums.RoleName;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role is an entity that represents roles that users may have.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@OneToMany(mappedBy = "id")
	private Set<User> users = new HashSet<>();
	
	@Column(name = "name")
	private RoleName name;
	
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

	public RoleName getName() {
		return name;
	}
	
	/**
	 * Sets role name.
	 * @param name String
	 */

	public void setName(RoleName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", users=" + users +
				", name='" + name + '\'' +
				'}';
	}
}
