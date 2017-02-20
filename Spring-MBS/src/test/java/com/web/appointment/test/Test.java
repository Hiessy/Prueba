package com.web.appointment.test;

import java.util.Date;

import com.web.generic.service.GoogleConnector;

public class Test {

	/*
	 * 
	 * "street":, "number":6800, "floor": 5, "dpto":"7 B", "postalCode":"1476",
	 * "district":"Flores", "city":"Capital Federal", "province":"CABA",
	 * "country":"AR", "coordinates":"14,5677:54,3231"
	 */
	public static void main(String[] args) {
		System.out.println(new Date());

		String streetName = "Av. Rivadavia";
		String addressNumber = "6800";
		String cityName = "Ciudad Autonoma de Buenos Aires";
		String province = "Buenos Aires";
		String countryName = "AR";

		System.out.println(GoogleConnector.getGoogleResponse(addressNumber, streetName, cityName, province, countryName));
	}

}
