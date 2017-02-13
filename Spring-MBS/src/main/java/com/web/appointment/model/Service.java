package com.web.appointment.model;

import java.util.HashMap;
import java.util.List;

public class Service {
	
	private String serviceName;
	private HashMap<SlotState, List<Appointment>> serviceAppointments = new HashMap<SlotState, List<Appointment>>();

	public HashMap<SlotState, List<Appointment>> getBranchAppointments() {
		return serviceAppointments;
	}

	public void setBranchAppointments(HashMap<SlotState, List<Appointment>> branchAppointments) {
		this.serviceAppointments = branchAppointments;
	}

	@Override
	public String toString() {
		return "Branch [branchAppointments=" + serviceAppointments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceAppointments == null) ? 0 : serviceAppointments.hashCode());
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
		Branch other = (Branch) obj;
		if (serviceAppointments == null) {
			if (other.serviceAppointments != null)
				return false;
		} else if (!serviceAppointments.equals(other.serviceAppointments))
			return false;
		return true;
	}

}
