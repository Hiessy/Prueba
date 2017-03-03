package com.web.appointment.test.model.alternative;



public class Appointment {

	private Integer appointmentId;// Id_Turno
	private Integer providerId;// Id_Proveedor
	private Integer customerId;// Id_Sucursal
	private String appointmentTime;// Fecha_ResTurno
	private String appointmentState;	
	
	public Appointment() {
		super();
	}
	
	public Appointment(String appointmentState) {
		super();
		this.appointmentState = appointmentState;
	}

	public Appointment(Integer providerId, Integer customerId, String appointmentDate, String appointmentState) {
		super();
		this.providerId = providerId;
		this.customerId = customerId;
		this.appointmentTime = appointmentDate;
		this.appointmentState = appointmentState;
	}

	
	public Appointment(Integer appointmentId, Integer providerId, Integer customerId, String appointmentTime,  String appointmentState) {
		super();
		this.appointmentId = appointmentId;
		this.providerId = providerId;
		this.customerId = customerId;
		this.appointmentTime = appointmentTime;

		this.appointmentState = appointmentState;
	}

	public Appointment(Integer providerId, String appointmentTime, String appointmentState) {
		super();
		this.providerId = providerId;
		this.appointmentTime = appointmentTime;
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
	
	public String getAppointmentTime() {
		return appointmentTime;
	}
	
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public String getAppointmentState() {
		return appointmentState;
	}
	
	public void setAppointmentState(String appointmentState) {
		this.appointmentState = appointmentState;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", providerId=" + providerId + ", customerId=" + customerId + ", appointmentTime=" + appointmentTime + ", appointmentState=" + appointmentState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentId == null) ? 0 : appointmentId.hashCode());
		result = prime * result + ((appointmentState == null) ? 0 : appointmentState.hashCode());
		result = prime * result + ((appointmentTime == null) ? 0 : appointmentTime.hashCode());
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
		if (appointmentTime == null) {
			if (other.appointmentTime != null)
				return false;
		} else if (!appointmentTime.equals(other.appointmentTime))
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
