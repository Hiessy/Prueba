package com.web.application.model.dto;

public class Contact {

	private int contactId;
	private Address address;
	private String telephone;
	private String personalIdNumber;
	private String businessIdNumber;
		
	public Contact(Address address, String telephone, String personalIdNumber, String businessIdNumber) {
		super();
		this.address = address;
		this.telephone = telephone;
		this.personalIdNumber = personalIdNumber;
		this.businessIdNumber = businessIdNumber;
	}
	
	public Contact() {
		super();
	}

	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPersonalIdNumber() {
		return personalIdNumber;
	}
	public void setPersonalIdNumber(String personalIdNumber) {
		this.personalIdNumber = personalIdNumber;
	}
	public String getBusinessIdNumber() {
		return businessIdNumber;
	}
	public void setBusinessIdNumber(String businessIdNumber) {
		this.businessIdNumber = businessIdNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", address=" + address + ", telephone=" + telephone + ", personalIdNumber=" + personalIdNumber + ", businessIdNumber=" + businessIdNumber + "]";
	}
	
	
	
}
