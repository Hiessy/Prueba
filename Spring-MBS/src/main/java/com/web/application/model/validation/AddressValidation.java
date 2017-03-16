package com.web.application.model.validation;

import com.web.application.model.dto.Address;
import com.web.application.model.google.dto.GoogleResponse;
import com.web.application.service.google.connectors.GoogleConnector;

public class AddressValidation {

	public static boolean validateAddress(Address address){
		
		if(address == null)
			return true;
		
		GoogleResponse gr = GoogleConnector.getGoogleResponse(address.getNumber(), address.getStreet(), address.getCity(), address.getProvince(), address.getCountry());
		
		if(gr != null){
			address.setCoordenates(String.valueOf(gr.getResults().get(0).getGeometry().getLocation().getLat())+":"+String.valueOf(gr.getResults().get(0).getGeometry().getLocation().getLng()) );
			return false;
		}else{
			return true;
		}
		
		
	}
}
