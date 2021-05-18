package com.stefanini.appointmentapp.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Profile is an entity that represents personal and public information about a users.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "doctors_speciality", 
			joinColumns = { @JoinColumn(name = "doctor_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "speciality_id")})
	private Set<Speciality> specialities;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "about")
	private String about;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "office")
	private int office;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule")
	private WeeklySchedule schedule;
	
	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "social_number")
	private String socialNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holiday", referencedColumnName = "id")
	private Set<Holiday> holidays = new HashSet<>();

	
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
		return user;
	}
	
	/**
	 * Sets user id.
	 * @param user_id BigInteger
	 */

	public void setUser(User user_id) {
		this.user = user_id;
	}
	
	/**
	 * Gets first name.
	 * @return String
	 */

	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets first name.
	 * @param firstName String
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets last name.
	 * @return String
	 */

	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets last name.
	 * @param lastName String
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets date of birth.
	 * @param dateOfBirth Date
	 */

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getSocialNumber() {
		return socialNumber;
	}
	
	/**
	 * Sets social number.
	 * @param socialNumber String
	 */

	public void setSocialNumber(String socialNumber) {
		this.socialNumber = socialNumber;
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
	 * @param holidays Set<Holiday>
	 */

	public void setHoliday(Set<Holiday> holidays) {
		this.holidays = holidays;
	}

	@Override
	public String toString() {
		return "Profile{" +
				"id=" + id +
				", specialities=" + specialities +
				", user=" + user +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", about='" + about + '\'' +
				", degree='" + degree + '\'' +
				", telephone='" + telephone + '\'' +
				", office=" + office +
				", email='" + email + '\'' +
				", schedule=" + schedule +
				", dateOfBirth=" + dateOfBirth +
				", address='" + address + '\'' +
				", socialNumber='" + socialNumber + '\'' +
				", gender='" + gender + '\'' +
				", holidays=" + holidays +
				'}';
	}
}
