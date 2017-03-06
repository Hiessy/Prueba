package com.web.appointment.model;



public class AppointmentSlot {

	private String appointmentTime;// Fecha_ResTurno
	private String appointmentUri;
	
	public AppointmentSlot() {
		super();
	}
	public AppointmentSlot(String appointmentTime, String appointmentUri) {
		super();
		this.appointmentTime = appointmentTime;
		this.appointmentUri = appointmentUri;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getAppointmentUri() {
		return appointmentUri;
	}
	public void setAppointmentUri(String appointmentUri) {
		this.appointmentUri = appointmentUri;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentTime == null) ? 0 : appointmentTime.hashCode());
		result = prime * result + ((appointmentUri == null) ? 0 : appointmentUri.hashCode());
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
		AppointmentSlot other = (AppointmentSlot) obj;
		if (appointmentTime == null) {
			if (other.appointmentTime != null)
				return false;
		} else if (!appointmentTime.equals(other.appointmentTime))
			return false;
		if (appointmentUri == null) {
			if (other.appointmentUri != null)
				return false;
		} else if (!appointmentUri.equals(other.appointmentUri))
			return false;
		return true;
	}	
	
}
