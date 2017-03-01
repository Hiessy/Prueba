package com.web.appointment.test;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeTester {

	public static void main(String[] args) {
	       String date = LocalDate.now().toString().replace("-", "/");
	       String time = LocalTime.now().minusHours(12L).toString().substring(0,5).replace(":", "");
	       System.out.println(date);
	       System.out.println(time);

	}

}
