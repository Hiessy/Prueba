package com.web.appointment.model;

import java.util.HashMap;
import java.util.List;

public class Branch {
	
	private HashMap<SlotState, List<Appointment>> branchAppointments = new HashMap<SlotState, List<Appointment>>();

	public HashMap<SlotState, List<Appointment>>  getBranchAppointments() {
		return branchAppointments;
	}

	public void setBranchAppointments(HashMap<SlotState, List<Appointment>> branchAppointments) {
		this.branchAppointments = branchAppointments;
	}

	@Override
	public String toString() {
		return "Branch [branchAppointments=" + branchAppointments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAppointments == null) ? 0 : branchAppointments.hashCode());
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
		if (branchAppointments == null) {
			if (other.branchAppointments != null)
				return false;
		} else if (!branchAppointments.equals(other.branchAppointments))
			return false;
		return true;
	}


	
}
