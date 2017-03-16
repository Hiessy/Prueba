package com.web.appointment.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.application.model.google.dto.AddressComponent;
import com.web.application.model.google.dto.Result;
import com.web.application.service.google.connectors.GoogleConnector;

public class TestGoogleConnector {

	/*
	 * 
	 * "street":, "number":6800, "floor": 5, "dpto":"7 B", "postalCode":"1476",
	 * "district":"Flores", "city":"Capital Federal", "province":"CABA",
	 * "country":"AR", "coordinates":"14,5677:54,3231"
	 */
	public static void main(String[] args) {
		System.out.println(new Date());

		List<String[]> addresses = new ArrayList<String[]>();
		String[] addr1 = { "68", "Rosario", "Ciudad Autonoma de Buenos Aires", "Buenos Aires", "AR" };
//		String[] addr2 = { "3506", "Av. Corrientes", "Ciudad Autonoma de Buenos Aires", "Buenos Aires", "AR" };
//		String[] addr3 = { "3924", "Estomba", "Ciudad Autonoma de Buenos Aires", "Buenos Aires", "AR" };
//		String[] addr4 = { "1514", "Lavalle", "Ciudad Autonoma de Buenos Aires", "Buenos Aires", "AR" };
//		String[] addr5 = { "3845", "Córdoba", "Rosario", "Santa Fe", "AR" };
//		String[] addr6 = { "135", "Av. 19", "La Plata", "Buenos Aires", "AR" };				
		
		addresses.add(addr1);
//		addresses.add(addr2);
//		addresses.add(addr3);
//		addresses.add(addr4);
//		addresses.add(addr5);
//		addresses.add(addr6);
		
		for (String[] address : addresses) {
			Result result = GoogleConnector.getGoogleResponse(Integer.valueOf(address[0]), address[1], address[2], address[3], address[4]).getResults().get(0);
			for (AddressComponent ap : result.getAddress_components())
				if (ap.getTypes().get(0).equals("postal_code"))
					System.out.println("CP " + ap.getLong_name());
			System.out.println(result.getGeometry().getLocation().toString());
		}
	}
}
