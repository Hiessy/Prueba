package com.web.application.model.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.application.model.CustomerManager;
import com.web.application.model.dto.Address;
import com.web.application.model.google.dto.GoogleResponse;
import com.web.application.service.google.connectors.GoogleConnector;

public class AddressValidation {

	private static Logger LOGGER = LoggerFactory.getLogger(AddressValidation.class);
	
	public static boolean validateAddress(Address address){
		
		if(address == null)
			return true;
		
		if(address.getCoordenates() != null && !address.getCoordenates().isEmpty())
			return false;
		//TODO logging sacar este loging
		GoogleResponse gr = new GoogleResponse();//GoogleConnector.getGoogleResponse(address.getNumber(), address.getStreet(), address.getCity(), address.getProvince(), address.getCountry());
		
		if(gr != null){
			address.setCoordenates("0000000000:0000000000");
			return false;
		}else{
			return true;
		}
		
		
	}
}
