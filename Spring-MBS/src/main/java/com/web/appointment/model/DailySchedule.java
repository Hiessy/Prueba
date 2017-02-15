package com.web.appointment.model;

import java.util.HashMap;

public class DailySchedule {
	
	HashMap<String, Branch> dailySchedule = new HashMap<String, Branch>();

	public HashMap<String, Branch> getDailySchedule() {
		return dailySchedule;
	}

	public void setDailySchedule(HashMap<String, Branch> dailySchedule) {
		this.dailySchedule = dailySchedule;
	}

	@Override
	public String toString() {
		return "DailySchedule [dailySchedule=" + dailySchedule + "]";
	}
	
	
}
