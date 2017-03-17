package com.web.application.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.application.exceptions.CustomerException;
import com.web.application.model.dto.Customer;
import com.web.application.model.validation.CustomerValidation;

public class CustomerManager {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerManager.class);
	
	public Customer[] validateCustomer(Customer[] customers) throws CustomerException{
		
		LOGGER.info("Begin validating customers to check their all good before persistance.");
		for(Customer customer : customers )
				CustomerValidation.validateCustomer(customer);

		return customers;
	}
}
