package com.web.application.controller;

import java.io.IOException;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.model.dto.PersonalSchedule;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.appointment.test.GetAppointmentTest;


@RestController
@RequestMapping(value = "/api")
public class AppointmentController {

	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	
	@RequestMapping(value = "/{id}/appointments", params = {"month"}, method = RequestMethod.GET)
	public ResponseEntity<ServerResponse<HashMap<String, PersonalSchedule>>> getOpenSlots(@PathVariable String id, @RequestParam("month") String month) throws IOException {
		
		ServerResponse<HashMap<String, PersonalSchedule>> brachResponse = new ServerResponse<HashMap<String, PersonalSchedule>>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setMessage("Free Appointments for business id: " + id);
		try {
			accessMetaData.setHttpStatus(HttpStatus.OK);
			accessMetaData.setMessage("Appointments obtained succesfully");
			// TODO consulta db
			GetAppointmentTest apo = new GetAppointmentTest();
			HashMap<String, PersonalSchedule> data = apo.getExamples();
			brachResponse.setData(data);
			// TODO poner los resultados de las Uri posbiles
			LOGGER.info("Appointments obtained succesfully");

		} catch (Exception e) {
			accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			accessMetaData.setMessage("Unable to retrive appointments");
			// TODO poner un ejemplo correcto
			LOGGER.error("Unable to retrive appointments error: " + e.getMessage());
		}
		brachResponse.setMetaData(accessMetaData);
		return new ResponseEntity<ServerResponse<HashMap<String, PersonalSchedule>>>(brachResponse, HttpStatus.OK);

	}



}
