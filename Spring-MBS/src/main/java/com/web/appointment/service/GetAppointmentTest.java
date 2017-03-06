/**
 * 
 */
/**
 * @author Tincho
 *
 */
package com.web.appointment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.web.appointment.model.AppointmentSlot;
import com.web.appointment.model.PersonalSchedule;
import com.web.appointment.model.Provider;

public class GetAppointmentTest {

	

	public HashMap<String, PersonalSchedule> getExamples() throws Exception {

		PersonalScheduleHandler providerScheduleHandler  = new PersonalScheduleHandler();
		HashMap<String, List<AppointmentSlot>> mapByProvider;
		HashMap<String, PersonalSchedule> finalresult = new HashMap<String, PersonalSchedule>();
		// obtengo la lista de provedores
		List<Provider> providers = new ArrayList<Provider>();

		Provider provider1 = new Provider(1, 1, "Juan Alejandro", "0000:0000", "0900:1800", "0900:1800", "0900:1800", "0900:1800", "0900:1800", "0000:0000");
		Provider provider2 = new Provider(2, 1, "Roman Sanvito", "0800:1800", "0000:0000", "0945:1915", "0900:1400", "0900:1800", "0900:1800", "0000:0000");
		Provider provider3 = new Provider(3, 1, "Julia Campanella", "0800:1800", "0800:1800", "0000:0000", "0800:1800", "0800:1800", "0000:0000", "0800:1800");

		providers.add(provider1);
		providers.add(provider2);
		providers.add(provider3);

		HashMap<String, List<String>> appointmentByProvider = new HashMap<String, List<String>>();

		List<String> takenSlots1 = getTakenslotsProvider1();
		List<String> takenSlots2 = getTakenslotsProvider2();
		List<String> takenSlots3 = getTakenslotsProvider3();

		Collections.sort(takenSlots1);
		Collections.sort(takenSlots2);
		Collections.sort(takenSlots3);

		appointmentByProvider.put("1", takenSlots1);
		appointmentByProvider.put("2", takenSlots2);
		appointmentByProvider.put("3", takenSlots3);

		for (Provider prov : providers) {

			PersonalSchedule providerSchedule = new PersonalSchedule(prov.getName(), providerScheduleHandler.getScheduleForProvider(prov, takenSlots1));
			finalresult.put(prov.getProviderId().toString(),providerSchedule);

		}
		return finalresult;
	}

	private static List<String> getTakenslotsProvider1() {
		List<String> takenSlots = new ArrayList<String>();
		// new Provider(1, 1, "0000:0000", "0900:1800", "0900:1800",
		// "0900:1800", "0900:1800", "0900:1800", "0000:0000");
		// 1 2 3
		// 6 7 8 9 10
		// 13 14 15 16 17
		// 20 21 22 23 24
		// 27 28 29 31

		takenSlots.add("1703011645");
		takenSlots.add("1703010900");
		takenSlots.add("1703011600");
		takenSlots.add("1703010945");

		takenSlots.add("1703021600");
		takenSlots.add("1703020930");
		takenSlots.add("1703021630");
		takenSlots.add("1703020900");

		takenSlots.add("1703031600");
		takenSlots.add("1703030900");
		takenSlots.add("1703031645");
		takenSlots.add("1703030915");

		takenSlots.add("1703141600");
		takenSlots.add("1703140930");
		takenSlots.add("1703141615");
		takenSlots.add("1703140900");

		takenSlots.add("1703231600");
		takenSlots.add("1703230900");
		takenSlots.add("1703131600");
		takenSlots.add("1703100900");

		return takenSlots;
	}

	private static List<String> getTakenslotsProvider3() {
		List<String> takenSlots = new ArrayList<String>();

		// new Provider(3, 1, "0800:1800", "0800:1800", "0000:0000",
		// "0800:1800", "0800:1800", "0000:0000", "0800:1800");
		/*
		 * Wednesday - Friday 2 4-7 9 11-14 16 18-21 23 25-28 30
		 */

		takenSlots.add("1703021600");
		takenSlots.add("1703040900");
		takenSlots.add("1703041600");
		takenSlots.add("1703060900");

		takenSlots.add("1703021615");
		takenSlots.add("1703040915");
		takenSlots.add("1703041615");
		takenSlots.add("1703060915");

		takenSlots.add("1703021630");
		takenSlots.add("1703040930");
		takenSlots.add("1703041630");
		takenSlots.add("1703060900");

		takenSlots.add("1703021645");
		takenSlots.add("1703040945");
		takenSlots.add("1703041645");
		takenSlots.add("1703060945");

		return takenSlots;
	}

	private static List<String> getTakenslotsProvider2() {
		List<String> takenSlots = new ArrayList<String>();

		// new Provider(2, 1, "0800:1800", "0000:0000", "0945:1915",
		// "0900:1400", "0900:1800", "0900:1800", "0000:0000");
		/*
		 * 1 - 3 5 7 - 10 12 14 - 17 19 21 - 24 26 28 - 31
		 */

		takenSlots.add("1703021600");
		takenSlots.add("1703030900");
		takenSlots.add("1703051600");
		takenSlots.add("1703160900");

		takenSlots.add("1703021615");
		takenSlots.add("1703030915");
		takenSlots.add("1703051615");
		takenSlots.add("1703160915");

		takenSlots.add("1703021615");
		takenSlots.add("1703030915");
		takenSlots.add("1703051615");
		takenSlots.add("1703160915");

		takenSlots.add("1703021615");
		takenSlots.add("1703030915");
		takenSlots.add("1703051615");
		takenSlots.add("1703160915");

		return takenSlots;
	}

	private static HashMap<String, List<AppointmentSlot>> getExpectedResults() {

		HashMap<String, List<AppointmentSlot>> expectedResult = new HashMap<String, List<AppointmentSlot>>();

		// expectedFreeSlots.add(new Appointment(1, "1703011415", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011430", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011445", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011500", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011515", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011545", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011600", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011615", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011630", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011700", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011715", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011730", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011745", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011800", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011815", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011830", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011845", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011900", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011930", "OPEN"));
		// expectedFreeSlots.add(new Appointment(1, "1703011945", "OPEN"));

		return expectedResult;

	}

	private static String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
}