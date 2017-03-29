package com.web.application.model.dto;

import java.util.HashMap;
import java.util.List;

public class PersonalScheduleResponse {
	
	String Name;
	HashMap<String, List<AppointmentSlot>> Appointments;
	
	public PersonalScheduleResponse(String name, HashMap<String, List<AppointmentSlot>> appointments) {
		super();
		Name = name;
		Appointments = appointments;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public HashMap<String, List<AppointmentSlot>> getAppointments() {
		return Appointments;
	}
	public void setAppointments(HashMap<String, List<AppointmentSlot>> appointments) {
		Appointments = appointments;
	}
	
}
