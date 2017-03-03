package com.web.appointment.service;

import java.util.ArrayList;
import java.util.List;

import com.web.appointment.model.Appointment;

public class AppointmentHandler {

	private Integer providerId;
	private String date;
	private Integer start;
	private Integer end;
	private Integer duration;

	public AppointmentHandler(Integer providerId, String date, Integer start, Integer end, Integer duration) {
		super();
		this.providerId = providerId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.duration = duration;
	}

	public AppointmentHandler(Integer start, Integer end, Integer duration) {
		super();
		this.start = start;
		this.end = end;
		this.duration = duration;
	}

	public AppointmentHandler() {
		super();
	}
	
	// TODO hacer mas eficiente la lista de usaudos deberia estar ordenador por
	// hora
	public List<Appointment> getFreeAppointments(List<String> appointmentsUsed) {

		List<Appointment> resultOpen = new ArrayList<Appointment>();
		Integer startSession;
		Integer endSession;
		int i = 0;
		int appointmenSize = appointmentsUsed.size();
		for (Integer hour = start; hour < end;) {
			
			startSession = hour;
			if ((hour + duration - 60) % 100 == 0) {
				endSession = (hour + duration - 60) + 100;
			} else {
				endSession = hour + duration;
			}
			
			hour = endSession;
			
			if (i < appointmenSize && startSession.equals(Integer.valueOf(appointmentsUsed.get(i).substring(6, 10)))) {
				i++;				
			}else{
				String start = startSession.toString();
				Appointment appointment = new Appointment(providerId, date+(start.length() == 3 ? "0"+start : start ), "OPEN");
				resultOpen.add(appointment);
			}

		}

		return resultOpen;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
