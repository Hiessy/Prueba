package com.web.application.service;

import java.util.ArrayList;
import java.util.List;

import com.web.application.model.dto.AppointmentSlot;

public class AppointmentHandler {

	private Integer personalId;
	private String date;
	private Integer start;
	private Integer end;
	private Integer duration;

	public AppointmentHandler(Integer personalId, String date, Integer start, Integer end, Integer duration) {
		super();
		this.personalId = personalId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.duration = duration;
	}

	public AppointmentHandler() {
		super();
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
		return personalId;
	}

	public void setProviderId(Integer providerId) {
		this.personalId = providerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	// TODO hacer mas eficiente la lista de usaudos deberia estar ordenador por
	// hora
	public List<AppointmentSlot> getFreeAppointments(List<String> appointmentsUsed) {

		List<AppointmentSlot> resultOpen = new ArrayList<AppointmentSlot>();
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
			} else {
				String start = startSession.toString();
				String dateSlot = (start.length() == 3 ? "0" + start : start);
				resultOpen.add(new AppointmentSlot(dateSlot, "/api/appointment/" + personalId + "/date/" + date + dateSlot));
			}

		}

		return resultOpen;
	}

}
