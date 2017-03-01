package com.web.appointment.test;

public class AppointmentTimeBuilder {
	public static void main(String[] args) {

		Integer start = 1400;
		Integer end = 2000;
		Integer duration = 15;

		Integer startSession;
		Integer endSession;

		for (Integer hour = start; hour < end;) {
			// 1460 - 60 / 100
			startSession = hour;
			if ((hour + duration - 60) % 100 == 0) {
				endSession = (hour + duration - 60) + 100;
			} else {

				endSession = hour + duration;
			}

			System.out.println(startSession + ":" + endSession);
			hour = endSession;
		}

	}
}
