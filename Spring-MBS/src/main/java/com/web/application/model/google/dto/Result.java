package com.web.application.model.google.dto;

import java.util.List;

public class Result {
	private List<AddressComponent> address_components;
	private Geometry geometry;
	private String formatted_address;
	private String place_id;
	private List<String> types;

	public List<AddressComponent> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<AddressComponent> address_components) {
		this.address_components = address_components;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
	
	

	@Override
	public String toString() {
		return "Result [address_components=" + address_components + ", geometry=" + geometry + ", formatted_address=" + formatted_address + ", place_id=" + place_id + ", types=" + types + "]";
	}

}
