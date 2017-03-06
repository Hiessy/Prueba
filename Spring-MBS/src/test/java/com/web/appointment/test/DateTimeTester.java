package com.web.appointment.test;

import java.time.LocalDate;

public class DateTimeTester {

	public static void main(String[] args) {

		String date2 = new StringBuilder(LocalDate.now().toString().replace("-", "").substring(2, 6)).toString();

		System.out.println(date2);


		int initial = LocalDate.now().getDayOfMonth();
		int last = LocalDate.now().lengthOfMonth();
		int offset = initial;
		for (; initial <= last; initial++) {
			LocalDate day = LocalDate.now().plusDays(initial - offset);
			System.out.println(day.toString().replace("-", "").substring(2, 8) + "--" + day.getDayOfWeek());
		}

		for(int i = 9; i < 18; i++){
			System.out.println("result.add(new Appointment(null, id, null, \"170302"+i+"00\", \"OPEN\"));");
			System.out.println("result.add(new Appointment(null, id, null, \"170302"+i+"15\", \"OPEN\"));");
			System.out.println("result.add(new Appointment(null, id, null, \"170302"+i+"30\", \"OPEN\"));");
			System.out.println("result.add(new Appointment(null, id, null, \"170302"+i+"45\", \"OPEN\"));");

		}
		
	}

}
