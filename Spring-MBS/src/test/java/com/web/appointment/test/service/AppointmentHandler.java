package com.web.appointment.test.service;

import java.util.ArrayList;
import java.util.List;

import com.web.appointment.test.model.alternative.Appointment;
import com.web.appointment.test.model.alternative.Slot;

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

	// TODO hacer mas eficiente la lista de usaudos deberia estar ordenador por
	// hora
	public List<Appointment> getFreeAppointments(List<Appointment> appointmentsUsed) {

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
			
			if (i < appointmenSize && startSession.equals(Integer.valueOf(appointmentsUsed.get(i).getAppointmentHour().substring(0, 4)))) {
				i++;				
			}else{
				Appointment appointment = new Appointment(providerId, date, (startSession + ":" + endSession), "OPEN");
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

}
