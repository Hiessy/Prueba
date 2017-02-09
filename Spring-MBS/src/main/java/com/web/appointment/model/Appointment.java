package com.web.appointment.model;

public class Appointment {

	private Integer id;
	private String specialist;
	private String user;
	private SlotState slotState;	
	private int day;
	private int month;
	private int year;	
	private int startTimeHour;
	private int startTimeMinute;
	private int endTimeHour;
	private int endTimeMinute;
	
	public Appointment(Integer id, String specialist, String user, int day, int month, int year, int startTimeHour, int startTimeMinute, int endTimeHour, int endTimeMinute) {
		super();
		this.id = id;
		this.specialist = specialist;
		this.user = user;
		this.slotState = SlotState.SELECTED;
		this.day = day;
		this.month = month;
		this.year = year;
		this.startTimeHour = startTimeHour;
		this.startTimeMinute = startTimeMinute;
		this.endTimeHour = endTimeHour;
		this.endTimeMinute = endTimeMinute;
	}
	public Appointment(Integer id, String specialist, int day, int month, int year, int startTimeHour, int startTimeMinute, int endTimeHour, int endTimeMinute) {
		super();
		this.id = id;
		this.day = day;
		this.month = month;
		this.year = year;
		this.specialist = specialist;
		this.slotState = SlotState.OPEN;
		this.startTimeHour = startTimeHour;
		this.startTimeMinute = startTimeMinute;
		this.endTimeHour = endTimeHour;
		this.endTimeMinute = endTimeMinute;
	}
	

	public Appointment(Integer id, String specialist, String user, SlotState slotState, int day, int month, int year, int startTimeHour, int startTimeMinute, int endTimeHour, int endTimeMinute) {
		super();
		this.id = id;
		this.specialist = specialist;
		this.user = user;
		this.slotState = slotState;
		this.day = day;
		this.month = month;
		this.year = year;
		this.startTimeHour = startTimeHour;
		this.startTimeMinute = startTimeMinute;
		this.endTimeHour = endTimeHour;
		this.endTimeMinute = endTimeMinute;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStartTimeHour() {
		return startTimeHour;
	}
	public void setStartTimeHour(int startTimeHour) {
		this.startTimeHour = startTimeHour;
	}
	public int getStartTimeMinute() {
		return startTimeMinute;
	}
	public void setStartTimeMinute(int startTimeMinute) {
		this.startTimeMinute = startTimeMinute;
	}
	public int getEndTimeHour() {
		return endTimeHour;
	}
	public void setEndTimeHour(int endTimeHour) {
		this.endTimeHour = endTimeHour;
	}
	public int getEndTimeMinute() {
		return endTimeMinute;
	}
	public void setEndTimeMinute(int endTimeMinute) {
		this.endTimeMinute = endTimeMinute;
	}
	public SlotState getSlotState() {
		return slotState;
	}
	public void setSlotState(SlotState slotState) {
		this.slotState = slotState;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + endTimeHour;
		result = prime * result + endTimeMinute;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + month;
		result = prime * result + ((slotState == null) ? 0 : slotState.hashCode());
		result = prime * result + ((specialist == null) ? 0 : specialist.hashCode());
		result = prime * result + startTimeHour;
		result = prime * result + startTimeMinute;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (day != other.day)
			return false;
		if (endTimeHour != other.endTimeHour)
			return false;
		if (endTimeMinute != other.endTimeMinute)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (month != other.month)
			return false;
		if (slotState != other.slotState)
			return false;
		if (specialist == null) {
			if (other.specialist != null)
				return false;
		} else if (!specialist.equals(other.specialist))
			return false;
		if (startTimeHour != other.startTimeHour)
			return false;
		if (startTimeMinute != other.startTimeMinute)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
	    return "Appointment [id=" + id + ", specialist=" + specialist + ", user=" + user + ", slotState=" + slotState + ", day=" + day + ", month=" + month + ", year=" + year + ", startTimeHour="
		    + startTimeHour + ", startTimeMinute=" + startTimeMinute + ", endTimeHour=" + endTimeHour + ", endTimeMinute=" + endTimeMinute + "]";
	}
	
}
