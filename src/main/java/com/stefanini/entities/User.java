package com.stefanini.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User is an entity that represents a base user class.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private BigInteger id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "last_update")
	private LocalDateTime last_update;
	
	@Column(name = "status")
	private int status;

	/**
	 * Default User constructor.
	 * Constructs and initializes a User object.
	 */
	
	public User() {
		super();
	}
	
	/**
	 * Constructs and initializes a User object with login, password, created, last update, and status.
	 * @param login String
	 * @param password String
	 * @param created LocalDateTime
	 * @param last_update LocalDateTime
	 * @param status int
	 */

	public User(String login, String password, LocalDateTime created, LocalDateTime last_update, int status) {
		super();
		this.login = login;
		this.password = password;
		this.created = created;
		this.last_update = last_update;
		this.status = status;
	}
	
	/**
	 * Gets id.
	 * @return BigInteger
	 */

	public BigInteger getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 * @param id BigInteger
	 */

	public void setId(BigInteger id) {
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
		return last_update;
	}
	
	/**
	 * Sets data and time of last update.
	 * @param last_update LocalDateTime
	 */

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
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
	
}
