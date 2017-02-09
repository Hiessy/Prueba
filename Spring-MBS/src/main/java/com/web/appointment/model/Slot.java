package com.web.appointment.model;

public class Slot {
	
	private Integer id;
	private String specialist;
	
	private int startTimeHour;
	private int startTimeMinute;

	private int endTimeHour;
	private int endTimeMinute;
	private int appointmentDuration;
	
	public Slot(Integer id,String specialist,int startTimeHour, int startTimeMinute, int endTimeHour, int endTimeMinute, int appointmentDuration) {
		super();
		this.id = id;
		this.specialist = specialist;
		this.startTimeHour = startTimeHour;
		this.startTimeMinute = startTimeMinute;
		this.endTimeHour = endTimeHour;
		this.endTimeMinute = endTimeMinute;
		this.appointmentDuration = appointmentDuration;
	}

	public Slot() {
		super();
	}
	
	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(int appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentDuration;
		result = prime * result + endTimeHour;
		result = prime * result + endTimeMinute;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + startTimeHour;
		result = prime * result + startTimeMinute;
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
		Slot other = (Slot) obj;
		if (appointmentDuration != other.appointmentDuration)
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
		if (startTimeHour != other.startTimeHour)
			return false;
		if (startTimeMinute != other.startTimeMinute)
			return false;
		return true;
	}


}
