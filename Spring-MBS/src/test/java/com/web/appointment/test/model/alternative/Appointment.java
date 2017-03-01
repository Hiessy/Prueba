package com.web.appointment.test.model.alternative;



public class Appointment {

	private Integer appointmentId;// Id_Turno
	private Integer providerId;// Id_Proveedor
	private Integer customerId;// Id_Sucursal
	private String appointmentDate;// Fecha_ResTurno
	private String appointmentHour;
	private String appointmentState;	
	
	
	public Appointment() {
		super();
	}
	
	public Appointment(String appointmentHour, String appointmentState) {
		super();
		this.appointmentHour = appointmentHour;
		this.appointmentState = appointmentState;
	}

	public Appointment(Integer providerId, Integer customerId, String appointmentDate, String appointmentHour, String appointmentState) {
		super();
		this.providerId = providerId;
		this.customerId = customerId;
		this.appointmentDate = appointmentDate;
		this.appointmentHour = appointmentHour;
		this.appointmentState = appointmentState;
	}

	
	public Appointment(Integer appointmentId, Integer providerId, Integer customerId, String appointmentDate, String appointmentHour, String appointmentState) {
		super();
		this.appointmentId = appointmentId;
		this.providerId = providerId;
		this.customerId = customerId;
		this.appointmentDate = appointmentDate;
		this.appointmentHour = appointmentHour;
		this.appointmentState = appointmentState;
	}

	public Appointment(Integer providerId, String appointmentDate, String appointmentHour, String appointmentState) {
		super();
		this.providerId = providerId;
		this.appointmentDate = appointmentDate;
		this.appointmentHour = appointmentHour;
		this.appointmentState = appointmentState;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public Integer getProviderId() {
		return providerId;
	}
	
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentHour() {
		return appointmentHour;
	}
	
	public void setAppointmentHour(String appointmentHour) {
		this.appointmentHour = appointmentHour;
	}
	
	public String getAppointmentState() {
		return appointmentState;
	}
	
	public void setAppointmentState(String appointmentState) {
		this.appointmentState = appointmentState;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", providerId=" + providerId + ", customerId=" + customerId + ", appointmentDate=" + appointmentDate + ", appointmentHour=" + appointmentHour + ", appointmentState=" + appointmentState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + ((appointmentHour == null) ? 0 : appointmentHour.hashCode());
		result = prime * result + ((appointmentId == null) ? 0 : appointmentId.hashCode());
		result = prime * result + ((appointmentState == null) ? 0 : appointmentState.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((providerId == null) ? 0 : providerId.hashCode());
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
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (appointmentHour == null) {
			if (other.appointmentHour != null)
				return false;
		} else if (!appointmentHour.equals(other.appointmentHour))
			return false;
		if (appointmentId == null) {
			if (other.appointmentId != null)
				return false;
		} else if (!appointmentId.equals(other.appointmentId))
			return false;
		if (appointmentState == null) {
			if (other.appointmentState != null)
				return false;
		} else if (!appointmentState.equals(other.appointmentState))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (providerId == null) {
			if (other.providerId != null)
				return false;
		} else if (!providerId.equals(other.providerId))
			return false;
		return true;
	}	

}
