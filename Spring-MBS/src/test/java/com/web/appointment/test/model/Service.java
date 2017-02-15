package com.web.appointment.test.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

	private Map<String, List<Months>> serviceSlots;

	public Service(HashMap<String, List<Months>> hashMap) {
		super();
		this.serviceSlots = hashMap;
	}

	public Map<String, List<Months>> getServiceSlots() {
		return serviceSlots;
	}

	public void setServiceSlots(Map<String, List<Months>> serviceSlots) {
		this.serviceSlots = serviceSlots;
	}

	@Override
	public String toString() {
		return "Service [serviceSlots=" + serviceSlots + "]";
	}


}
