/**
 * 
 */
/**
 * @author Tincho
 *
 */
package com.web.appointment.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.sortSkipAndLimit;

import com.web.appointment.test.service.AppointmentHandler;
import com.web.appointment.test.model.alternative.Appointment;
import com.web.appointment.test.model.alternative.Branch;
import com.web.appointment.test.model.alternative.Slot;

public class GetAppointmentTest {

	static List<Appointment> takenSlots = new ArrayList<Appointment>();
	static List<Appointment> expectedFreeSlots = new ArrayList<Appointment>();
	static String hours = "1400:2000";
	static int duration = 3;

	static Slot workHours = new Slot(1, "Service Name", "1400:2000", 3);

	public static void main(String[] args) {

	       String date = new StringBuilder(LocalDate.now().toString().replace("-", "/")).reverse().toString();
	       System.out.println(date);

		
		takenSlots.add(new Appointment(1, 1, "2017/03/01", "1645:1700", "CONFIRMED"));
		takenSlots.add(new Appointment(1, 1, "2017/03/01", "1915:1930", "CONFIRMED"));
		takenSlots.add(new Appointment(1, 1, "2017/03/01", "1400:1415", "CONFIRMED"));
		takenSlots.add(new Appointment(1, 1, "2017/03/01", "1530:1545", "CONFIRMED"));

		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1415:1430", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1430:1445", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1445:1500", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1500:1515", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1515:1530", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1545:1600", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1600:1615", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1615:1630", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1630:1645", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1700:1715", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1715:1730", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1730:1745", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1745:1800", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1800:1815", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1815:1830", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1830:1845", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1845:1900", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1900:1915", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1930:1945", "OPEN"));
		expectedFreeSlots.add(new Appointment(1, "2017/03/01", "1945:2000", "OPEN"));

		int start = Integer.valueOf(hours.substring(0, 4));
		int end = Integer.valueOf(hours.substring(5, 9));
		int providerId = 1;

		AppointmentHandler appointmentHandler = new AppointmentHandler(providerId, date, start, end, duration * 5);
		
		takenSlots.sort(Comparator.comparing(Appointment::getAppointmentHour));
		takenSlots.sort((o1, o2) -> o1.getAppointmentHour().compareTo(o2.getAppointmentHour()));
		
		for (Appointment tk : takenSlots) {
			System.out.println(tk);
		}
		
		List<Appointment> freeSlots = appointmentHandler.getFreeAppointments(takenSlots);
		
		
		for (Appointment tk : freeSlots) {
			System.out.println(tk);
		}
		System.out.println(freeSlots.equals(expectedFreeSlots));

	}

}