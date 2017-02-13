package com.web.provider.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.appointment.model.Appointment;
import com.web.appointment.model.Branch;
import com.web.appointment.model.Slot;
import com.web.appointment.model.SlotState;
import com.web.appointment.service.AppointmenHandler;
import com.web.generic.model.Provider;

@RestController
@RequestMapping(value = "/api/provider")
public class ProviderController {

	private static Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<HashMap<String, Branch>>> getTurnos(@RequestBody Provider provider) throws IOException {

		ServerResponse<HashMap<String, Branch>> brachResponse = new ServerResponse<HashMap<String, Branch>>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setInfo("Provider registration request");
		try {

			accessMetaData.setHttpStatus(HttpStatus.OK);
			brachResponse.setMetaData(accessMetaData);
			// TODO validation method

		//	brachResponse.setData(ProviderController);
			accessMetaData.setMessage("Appointments obtained succesfully");
			LOGGER.info("Appointments obtained succesfully");

		} catch (Exception e) {
			accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			accessMetaData.setMessage("Unable to retrive appointments");
			LOGGER.error("Unable to retrive appointments" + e.getMessage());
		}
		brachResponse.setMetaData(accessMetaData);
		return new ResponseEntity<ServerResponse<HashMap<String, Branch>>>(brachResponse, HttpStatus.OK);

	}

	
}
