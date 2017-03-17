package com.web.application.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.application.model.enums.UserState;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId; // Id_Cliente Numerico Incremental
	@OneToOne 
	private Contact contact;
	private String customerName;// Nombre Texto
	private String customerEmail;// Mail Texto
	private String customerPassword;// Mail Texto
	private String dateOfBirth;
	private UserState customerState;// Mail Texto
	
	public Customer() {
		super();
	}

	public Customer(Contact contact, String customerName, String customerEmail, String customerPassword,
			UserState customerState) {
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
	public UserState getCustomerState() {
		return customerState;
	}
	public void setCustomerState(UserState customerState) {
		this.customerState = customerState;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contact=" + contact + ", customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPassword=" + customerPassword + ", customerState=" + customerState + "]";
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}





}
