package com.web.appointment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;
import com.web.appointment.service.GetAppointmentTest;
import com.web.appointment.model.Appointment;


@RestController
@RequestMapping(value = "/api")
public class AppointmentController {

	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	
	@RequestMapping(value = "/free/appointments", params = {"id", "month"}, method = RequestMethod.GET)
	public ResponseEntity<ServerResponse<List<HashMap<String, List<Appointment>>>>> getOpenSlots(@RequestParam("id") String id, @RequestParam("month") String month) throws IOException {
		
		ServerResponse<List<HashMap<String, List<Appointment>>>> brachResponse = new ServerResponse<List<HashMap<String, List<Appointment>>>>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setInfo("Free Appointments for business id: " + id);
		try {
			accessMetaData.setHttpStatus(HttpStatus.OK);
			accessMetaData.setMessage("Appointments obtained succesfully");
			// TODO consulta db
			GetAppointmentTest apo = new GetAppointmentTest();
			List<HashMap<String, List<Appointment>>> data = apo.getExamples();
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
		return new ResponseEntity<ServerResponse<List<HashMap<String, List<Appointment>>>>>(brachResponse, HttpStatus.OK);

	}



}
