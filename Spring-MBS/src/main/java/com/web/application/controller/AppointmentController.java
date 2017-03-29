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
import org.springframework.web.bind.annotation.RestController;

import com.web.application.model.dto.PersonalScheduleResponse;
import com.web.application.model.persistence.AppointmentDAO;
import com.web.application.model.response.MetaData;
import com.web.application.model.response.ServerResponse;

@RestController
@RequestMapping(value = "/api")
public class AppointmentController {

	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	private AppointmentDAO appointmentDAO = new AppointmentDAO();

	// TODO GET free apointments for service for month
	@RequestMapping(value = "appointments/{id}/month/{month}", method = RequestMethod.GET)
	public ResponseEntity<ServerResponse<HashMap<String, PersonalScheduleResponse>>> getFreeAppointmentsForMonth(@PathVariable String id, @PathVariable String month) throws IOException {

		ServerResponse<HashMap<String, PersonalScheduleResponse>> brachResponse = new ServerResponse<HashMap<String, PersonalScheduleResponse>>();
		MetaData accessMetaData = new MetaData();

		accessMetaData.setMessage("Free Appointments for business id: " + id);
		try {
			accessMetaData.setHttpStatus(HttpStatus.OK);
			accessMetaData.setMessage("Appointments obtained succesfully");
			// TODO consulta db
			brachResponse.setData(appointmentDAO.findAppointmentsByIdandMonth(id, month));
			// TODO poner los resultados de las Uri posbiles
			LOGGER.info("Appointments obtained succesfully");

		} catch (Exception e) {
			accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			accessMetaData.setMessage("Unable to retrive appointments");
			// TODO poner un ejemplo correcto
			LOGGER.error("Unable to retrive appointments error: " + e.getMessage());
		}
		brachResponse.setMetaData(accessMetaData);
		return new ResponseEntity<ServerResponse<HashMap<String, PersonalScheduleResponse>>>(brachResponse, HttpStatus.OK);

	}

	//TODO POST appointment serviceID/DATE/ body customerID ej "/api/appointment/1/date/1703280900"

	//TODO PUT confirm /api/appointment/1/date/1703280900/confirm 
	//TODO DELETE cancel /api/appointment/1/date/1703280900/cancel
	
	// TODO GET all apointments for service for month

}
