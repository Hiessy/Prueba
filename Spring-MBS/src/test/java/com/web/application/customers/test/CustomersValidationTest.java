package com.web.application.customers.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.web.application.exceptions.CustomerException;
import com.web.application.model.dto.Address;
import com.web.application.model.dto.Contact;
import com.web.application.model.dto.Customer;
import com.web.application.model.enums.UserState;
import com.web.application.model.validation.ContactValidation;
import com.web.application.model.validation.CustomerValidation;
import com.web.application.service.Validator;

public class CustomersValidationTest {

	private Customer customerOk;
	private Customer customerFailNoData;
	private Customer customerFailIncorrectData; // numero o caracter

	@Before
	public void setUp() {

		Address address = new Address("Rosario", 68, "Ciudad Autonoma de Buenos Aires", "Buenos Aires", "AR");
		Contact contact = new Contact(address, "1568952059", "27093141", "20-27093141-4");
		customerOk = new Customer(contact, "Martin Diaz", "mdiaz@mail.com", "Esta_UnaC0n!4aseñaVali", "ACTIVE");
		customerFailNoData = new Customer(null, null, null, null, "ACTIVE");
		customerFailIncorrectData = new Customer(null, "", "email_noemail.com", "123abc", "ACTIVE");

	}

	@Test
	public void customerCreationTestOk() throws CustomerException {
		CustomerValidation.validateCustomer(customerOk);
		assertEquals("-34.618417:-58.4295491", customerOk.getContact().getAddress().getCoordenates());
	}

	@Test
	public void customerCreationTestFail() {
		try {
			CustomerValidation.validateCustomer(null);
		} catch (CustomerException e) {
			assertEquals("Customer may not be null", e.getMessage());
		}
	}

	@Test
	public void customerNoEmailTestFail() {
		try {
			CustomerValidation.validateCustomer(customerFailNoData);
		} catch (CustomerException e) {
			assertEquals("Customer is missing email address", e.getMessage());
		}
	}

	@Test
	public void customerEmailTestFail() {
		try {
			CustomerValidation.validateCustomer(customerFailIncorrectData);
		} catch (CustomerException e) {
			assertEquals("Customer is email address is invalid", e.getMessage());
		}
	}

	@Test
	public void customerNameTestFail() {
		customerFailNoData.setCustomerEmail(customerOk.getCustomerEmail());
		try {
			CustomerValidation.validateCustomer(customerFailNoData);
		} catch (CustomerException e) {
			assertEquals("Customer is missing name", e.getMessage());
		}
	}

	@Test
	public void customerNoPasswordTestFail() {
		customerFailNoData.setCustomerEmail(customerOk.getCustomerEmail());
		customerFailNoData.setCustomerName(customerOk.getCustomerName());
		try {
			CustomerValidation.validateCustomer(customerFailNoData);
		} catch (CustomerException e) {
			assertEquals("Customer is missing password", e.getMessage());
		}
	}

	@Test
	public void customerPasswordTestFail() {
		customerFailIncorrectData.setCustomerEmail(customerOk.getCustomerEmail());
		customerFailIncorrectData.setCustomerName(customerOk.getCustomerName());
		try {
			CustomerValidation.validateCustomer(customerFailIncorrectData);
		} catch (CustomerException e) {
			assertEquals("Customer is password is invalid", e.getMessage());
		}
	}

	@After
	public void tearDown() {

	}
}
