package com.web.application.model.validation;

import com.web.application.model.dto.Contact;

public class ContactValidation {

	public static boolean validateContact(Contact contact){
		
		if(contact.getAddress() == null)
			return true;
		else if(AddressValidation.validateAddress(contact.getAddress()))
			return true;
		
		if(contact.getTelephone() == null)
			return true;
		
		if(contact.getBusinessIdNumber().isEmpty() || contact.getPersonalIdNumber().isEmpty())
			return true;
		
		return false;
				
	}
}
