package com.web.appointment.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.web.appointment.model.Appointment;
import com.web.appointment.model.Branch;
import com.web.appointment.model.Slot;
import com.web.appointment.model.SlotState;
import com.web.appointment.service.AppointmenHandler;

@RestController
@RequestMapping(value = "/api")
public class AppointmentController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
    AppointmenHandler appointmenHandler = new AppointmenHandler(new Slot(1, "Dr Dentista", 14, 00, 20, 0, 15));// TODO
													       // esto
													       // deberia
													       // realizar
													       // una
													       // consulta
													       // bajar
													       // de
													       // aca

    @RequestMapping(value = "/total/appointments", params = "id", method = RequestMethod.GET)
    public ResponseEntity<ServerResponse<HashMap<String, Branch>>> getTurnos(@RequestParam("id") String id) throws IOException {

	ServerResponse<HashMap<String, Branch>> brachResponse = new ServerResponse<HashMap<String, Branch>>();
	MetaData accessMetaData = new MetaData();
	
	accessMetaData.setInfo("Total Appointments for business id: " + id);
	try {

	    accessMetaData.setHttpStatus(HttpStatus.OK);
	    brachResponse.setMetaData(accessMetaData);
	    // TODO validation method

	    brachResponse.setData(generateAllSlots(id));
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

    @RequestMapping(value = "/free/appointments", params = "id", method = RequestMethod.GET)
    public ResponseEntity<ServerResponse<HashMap<String, List<Appointment>>>> getTurnosAbiertos(@RequestParam("id") String id) throws IOException {

	ServerResponse<HashMap<String, List<Appointment>>> brachResponse = new ServerResponse<HashMap<String, List<Appointment>>>();
	MetaData accessMetaData = new MetaData();
	
	accessMetaData.setInfo("Free Appointments for business id: " + id);
	try {
	    accessMetaData.setHttpStatus(HttpStatus.OK);
	    accessMetaData.setMessage("Appointments obtained succesfully");
	    // TODO consulta db
	    brachResponse.setData(generateTakenSlots(id));
	    //TODO poner los resultados de las Uri posbiles
	    LOGGER.info("Appointments obtained succesfully");

	} catch (Exception e) {
	    accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
	    accessMetaData.setMessage("Unable to retrive appointments");
	    //TODO poner un ejemplo correcto
	    LOGGER.error("Unable to retrive appointments error: " + e.getMessage());
	}
	brachResponse.setMetaData(accessMetaData);
	return new ResponseEntity<ServerResponse<HashMap<String, List<Appointment>>>>(brachResponse, HttpStatus.OK);

    }

    private HashMap<String, List<Appointment>> generateTakenSlots(String id) {

	HashMap<String, List<Appointment>> branchs = new HashMap<String, List<Appointment>>();

	List<Appointment> takenSlots = new ArrayList<Appointment>();

	takenSlots.add(new Appointment(1, "Dr Dentista", "Martin", SlotState.CONFIRM, 1, 1, 2016, 14, 0, 15, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Mariela", 1, 1, 2016, 15, 0, 15, 15));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Marcos", 1, 1, 2016, 17, 30, 18, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Mario", SlotState.CLOSED, 1, 1, 2016, 16, 30, 17, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Marcela", SlotState.SELECTED, 1, 1, 2016, 18, 30, 20, 0));

	branchs.put("Sucursal 1", appointmenHandler.getFreeAppointments(takenSlots).getBranchAppointments().get(SlotState.OPEN));

	takenSlots.add(new Appointment(2, "Dr Dentista", "Julian", SlotState.CONFIRM, 1, 1, 2016, 14, 45, 15, 15));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Julia", SlotState.SELECTED, 1, 1, 2016, 17, 45, 18, 15));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Julieta", SlotState.SELECTED, 1, 1, 2016, 15, 15, 15, 45));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Josefina", SlotState.SELECTED, 1, 1, 2016, 16, 30, 17, 0));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Jorge", SlotState.CLOSED, 1, 1, 2016, 18, 30, 19, 15));

	branchs.put("Sucursal 2", appointmenHandler.getFreeAppointments(takenSlots).getBranchAppointments().get(SlotState.OPEN));

	takenSlots.add(new Appointment(3, "Dr Dentista", "Vanina", SlotState.CONFIRM, 1, 1, 2016, 14, 00, 15, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Veronica", 1, 1, 2016, 15, 0, 16, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Valentina", SlotState.CONFIRM, 1, 1, 2016, 16, 0, 16, 45));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Valeria", SlotState.CLOSED, 1, 1, 2016, 17, 0, 18, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Victoria", SlotState.CLOSED, 1, 1, 2016, 18, 30, 19, 30));

	branchs.put("Sucursal 3", appointmenHandler.getFreeAppointments(takenSlots).getBranchAppointments().get(SlotState.OPEN));

	takenSlots.add(new Appointment(4, "Cama 4", "Silvina", SlotState.CLOSED, 1, 1, 2016, 15, 0, 15, 15));
	takenSlots.add(new Appointment(4, "Cama 4", "Sandra", SlotState.CONFIRM, 1, 1, 2016, 17, 45, 18, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Santino", SlotState.CLOSED, 1, 1, 2016, 15, 30, 16, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Sergio", SlotState.SELECTED, 1, 1, 2016, 16, 0, 17, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Sebastian", 1, 1, 2016, 19, 30, 20, 0));

	branchs.put("Sucursal 4", appointmenHandler.getFreeAppointments(takenSlots).getBranchAppointments().get(SlotState.OPEN));

	return branchs;
    }

    private HashMap<String, Branch> generateAllSlots(String id) {

	HashMap<String, Branch> branchs = new HashMap<String, Branch>();
	List<Appointment> takenSlots = new ArrayList<Appointment>();

	takenSlots.add(new Appointment(1, "Dr Dentista", "Martin", SlotState.CONFIRM, 1, 1, 2016, 14, 0, 15, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Mariela", 1, 1, 2016, 15, 0, 15, 15));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Marcos", 1, 1, 2016, 17, 30, 18, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Mario", SlotState.CLOSED, 1, 1, 2016, 16, 30, 17, 0));
	takenSlots.add(new Appointment(1, "Dr Dentista", "Marcela", SlotState.SELECTED, 1, 1, 2016, 18, 30, 20, 0));
	branchs.put("Sucursal 1", appointmenHandler.getFreeAppointments(takenSlots));

	takenSlots.add(new Appointment(2, "Dr Dentista", "Julian", SlotState.CONFIRM, 1, 1, 2016, 14, 45, 15, 15));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Julia", SlotState.SELECTED, 1, 1, 2016, 17, 45, 18, 15));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Julieta", SlotState.SELECTED, 1, 1, 2016, 15, 15, 15, 45));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Josefina", SlotState.SELECTED, 1, 1, 2016, 16, 30, 17, 0));
	takenSlots.add(new Appointment(2, "Dr Dentista", "Jorge", SlotState.CLOSED, 1, 1, 2016, 18, 30, 19, 15));

	branchs.put("Sucursal 2", appointmenHandler.getFreeAppointments(takenSlots));

	takenSlots.add(new Appointment(3, "Dr Dentista", "Vanina", SlotState.CONFIRM, 1, 1, 2016, 14, 00, 15, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Veronica", 1, 1, 2016, 15, 0, 16, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Valentina", SlotState.CONFIRM, 1, 1, 2016, 16, 0, 16, 45));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Valeria", SlotState.CLOSED, 1, 1, 2016, 17, 0, 18, 0));
	takenSlots.add(new Appointment(3, "Dr Dentista", "Victoria", SlotState.CLOSED, 1, 1, 2016, 18, 30, 19, 30));

	branchs.put("Sucursal 3", appointmenHandler.getFreeAppointments(takenSlots));

	takenSlots.add(new Appointment(4, "Cama 4", "Silvina", SlotState.CLOSED, 1, 1, 2016, 15, 0, 15, 15));
	takenSlots.add(new Appointment(4, "Cama 4", "Sandra", SlotState.CONFIRM, 1, 1, 2016, 17, 45, 18, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Santino", SlotState.CLOSED, 1, 1, 2016, 15, 30, 16, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Sergio", SlotState.SELECTED, 1, 1, 2016, 16, 0, 17, 0));
	takenSlots.add(new Appointment(4, "Cama 4", "Sebastian", 1, 1, 2016, 19, 30, 20, 0));

	branchs.put("Sucursal 4", appointmenHandler.getFreeAppointments(takenSlots));

	return branchs;
    }
}
