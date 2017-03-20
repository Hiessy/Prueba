package com.web.application.model.validation;

import com.web.application.exceptions.CustomerException;
import com.web.application.model.dto.Customer;
import com.web.application.service.Validator;

public class CustomerValidation {
	

	public static void validateCustomer(Customer customer) throws CustomerException{
		
		if(customer == null)
			throw new CustomerException("Customer may not be null"); 
		
		if(customer.getCustomerEmail() == null ||customer.getCustomerEmail().isEmpty())
			throw new CustomerException("Customer is missing email address"); 
		else if(!Validator.validateEmail(customer.getCustomerEmail()))
			throw new CustomerException("Customer is email address is invalid"); 
		
		if(customer.getCustomerName() == null ||customer.getCustomerName().isEmpty())
			throw new CustomerException("Customer is missing name"); 
		
		if(customer.getCustomerState() == null ||customer.getCustomerState().isEmpty())
			throw new CustomerException("Customer state is missing, must be ACTIVE"); 
		if(!customer.getCustomerState().equals("ACTIVE") && !customer.getCustomerState().equals("INACTIVE"))
			throw new CustomerException("Customer state is invalid, must be ACTIVE or INACTIVE"); 
		
		if(customer.getCustomerPassword() == null ||customer.getCustomerPassword().isEmpty())
			throw new CustomerException("Customer is missing password"); 
		else if(!Validator.validatePassword(customer.getCustomerPassword()))
			throw new CustomerException("Customer is password is invalid"); 
		
		if(customer.getContact() == null)
			throw new CustomerException("Customer is missing contact ifnormation"); 
		else if(ContactValidation.validateContact(customer.getContact()))
			throw new CustomerException("Customer contact information is missing address or id information"); 
	}
}
