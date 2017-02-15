package com.web.appointment.test.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Months {

	private boolean[][] slots;

	public Months(int month) {
		int lenghtsOfDays = LocalDate.of(LocalDate.now().getYear(), Month.of(month), 01).lengthOfMonth();
		slots = new boolean[lenghtsOfDays][288];

		for (int i = 0; i < lenghtsOfDays; i++) {
			for (int n = 0; n < 288; n++)
				slots[i][n] = Boolean.TRUE;
		}
	}

	public boolean[][] getSlots() {
		return slots;
	}

	public void setSlots(boolean[][] slots) {
		this.slots = slots;
	}


}
