package com.stefanini.appointmentapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

	@NotNull
	@Column(name = "login", unique = true)
	private String login;

	@NotNull
	@Column(name = "password")
	private String password;

	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@UpdateTimestamp
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@NotNull
	@Column(name = "status")
	private int status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<UserRole> roles = new ArrayList<>();

	
	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * Gets id.
	 * @return Long
	 */
	
	

	public Long getId() {
		return id;
	}
	
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
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
	@JsonIgnore
	@JsonProperty(value = "password")
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
				'}';
	}
}
