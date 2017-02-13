package com.web.generic.model;

public class Address {

	private String address;// Direccion_Sucursal
	private String streetNumber;// DireccionNro_Sucursal
	private String postalCode;// DireccionCP_Sucursal
	private String country;// Pais_Sucursal
	private String province;// Provincia_Sucursal
	private String district;// Barrio_Sucursal
	private String coordenates;// Coordenadas_Sucursal; Se deberia validar: lat
								// : long
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCoordenates() {
		return coordenates;
	}

	public void setCoordenates(String coordenates) {
		this.coordenates = coordenates;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode + ", country=" + country + ", province=" + province + ", district=" + district + ", coordenates=" + coordenates + "]";
	}

}
