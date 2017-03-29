package com.web.application.model.dto;

public class PersonalSchedule {
	
	private int PersonalScheduleId;
	private int personalId;
	private String monday;
	private String tuesday;
	private String wednesday; 
	private String thursday;
	private String friday; 
	private String saturday;
	private String sunday;
	private String personalState;	
	
	public PersonalSchedule(int personalScheduleId, int personalId, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String personalState) {
		super();
		PersonalScheduleId = personalScheduleId;
		this.personalId = personalId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.personalState = personalState;
	}
	
	public int getPersonalScheduleId() {
		return PersonalScheduleId;
	}
	public void setPersonalScheduleId(int personalScheduleId) {
		PersonalScheduleId = personalScheduleId;
	}
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public String getPersonalState() {
		return personalState;
	}
	public void setPersonalState(String personalState) {
		this.personalState = personalState;
	}
	@Override
	public String toString() {
		return "PersonalSchedule [PersonalScheduleId=" + PersonalScheduleId + ", personalId=" + personalId + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + ", personalState=" + personalState + "]";
	}
	

	
}
