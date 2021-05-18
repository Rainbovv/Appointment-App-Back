package com.stefanini.appointmentapp.entities;

import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * User is an entity that represents a base user class.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "login", unique = true)
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@Column(name = "status")
	private int status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private UserRole role;

	
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
	 * Gets login.
	 * @return String
	 */

	public String getLogin() {
		return login;
	}
	
	/**
	 * Sets login.
	 * @param login String
	 */

	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * gets password.
	 * @return String
	 */

	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets password.
	 * @param password String
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets data and time of creation.
	 * @return LocalDateTime
	 */

	public LocalDateTime getCreated() {
		return created;
	}
	
	/**
	 * Sets data and time of creation.
	 * @param created LocalDateTime
	 */

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	/**
	 * Gets data and time of last update.
	 * @return LocalDateTime
	 */

	public LocalDateTime getLast_update() {
		return lastUpdate;
	}
	
	/**
	 * Sets data and time of last update.
	 * @param lastUpdate LocalDateTime
	 */

	public void setLast_update(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	/**
	 * Gets status.
	 * @return int
	 */

	public int getStatus() {
		return status;
	}
	
	/**
	 * Sets status.
	 * @param status int
	 */

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", created=" + created +
				", lastUpdate=" + lastUpdate +
				", status=" + status +
				", role=" + role +
				'}';
	}
}
