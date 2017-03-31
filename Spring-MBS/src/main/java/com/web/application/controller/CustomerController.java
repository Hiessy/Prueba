package com.web.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.application.model.dto.Customer;
import com.web.application.model.persistence.CustomerDAO;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.application.model.validation.CustomerValidation;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class CustomerController {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	private CustomerDAO customerDAO = new CustomerDAO();


	// TODO POST A CUSTOMER /customers 
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<Customer>> registerCustomer(@RequestBody Customer customer) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers registration succesfull");
			userMetaData.setHttpStatus(HttpStatus.OK);
			CustomerValidation.validateCustomer(customer);
			userResponse.setData(customerDAO.addCustomers(customer));

			LOGGER.info("Customers were registered succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Customers registration error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Customer registration error: " + e.getMessage());
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}

	// TODO GET /customers/{id}
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public ResponseEntity<ServerResponse<Customer>> getCustomerById(@PathVariable String id) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers was located succesfully");
			userMetaData.setHttpStatus(HttpStatus.OK);
			//userResponse.setData(customerDAO.getCustomers(id));
			LOGGER.info("Customers was located succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to find customer with id: " + id + " ,error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Unable to find customer with id: " + id + " ,error: " + e);
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}

	// TODO PUT /customers/{id} -- body Json
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ServerResponse<Customer>> modifyCustomerById(@PathVariable String id) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers was located succesfully");
			userMetaData.setHttpStatus(HttpStatus.OK);
			userResponse.setData(customerDAO.getCustomers(id));
			LOGGER.info("Customers was located succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to find customer with id: " + id + " ,error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Unable to find customer with id: " + id + " ,error: " + e);
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}
	
	// TODO PUT /customers/{id} -- body Json
	@RequestMapping(value = "/customers/{email}", method = RequestMethod.PUT)
	public ResponseEntity<ServerResponse<Customer>> modifyCustomerByEmail(@PathVariable String email) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers was located succesfully");
			userMetaData.setHttpStatus(HttpStatus.OK);
			userResponse.setData(customerDAO.getCustomers(email));
			LOGGER.info("Customers was located succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to find customer with email: " + email + " ,error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Unable to find customer with email: " + email + " ,error: " + e);
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}
	// TODO DELETE /customers/{id}
	@RequestMapping(value = "/customers/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<ServerResponse<Customer>> removeCustomerByEmail(@PathVariable String email) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers was located succesfully");
			userMetaData.setHttpStatus(HttpStatus.OK);
			userResponse.setData(customerDAO.getCustomers(email));
			LOGGER.info("Customers was located succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to find customer with email: " + email + " ,error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Unable to find customer with email: " + email + " ,error: " + e);
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}
	
	// TODO DELETE /customers/{id} -- body Json
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ServerResponse<Customer>> removeCustomerById(@PathVariable String id) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		try {
			userMetaData.setMessage("Customers was located succesfully");
			userMetaData.setHttpStatus(HttpStatus.OK);
			userResponse.setData(customerDAO.getCustomers(id));
			LOGGER.info("Customers was located succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to find customer with id: " + id + " ,error: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("Unable to find customer with id: " + id + " ,error: " + e);
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}

}
