/**
 * 
 */
/**
 * @author Tincho
 *
 */
package com.web.appointment.test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.web.application.model.dto.AppointmentSlot;
import com.web.application.model.dto.PersonalScheduleResponse;

import com.web.application.service.AppointmentHandler;

public class GetAppointmentTest {

	static String[] workingDaysMethod = { "getSunday", "getMonday", "getTuesday", "getWednesday", "getThursday",
			"getFriday", "getSaturday" };

	public HashMap<String, PersonalScheduleResponse> getExamples() throws Exception {

		AppointmentHandler apoHa = new AppointmentHandler();

		HashMap<String, List<AppointmentSlot>> mapByProvider;
		HashMap<String, PersonalScheduleResponse> finalresult = new HashMap<String, PersonalScheduleResponse>();
		// obtengo la lista de provedores
//		List<Provider> providers = new ArrayList<Provider>();
//
//		Provider provider1 = new Provider(1, 1, "name1", "0000:0000", "0900:1800", "0900:1800", "0900:1800", "0900:1800",
//				"0900:1800", "0000:0000");
//		Provider provider2 = new Provider(2, 1, "name2", "0800:1800", "0000:0000", "0945:1915", "0900:1400", "0900:1800",
//				"0900:1800", "0000:0000");
//		Provider provider3 = new Provider(3, 1, "name3", "0800:1800", "0800:1800", "0000:0000", "0800:1800", "0800:1800",
//				"0000:0000", "0800:1800");

//		providers.add(provider1);
//		providers.add(provider2);
//		providers.add(provider3);

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

//		for (Provider prov : providers) {
//
//			mapByProvider = new HashMap<String, List<AppointmentSlot>>();
//			int initial = LocalDate.now().getDayOfMonth();
//			int last = LocalDate.now().lengthOfMonth();
//			int offset = initial;
//			HashMap<String, Method> methods = new HashMap<String, Method>();
//
//			for (int i = 0; i < workingDaysMethod.length; i++) {
//
//				Method method = prov.getClass().getMethod(workingDaysMethod[i]);
//				if (!"0000:0000".equals(method.invoke(prov)))
//					methods.put(method.getName().substring(3, method.getName().length()).toUpperCase(), method);
//			}
//
//			if (methods.isEmpty())
//				break;
//
//			for (; initial <= last; initial++) {
//
//				LocalDate day = LocalDate.now().minusDays(2).plusDays(initial - offset);
//				String key = day.toString().replace("-", "").substring(2, 8);
//				String dayName = day.getDayOfWeek().toString();
//				String schedule = null;
//
//				if (methods.get(dayName) != null) {
//					schedule = (String) methods.get(dayName).invoke(prov);
//					// Setting handler
//					apoHa.setProviderId(prov.getProviderId());
//					apoHa.setDate(key);
//					apoHa.setDuration(3 * 5); // viene del servicio aca ya lo//
//												// multipleque por 5
//					// catch exception
//					apoHa.setStart(Integer.valueOf(schedule.substring(0, 4)));
//					apoHa.setEnd(Integer.valueOf(schedule.substring(5, 9)));
//
//					List<String> daysToSubtract = new ArrayList<String>();
//					int i = 0;
//
//					while (!takenSlots1.isEmpty() && key.equals(takenSlots1.get(i).substring(0, 6))) {
//						daysToSubtract.add(takenSlots1.get(i));
//						takenSlots1.remove(i);
//					}
//
//					mapByProvider.put(key, apoHa.getFreeAppointments(daysToSubtract));
//					daysToSubtract.clear();
//				}

//
//			}
//			finalresult.put(prov.getProviderId().toString(), new PersonalScheduleResponse(prov.getName(),mapByProvider));
//
//		}
		return finalresult;
	}

	private static List<AppointmentSlot> expectedFreeSlots() {

		// 0900:1800
		List<AppointmentSlot> result = new ArrayList<AppointmentSlot>();

		return result;
	}
	private static List<AppointmentSlot> expectedFreeSlots2(Integer id) {

		// 0900:1800
		List<AppointmentSlot> result = new ArrayList<AppointmentSlot>();	

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
}