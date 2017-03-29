package com.web.application.model.dto;

public class Personal {

	
	/*
	 * personal_id INT NOT NULL AUTO_INCREMENT,
service_id INT(10) NOT NULL,
contact_id INT(10) NOT NULL,
personal_name varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
	 * 
	 */
	
	private int personalId; // Id_Cliente Numerico Incremental
	private Service service;
	private Contact contact;
	private String personalName;// Nombre Texto
	private String personalEmail;// Mail Texto
	private String personalPassword;// Mail Texto
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getPersonalPassword() {
		return personalPassword;
	}
	public void setPersonalPassword(String personalPassword) {
		this.personalPassword = personalPassword;
	}
	@Override
	public String toString() {
		return "Personal [personalId=" + personalId + ", service=" + service + ", contact=" + contact + ", personalName=" + personalName + ", personalEmail=" + personalEmail + ", personalPassword=" + personalPassword + "]";
	}	
	
}
