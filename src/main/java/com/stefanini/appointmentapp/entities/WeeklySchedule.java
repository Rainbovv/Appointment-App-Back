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
 * WeeklySchedule is an entity that represents weekly schedule for any employee.
 * @author cvigulea
 *
 */

@Entity
@Table(name = "weekly_schedule")
public class WeeklySchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "monday", referencedColumnName = "id")
	private DailySchedule monday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tuesday", referencedColumnName = "id")
	private DailySchedule tuesday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "wednesday", referencedColumnName = "id")
	private DailySchedule wednesday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "thursday", referencedColumnName = "id")
	private DailySchedule thursday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "friday", referencedColumnName = "id")
	private DailySchedule friday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "saturday", referencedColumnName = "id")
	private DailySchedule saturday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "sunday", referencedColumnName = "id")
	private DailySchedule sunday;
	
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
	 * Get schedule for Monday.
	 * @return DailySchedule
	 */

	public DailySchedule getMonday() {
		return monday;
	}
	
	/**
	 * Sets schedule for Monday.
	 * @param monday DailySchedule
	 */

	public void setMonday(DailySchedule monday) {
		this.monday = monday;
	}
	
	/**
	 * Gets schedule for Tuesday.
	 * @return DailySchedule
	 */

	public DailySchedule getTuesday() {
		return tuesday;
	}
	
	/**
	 * Sets schedule for Tuesday.
	 * @param tuesday DailySchedule
	 */

	public void setTuesday(DailySchedule tuesday) {
		this.tuesday = tuesday;
	}
	
	/**
	 * Gets schedule for Wednesday.
	 * @return DailySchedule
	 */

	public DailySchedule getWednesday() {
		return wednesday;
	}
	
	/**
	 * Gets schedule for Wednesday.
	 * @param wednesday DailySchedule
	 */

	public void setWednesday(DailySchedule wednesday) {
		this.wednesday = wednesday;
	}
	
	/**
	 * Gets schedule for Thursday.
	 * @return DailySchedule
	 */

	public DailySchedule getThursday() {
		return thursday;
	}
	
	/**
	 * Sets schedule for Thursday.
	 * @param thursday DailySchedule
	 */

	public void setThursday(DailySchedule thursday) {
		this.thursday = thursday;
	}
	
	/**
	 * Gets schedule for Friday.
	 * @return DailySchedule
	 */

	public DailySchedule getFriday() {
		return friday;
	}
	
	/**
	 * Sets schedule for Friday.
	 * @param friday DailySchedule
	 */

	public void setFriday(DailySchedule friday) {
		this.friday = friday;
	}

	/**
	 * Gets schedule for Saturday.
	 * @return DailySchedule
	 */
	
	public DailySchedule getSaturday() {
		return saturday;
	}

	/**
	 * Gets schedule for Saturday.
	 * @param saturday DailySchedule
	 */
	
	public void setSaturday(DailySchedule saturday) {
		this.saturday = saturday;
	}
	
	/**
	 * Gets schedule for Sunday.
	 * @return DailySchedule
	 */

	public DailySchedule getSunday() {
		return sunday;
	}
	
	/**
	 * Sets schedule for Sunday.
	 * @param sunday DailSchedule
	 */

	public void setSunday(DailySchedule sunday) {
		this.sunday = sunday;
	}

	@Override
	public String toString() {
		return "WeeklySchedule{" +
				"id=" + id +
				", monday=" + monday +
				", tuesday=" + tuesday +
				", wednesday=" + wednesday +
				", thursday=" + thursday +
				", friday=" + friday +
				", saturday=" + saturday +
				", sunday=" + sunday +
				'}';
	}
}
