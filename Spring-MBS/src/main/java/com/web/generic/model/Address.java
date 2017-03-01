package com.web.generic.model;

public class Address {

	private String street;// Direccion_Sucursal
	private int number;// DireccionNro_Sucursal
	private int floor;
	private String postalCode;// DireccionCP_Sucursal
	private String district;// Barrio_Sucursal
	private String city;// Barrio_Sucursal
	private String province;// Provincia_Sucursal
	private String country;// Pais_Sucursal
	private String coordenates;// Coordenadas_Sucursal; Se deberia validar: lat
								// : long
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCoordenates() {
		return coordenates;
	}
	public void setCoordenates(String coordenates) {
		this.coordenates = coordenates;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", floor=" + floor + ", postalCode=" + postalCode + ", district=" + district + ", city=" + city + ", province=" + province + ", country=" + country + ", coordenates=" + coordenates + "]";
	}

}
