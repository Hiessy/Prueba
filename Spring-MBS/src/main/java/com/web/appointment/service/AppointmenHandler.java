package com.web.appointment.service;

import java.util.ArrayList;
import java.util.List;

import com.web.appointment.model.Appointment;
import com.web.appointment.model.Branch;
import com.web.appointment.model.Slot;
import com.web.appointment.model.SlotState;

public class AppointmenHandler {

    private Slot workHours;

    // TODO Contemplar dias
    public AppointmenHandler(Slot workHours) {
	this.workHours = workHours;
    }

    public Branch getFreeAppointments(List<Appointment> appointmentsUsed) {
	Branch branch = new Branch();

	List<Appointment> resultOpen = new ArrayList<Appointment>();
	List<Appointment> resultSelected = new ArrayList<Appointment>();
	List<Appointment> resultConfirm = new ArrayList<Appointment>();
	List<Appointment> resultClosed = new ArrayList<Appointment>();

	int n = workHours.getStartTimeMinute();
	int i = workHours.getStartTimeHour();
	// Logica que genera turno libres
	while (i < workHours.getEndTimeHour()) {

	    outerloop: while (n < 60) {
		for (Appointment appointment : appointmentsUsed) {
		    if (appointment.getStartTimeHour() == i && appointment.getStartTimeMinute() == n) {
			i = appointment.getEndTimeHour();
			n = appointment.getEndTimeMinute();
			appointmentsUsed.remove(appointment);

			switch (appointment.getSlotState()) {
			case SELECTED:
			    resultSelected.add(new Appointment(workHours.getId(), workHours.getSpecialist(), appointment.getUser(), appointment.getSlotState(), 1, 1, 2016,
				    appointment.getStartTimeHour(), appointment.getStartTimeMinute(), i, n));
			    break outerloop;
			case CONFIRM:
			    resultConfirm.add(new Appointment(workHours.getId(), workHours.getSpecialist(), appointment.getUser(), appointment.getSlotState(), 1, 1, 2016,
				    appointment.getStartTimeHour(), appointment.getStartTimeMinute(), i, n));
			    break outerloop;
			case CLOSED:
			    resultClosed.add(new Appointment(workHours.getId(), workHours.getSpecialist(), appointment.getUser(), appointment.getSlotState(), 1, 1, 2016,
				    appointment.getStartTimeHour(), appointment.getStartTimeMinute(), i, n));
			    break outerloop;
			default:
			    break outerloop;

			}

		    }
		}

		if (n + workHours.getAppointmentDuration() >= 60) {
		    resultOpen.add(new Appointment(workHours.getId(), workHours.getSpecialist(), 1, 1, 2016, i, n, ++i, 0));
		    n = 0;
		    break;
		} else {

		    resultOpen.add(new Appointment(workHours.getId(), workHours.getSpecialist(), 1, 1, 2016, i, n, i, n += workHours.getAppointmentDuration()));
		}

	    }
	}
	branch.getBranchAppointments().put(SlotState.CLOSED, resultClosed);
	branch.getBranchAppointments().put(SlotState.SELECTED, resultSelected);
	branch.getBranchAppointments().put(SlotState.CONFIRM, resultConfirm);
	branch.getBranchAppointments().put(SlotState.OPEN, resultOpen);

	return branch;
    }

}
