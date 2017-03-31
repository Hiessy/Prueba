package com.web.application.model.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.application.model.dto.Customer;


public class CustomerDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerDAO.class);


	public CustomerDAO() {
	}

	// TODO manejar la logica para multiples insert si uno falla y otro funca
	// TODO get last inserted ID and set to address --> contact --> customer
	public Customer addCustomers(Customer customer) {
		return customer;

	}

	public Customer getCustomers(String id) {

		// TODO Auto-generated method stub
		return null;
	}


}
