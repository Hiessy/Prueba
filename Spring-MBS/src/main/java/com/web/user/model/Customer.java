package com.web.user.model;

import com.web.generic.model.Contact;

public class Customer {
	
	
	private int customerId; // Id_Cliente Numerico Incremental
	private Contact contact;
	private String customerName;// Nombre Texto
	private String customerEmail;// Mail Texto
	private String customerPassword;// Mail Texto
	private String customerState;// Mail Texto
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





}
