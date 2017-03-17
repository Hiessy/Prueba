package com.web.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.application.model.CustomerManager;
import com.web.application.model.dto.Customer;
import com.web.application.model.persistence.CustomerDAO;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;

@Controller
@EnableAutoConfiguration
public class CustomerController {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private CustomerManager customerManager = new CustomerManager();
	private CustomerDAO customerDAO = new CustomerDAO();

	// TODO CREATES A CUSOMTER
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<Customer[]>> registerUser(@RequestBody Customer[] customers) {

		ServerResponse<Customer[]> userResponse = new ServerResponse<Customer[]>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers registration succesfull");
			userMetaData.setHttpStatus(HttpStatus.OK);
			customerManager.validateCustomer(customers);
			userResponse.setData(customerDAO.addCustomers(customers));
			LOGGER.info("Customers were registered succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Customers registration error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Customer registration error: " + e.getMessage());
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer[]>>(userResponse, HttpStatus.OK);
	}

	//TODO POST /customers -- body Json
	//TODO GET /customers/{id}
	//TODO PUT /customers/{id} -- body Json
	//TODO DELETE /customers/{id}

}
