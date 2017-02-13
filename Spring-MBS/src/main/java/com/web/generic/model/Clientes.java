package com.web.generic.model;

import java.util.Date;

public class Clientes {
	private Integer clientId; // Id_Cliente Numerico Incremental
	private String clientFirstName;// Nombre Texto
	private String clientLastName;// Apellido Texto
	private String telephoneNumber;// Telefono Texto
	private String socialSecurityNumber;// DNI Texto
	private Address address;
	private String customerEmail;// Mail Texto
	private Date subsriptionDate; // Fecha_Alta
	private Date unsubscriptionDate; // Fecha_Baja TODO change to modified
	private String sex;// Sexo Texto
	private String dateOfBirth;// Fecha de Nacimiento Fecha
	private String token;// TODO WHY? Token Texto

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getSubsriptionDate() {
		return subsriptionDate;
	}

	public void setSubsriptionDate(Date subsriptionDate) {
		this.subsriptionDate = subsriptionDate;
	}

	public Date getUnsubscriptionDate() {
		return unsubscriptionDate;
	}

	public void setUnsubscriptionDate(Date unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Clientes [clientId=" + clientId + ", clientFirstName=" + clientFirstName + ", clientLastName=" + clientLastName + ", telephoneNumber=" + telephoneNumber + ", socialSecurityNumber=" + socialSecurityNumber + ", address=" + address + ", customerEmail="
				+ customerEmail + ", subsriptionDate=" + subsriptionDate + ", unsubscriptionDate=" + unsubscriptionDate + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", token=" + token + "]";
	}

}
