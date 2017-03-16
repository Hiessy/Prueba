package com.web.application.service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.web.application.model.dto.AppointmentSlot;
import com.web.application.model.dto.Provider;

public class PersonalScheduleHandler {

	private static String[] workingDaysMethod = { "getSunday", "getMonday", "getTuesday", "getWednesday", "getThursday", "getFriday", "getSaturday" };
	private AppointmentHandler apoHa = new AppointmentHandler();

	public HashMap<String, List<AppointmentSlot>> getScheduleForProvider(Provider provider, List<String> takenSlots) {

		HashMap<String, List<AppointmentSlot>> mapByProvider = new HashMap<String, List<AppointmentSlot>>();
		int initial = LocalDate.now().getDayOfMonth();
		int last = LocalDate.now().lengthOfMonth();
		int offset = initial;
		
		HashMap<String, Method> methods = new HashMap<String, Method>();
		try {

			for (int i = 0; i < workingDaysMethod.length; i++) {

				Method method = provider.getClass().getMethod(workingDaysMethod[i]);
				if (!"0000:0000".equals(method.invoke(provider)))
					methods.put(method.getName().substring(3, method.getName().length()).toUpperCase(), method);
			}

			if (methods.isEmpty())
				return null;

			for (; initial <= last; initial++) {

				LocalDate day = LocalDate.now().minusDays(2).plusDays(initial - offset);
				String key = day.toString().replace("-", "").substring(2, 8);
				String dayName = day.getDayOfWeek().toString();
				String schedule = null;

				if (methods.get(dayName) != null) {
					schedule = (String) methods.get(dayName).invoke(provider);
					// Setting handler
					apoHa.setProviderId(provider.getProviderId());
					apoHa.setDate(key);
					apoHa.setDuration(3 * 5);
					apoHa.setStart(Integer.valueOf(schedule.substring(0, 4)));
					apoHa.setEnd(Integer.valueOf(schedule.substring(5, 9)));

					List<String> daysToSubtract = new ArrayList<String>();
					int i = 0;

					while (!takenSlots.isEmpty() && key.equals(takenSlots.get(i).substring(0, 6))) {
						daysToSubtract.add(takenSlots.get(i));
						takenSlots.remove(i);
					}

					mapByProvider.put(key, apoHa.getFreeAppointments(daysToSubtract));
					daysToSubtract.clear();
				}
			}
		} catch (Exception e) {
			// TODO handle exception

		}
		return mapByProvider;

	}
}
