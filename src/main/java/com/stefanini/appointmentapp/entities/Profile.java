package com.stefanini.appointmentapp.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profile is an entity that represents personal and public information about a users.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "doctors_speciality", 
			joinColumns = { @JoinColumn(name = "doctor_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "speciality_id")})
	private Set<Speciality> specialies;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "about")
	private String about;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "telepone")
	private String telephone;
	
	@Column(name = "office")
	private int office;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule", referencedColumnName = "weekly_schedule")
	private WeeklySchedule schedule;
	
	@Column(name = "date_of_birth")
	private Date date_of_birth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "social_number")
	private String social_number;
	
	@Column(name = "gender")
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holiday", referencedColumnName = "id")
	private Set<Holiday> holidays;

	/**
	 * Default Profile constructor.
	 * Constructs and initializes a profile object.
	 */
	
	public Profile() {
		super();
	}

	public Profile(Long id, User user_id, String first_name, String last_name, String about, String degree,
			String telephone, int office, String email, WeeklySchedule schedule, Date date_of_birth, String address,
			String social_number, String gender, Set<Holiday> holidays) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.about = about;
		this.degree = degree;
		this.telephone = telephone;
		this.office = office;
		this.email = email;
		this.schedule = schedule;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.social_number = social_number;
		this.gender = gender;
		this.holidays = holidays;
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

	public void setA(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets user id.
	 * @return BigInteger
	 */

	public User getUser_id() {
		return user_id;
	}
	
	/**
	 * Sets user id.
	 * @param user_id BigInteger
	 */

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * Gets first name.
	 * @return String
	 */

	public String getFirst_name() {
		return first_name;
	}
	
	/**
	 * Sets first name.
	 * @param first_name String
	 */

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	/**
	 * Gets last name.
	 * @return String
	 */

	public String getLast_name() {
		return last_name;
	}
	
	/**
	 * Sets last name.
	 * @param last_name String
	 */

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	/**
	 * Gets about info.
	 * @return String
	 */

	public String getAbout() {
		return about;
	}
	
	/**
	 * Sets about info.
	 * @param about String
	 */

	public void setAbout(String about) {
		this.about = about;
	}
	
	/**
	 * Gets doctor's degree.
	 * @return String
	 */

	public String getDegree() {
		return degree;
	}
	
	/**
	 * Sets doctor's degree.
	 * @param degree String
	 */

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	/**
	 * Gets telephone number.
	 * @return String
	 */

	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * Sets telephone number.
	 * @param telephone String
	 */

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Gets office.
	 * @return id
	 */

	public int getOffice() {
		return office;
	}
	
	/**
	 * Sets office.
	 * @param office int
	 */

	public void setOffice(int office) {
		this.office = office;
	}
	
	/**
	 * Gets email
	 * @return String
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email.
	 * @param email String
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets schedule.
	 * @return WeeklySchedule
	 */

	public WeeklySchedule getSchedule() {
		return schedule;
	}
	
	/**
	 * Sets schedule.
	 * @param schedule WeeklySchedule
	 */

	public void setSchedule(WeeklySchedule schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * Gets date of birth.
	 * @return Date
	 */

	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	/**
	 * Sets date of birth.
	 * @param date_of_birth Date
	 */

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	/**
	 * Gets address.
	 * @return String
	 */

	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets address.
	 * @param address String
	 */

	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets social number.
	 * @return String
	 */

	public String getSocial_number() {
		return social_number;
	}
	
	/**
	 * Sets social number.
	 * @param social_number String
	 */

	public void setSocial_number(String social_number) {
		this.social_number = social_number;
	}
	
	/**
	 * Gets gender.
	 * @return String
	 */

	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets gender.
	 * @param gender String
	 */

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets holiday.
	 * @return Set<Holiday>
	 */

	public Set<Holiday> getHoliday() {
		return holidays;
	}
	
	/**
	 * Set holiday.
	 * @param holiday Set<Holiday>
	 */

	public void setHoliday(Set<Holiday> holidays) {
		this.holidays = holidays;
	}
}
