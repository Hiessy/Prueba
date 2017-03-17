package com.web.application.controller;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.model.dto.Address;
import com.web.application.model.dto.Branch;
import com.web.application.model.dto.Provider;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.application.service.Validator;

@RestController
@RequestMapping(value = "/api/provider")
public class ProviderController {

	private static Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<Provider>> getTurnos(@RequestBody Provider provider) throws IOException {

		ServerResponse<Provider> providerRegistrationResponse = new ServerResponse<Provider>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setMessage("Provider registration request");

		try {

			accessMetaData.setHttpStatus(HttpStatus.OK);
			// TODO validation method

		//	providerRegistrationResponse.setData(registerProvider(provider));
			accessMetaData.setMessage("Provider registered succesfully");
			LOGGER.info("Appointments obtained succesfully");

		} catch (RuntimeException e) {
			accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);

			accessMetaData.setMessage("Unable to registered Provider");
			LOGGER.error("Unable to retrive appointments" + e.getMessage());
		}
		providerRegistrationResponse.setMetaData(accessMetaData);
		return new ResponseEntity<ServerResponse<Provider>>(providerRegistrationResponse, HttpStatus.OK);

	}

	private void validateEmail(String email, String password) {
		Validator ev = new Validator();
		if (!ev.validateEmail(email))
			throw new RuntimeException("The email address: " + email + ", is not a valid email.");
		
		if (!ev.validatePassword(password))
			throw new RuntimeException("The password: " + password + ", is not a valid password.");
	}

}
