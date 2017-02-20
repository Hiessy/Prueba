package com.web.provider.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import scala.annotation.meta.getter;

import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.generic.model.Address;
import com.web.generic.model.Branch;
import com.web.generic.model.Provider;
import com.web.generic.model.enums.ProviderState;
import com.web.generic.service.Validator;

@RestController
@RequestMapping(value = "/api/provider")
public class ProviderController {

	private static Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<Provider>> getTurnos(@RequestBody Provider provider) throws IOException {

		ServerResponse<Provider> providerRegistrationResponse = new ServerResponse<Provider>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setInfo("Provider registration request");

		try {

			accessMetaData.setHttpStatus(HttpStatus.OK);
			// TODO validation method

			providerRegistrationResponse.setData(registerProvider(provider));
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

	private Provider registerProvider(Provider provider) throws RuntimeException {
		
		validateEmail(provider.getProviderEmail(), provider.getProviderPassword());

		provider.setProviderId(1001);
		provider.setSubsriptionDate(new Date());
		provider.setProviderState(ProviderState.ACTIVE);

		for(Branch branch: provider.getBranches())
			branch.getAddress().setCoordenates(getCoordinates(branch.getAddress()));
		// "coordenates": null
		// "branchState": null,
		//
		// "serviceId": null,
		// "branchId": null,
		// "scheduleId": null,
		// "serviceState": null,
		//
		// "providerState": null,
		// "hmoProvider": null
		return provider;
	}

	private String getCoordinates(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validateEmail(String email, String password) {
		Validator ev = new Validator();
		if (!ev.validateEmail(email))
			throw new RuntimeException("The email address: " + email + ", is not a valid email.");
		
		if (!ev.validatePassword(password))
			throw new RuntimeException("The password: " + password + ", is not a valid password.");
	}

}
