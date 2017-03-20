package com.web.application.model.dto;


public class Customer {
	

	private int customerId; // Id_Cliente Numerico Incremental
	private Contact contact;
	private String customerName;// Nombre Texto
	private String customerEmail;// Mail Texto
	private String customerPassword;// Mail Texto
	private String customerDob;
	private String customerState;// Mail Texto
	
	public Customer() {
		super();
	}
		
	public Customer(int customerId, Contact contact, String customerName, String customerEmail, String customerPassword, String dateOfBirth, String customerState) {
		super();
		this.customerId = customerId;
		this.contact = contact;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerDob = dateOfBirth;
		this.customerState = customerState;
	}

	public Customer(Contact contact, String customerName, String customerEmail, String customerPassword,
			String customerState) {
		super();
		this.contact = contact;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerState = customerState;
	}
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contact=" + contact + ", customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPassword=" + customerPassword + ", customerState=" + customerState + "]";
	}

	public String getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(String dateOfBirth) {
		this.customerDob = dateOfBirth;
	}





}
