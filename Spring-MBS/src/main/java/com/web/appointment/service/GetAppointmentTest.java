/**
 * 
 */
/**
 * @author Tincho
 *
 */
package com.web.appointment.service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import com.web.appointment.model.Appointment;
import com.web.appointment.model.Provider;
import com.web.appointment.service.AppointmentHandler;

public class GetAppointmentTest {

	static String[] workingDaysMethod = { "getSunday", "getMonday", "getTuesday", "getWednesday", "getThursday",
			"getFriday", "getSaturday" };

	public List<HashMap<String, List<Appointment>>> getExamples() throws Exception {

		AppointmentHandler apoHa = new AppointmentHandler();

		HashMap<String, List<Appointment>> mapByProvider;
		List<HashMap<String, List<Appointment>>> finalresult = new ArrayList<HashMap<String, List<Appointment>>>();
		// obtengo la lista de provedores
		List<Provider> providers = new ArrayList<Provider>();

		Provider provider1 = new Provider(1, 1, "0000:0000", "0900:1800", "0900:1800", "0900:1800", "0900:1800",
				"0900:1800", "0000:0000");
		Provider provider2 = new Provider(2, 1, "0800:1800", "0000:0000", "0945:1915", "0900:1400", "0900:1800",
				"0900:1800", "0000:0000");
		Provider provider3 = new Provider(3, 1, "0800:1800", "0800:1800", "0000:0000", "0800:1800", "0800:1800",
				"0000:0000", "0800:1800");

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

			mapByProvider = new HashMap<String, List<Appointment>>();
			int initial = LocalDate.now().getDayOfMonth();
			int last = LocalDate.now().lengthOfMonth();
			int offset = initial;
			HashMap<String, Method> methods = new HashMap<String, Method>();

			for (int i = 0; i < workingDaysMethod.length; i++) {

				Method method = prov.getClass().getMethod(workingDaysMethod[i]);
				if (!"0000:0000".equals(method.invoke(prov)))
					methods.put(method.getName().substring(3, method.getName().length()).toUpperCase(), method);
			}

			if (methods.isEmpty())
				break;

			for (; initial <= last; initial++) {

				LocalDate day = LocalDate.now().minusDays(2).plusDays(initial - offset);
				String key = day.toString().replace("-", "").substring(2, 8);
				String dayName = day.getDayOfWeek().toString();
				String schedule = null;

				if (methods.get(dayName) != null) {
					schedule = (String) methods.get(dayName).invoke(prov);
					// Setting handler
					apoHa.setProviderId(prov.getProviderId());
					apoHa.setDate(key);
					apoHa.setDuration(3 * 5); // viene del servicio aca ya lo//
												// multipleque por 5
					// catch exception
					apoHa.setStart(Integer.valueOf(schedule.substring(0, 4)));
					apoHa.setEnd(Integer.valueOf(schedule.substring(5, 9)));

					List<String> daysToSubtract = new ArrayList<String>();
					int i = 0;

					while (!takenSlots1.isEmpty() && key.equals(takenSlots1.get(i).substring(0, 6))) {
						daysToSubtract.add(takenSlots1.get(i));
						takenSlots1.remove(i);
					}

					mapByProvider.put(key, apoHa.getFreeAppointments(daysToSubtract));
					daysToSubtract.clear();
				}

				if (prov.getProviderId() == 1 && key.equals("170301")){
					System.out.println(mapByProvider.get("170301").equals(expectedFreeSlots(1)));
					System.out.println(mapByProvider.get("170301"));
					System.out.println(expectedFreeSlots(1));
				}
				if (prov.getProviderId() == 1 && key.equals("170317")){
					System.out.println(mapByProvider.get("170317").equals(expectedFreeSlots2(1)));
					System.out.println(mapByProvider.get("170317"));
					System.out.println(expectedFreeSlots2(1));
				}	
			}
			finalresult.add(mapByProvider);

		}
		return finalresult;
	}

	private static List<Appointment> expectedFreeSlots(Integer id) {

		// 0900:1800
		List<Appointment> result = new ArrayList<Appointment>();
		result.add(new Appointment(null, id, null, 1703010915 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703010930 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011000 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011015 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011030 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011045 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011100 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011115 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011130 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011145 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011200 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011215 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011230 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011245 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011300 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011315 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011330 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011345 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011400 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011415 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011430 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011445 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011500 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011515 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011530 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011545 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011615 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011630 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011700 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011715 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011730 + "", "OPEN"));
		result.add(new Appointment(null, id, null, 1703011745 + "", "OPEN"));
		return result;
	}
	private static List<Appointment> expectedFreeSlots2(Integer id) {

		// 0900:1800
		List<Appointment> result = new ArrayList<Appointment>();	
		result.add(new Appointment(null, id, null, "1703170900", "OPEN"));
		result.add(new Appointment(null, id, null, "1703170915", "OPEN"));
		result.add(new Appointment(null, id, null, "1703170930", "OPEN"));
		result.add(new Appointment(null, id, null, "1703170945", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171000", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171015", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171030", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171045", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171100", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171115", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171130", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171145", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171200", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171215", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171230", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171245", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171300", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171315", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171330", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171345", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171400", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171415", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171430", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171445", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171500", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171515", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171530", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171545", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171600", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171615", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171630", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171645", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171700", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171715", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171730", "OPEN"));
		result.add(new Appointment(null, id, null, "1703171745", "OPEN"));
	return result;
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

	private static HashMap<String, List<Appointment>> getExpectedResults() {

		HashMap<String, List<Appointment>> expectedResult = new HashMap<String, List<Appointment>>();

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