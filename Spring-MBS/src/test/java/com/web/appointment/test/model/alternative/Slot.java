package com.web.appointment.test.model.alternative;

public class Slot {
	
	private Integer id;
	private String providerName;
	private String hours;
	private Integer appointmentDuration;
	
	public Slot(Integer id, String providerName, String hours, Integer appointmentDuration) {
		super();
		this.id = id;
		this.providerName = providerName;
		this.hours = hours;
		this.appointmentDuration = appointmentDuration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", providerName=" + providerName + ", hours=" + hours + ", appointmentDuration=" + appointmentDuration + "]";
	}

	
	

}
