package com.web.application.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue
	private int addressId;
	private String street;// Direccion_Sucursal
	private int number;// DireccionNro_Sucursal
	private int floor;
	private String postalCode;// DireccionCP_Sucursal
	private String district;// Barrio_Sucursal
	private String city;// Barrio_Sucursal
	private String province;// Provincia_Sucursal
	private String country;// Pais_Sucursal
	private String coordenates;

	public Address() {
		super();
	}
	
	public Address(int addressId, String street, int number, int floor, String postalCode, String district, String city, String province, String country, String coordenates) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.postalCode = postalCode;
		this.district = district;
		this.city = city;
		this.province = province;
		this.country = country;
		this.coordenates = coordenates;
	}



	public Address(String street, int number, String city, String province, String country) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

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
		return "Address [addressId=" + addressId + ", street=" + street + ", number=" + number + ", floor=" + floor + ", postalCode=" + postalCode + ", district=" + district + ", city=" + city + ", province=" + province + ", country=" + country + ", coordenates=" + coordenates
				+ "]";
	}

}
