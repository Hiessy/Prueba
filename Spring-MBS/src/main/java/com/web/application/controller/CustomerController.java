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
import com.web.application.model.dto.Customer;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;


@Controller
@EnableAutoConfiguration
public class CustomerController {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	//TODO CREATES A CUSOMTER
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<Customer>> registerUser(@RequestBody Customer user) {

		ServerResponse<Customer> userResponse = new ServerResponse<Customer>();
		MetaData userMetaData = new MetaData();

		userMetaData.setInfo("User registration request");

		try {
			userMetaData.setMessage("User registration succesfull");
			userMetaData.setHttpStatus(HttpStatus.OK);
			userResponse.setData(user);
			LOGGER.info("User was registered succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to register User: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("User not registered error" + e.getMessage());
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<Customer>>(userResponse, HttpStatus.OK);
	}

	//TODO MODIFY A CUSOMTER
	//TODO DELETE A CUSOMTER
	//TODO OBTAIN A CUSOMTER

}
