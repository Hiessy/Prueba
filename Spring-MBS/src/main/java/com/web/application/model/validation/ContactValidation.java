package com.web.application.model.validation;

import com.web.application.model.dto.Contact;

public class ContactValidation {

	public static boolean validateContact(Contact contact){
		
		if(contact.getAddress() == null)
			return true;
		else if(AddressValidation.validateAddress(contact.getAddress()))
			return true;
		
		if("".equals(contact.getTelephone()))
			return true;

		if("".equals(contact.getBusinessIdNumber()) && "".equals(contact.getPersonalIdNumber()))
			return true;
		
		return false;
				
	}
}
