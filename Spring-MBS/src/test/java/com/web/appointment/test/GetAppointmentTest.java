/**
 * 
 */
/**
 * @author Tincho
 *
 */
package com.web.appointment.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.web.appointment.service.AppointmenHandler;
import com.web.appointment.model.Appointment;
import com.web.appointment.model.Branch;
import com.web.appointment.model.Slot;
import com.web.appointment.model.SlotState;

public class GetAppointmentTest {

    List<Appointment> takenSlots = new ArrayList<Appointment>();
    List<Appointment> expectedFreeSlots = new ArrayList<Appointment>();
    Slot workHours = new Slot(1, "Dr Dentista", 14, 00, 20, 0, 15);

    @Before
    public void setUp() throws Exception {

	takenSlots.add(new Appointment(1, "Dr Dentista", "Martin", SlotState.CONFIRM, 1, 1, 2016, 14, 30, 15, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Andres", 1, 1, 2016, 17, 45, 18, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Jaun", 1, 1, 2016, 15, 0, 15, 45));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Valeria", 1, 1, 2016, 16, 30, 17, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Marcela", 1, 1, 2016, 18, 30, 19, 30));

	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 14, 00, 14, 15));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 14, 15, 14, 30));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 15, 45, 16, 00));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 16, 00, 16, 15));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 16, 15, 16, 30));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 17, 00, 17, 15));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 17, 15, 17, 30));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 17, 30, 17, 45));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 18, 00, 18, 15));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 18, 15, 18, 30));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 19, 30, 19, 45));
	expectedFreeSlots.add(new Appointment(1, "Dr Dentista", 1, 1, 2016, 19, 45, 20, 00));

    }

    @Test
    public void testGetFreeSlotsSuccess() {

	AppointmenHandler appointmentHandler = new AppointmenHandler(workHours);
	Branch freeSlots = appointmentHandler.getFreeAppointments(takenSlots);

	Assert.assertEquals(expectedFreeSlots, freeSlots.getBranchAppointments().get(SlotState.OPEN));
	Assert.assertEquals(takenSlots.size(), 0);

    }

}