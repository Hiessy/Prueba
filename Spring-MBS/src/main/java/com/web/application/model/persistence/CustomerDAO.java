package com.web.application.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.application.config.DataSource;
import com.web.application.model.dto.Address;
import com.web.application.model.dto.Contact;
import com.web.application.model.dto.Customer;
import com.web.application.model.enums.UserState;

public class CustomerDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerDAO.class);
	private Connection conn;

	public CustomerDAO() {
		conn = DataSource.getEmbeddedDataBase();
	}

	// TODO manejar la logica para multiples insert si uno falla y otro funca
	// TODO get last inserted ID and set to address --> contact --> customer
	public Customer[] addCustomers(Customer[] customers) {
		
		try {
			for (int i = 0; i < customers.length; i++) {
				LOGGER.info("Storing customer: " + customers[i].getCustomerEmail() + " in database ");

				Address address = customers[i].getContact().getAddress();

				int addressId = insertAddress(address);
				LOGGER.info("Stored address: " + address.getStreet() + "," + address.getCity() + "," + address.getCountry() + " in database with id: " + addressId);
				customers[i].getContact().getAddress().setAddressId(addressId);

				int contactId = insertContact(customers[i].getContact());
				LOGGER.info("Stored contact information for: " + customers[i].getContact().getPersonalIdNumber() + " in database with id: " + contactId);
				customers[i].getContact().setContactId(contactId);

				int customerId = insertCustomer(customers[i]);
				LOGGER.info("Stored customer: " + customers[i].getCustomerName() + " in database with id: " + customerId);
				customers[i].setCustomerId(customerId);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customers;
	}

	public Customer getCustomers(String id) {
		Customer customer = null;

		try {

			LOGGER.info("Getting Customer data for customer: " + id + " from database ");

			customer = getCustomersById(id);
			LOGGER.info("Getting contact information for customer: " + customer.getCustomerName() + " in database with id: " + id);

			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customer;
	}

	private Customer getCustomersById(String id) throws SQLException {
		
//		Statement stmt = conn.createStatement();		
//		
//		String sqlGetCustomerById = "SELECT * FROM customers WHERE customer_id = " + id;
//		
//        ResultSet rsCustomer = stmt.executeQuery(sqlGetCustomerById);                
//		LOGGER.info("Customer information{customer_id: " + rsCustomer.getInt("customer_id") + " ,contact_id: " +rsCustomer.getInt("contact_id")+ " ,customer_name: " +rsCustomer.getString("customer_name")+ " ,email: " +rsCustomer.getString("email")+ " ,password: " +rsCustomer.getString("password")+ " ,customer_state: " +rsCustomer.getString("customer_state"));
//		
//		String sqlGetContactById = "SELECT * FROM contacts WHERE customer_id = " + rsCustomer.getInt("contact_id");	
//		
//		ResultSet rsContact = stmt.executeQuery(sqlGetContactById);		
//		LOGGER.info("Contact information{contact_id: " + rsContact.getInt("contact_id") + " ,address_id: " +rsContact.getInt("address_id")+ " ,telephone: " +rsContact.getString("telephone")+ " ,cellphone: " +rsContact.getString("cellphone")+ " ,personal_id_number: " +rsContact.getString("personal_id_number")+ " ,business_id_number: " +rsContact.getString("business_id_number"));
//		
//		String sqlAddressById = "SELECT * FROM addresses WHERE customer_id = " + rsContact.getInt("address_id");		
//		
//		ResultSet rsAddress = stmt.executeQuery(sqlAddressById);		
//		LOGGER.info("Address information{address_id: " + rsAddress.getInt("address_id") + " ,street: " +rsContact.getString("street")+ " ,street_nbr: " +rsContact.getString("street_nbr")+ " ,floor: " +rsContact.getString("floor")+ " ,postalCode: " +rsContact.getString("postalCode")+ " ,district: " +rsContact.getString("district")+ " ,city: " +rsContact.getString("city")+ " ,province: " +rsContact.getString("province")+ " ,country: " +rsContact.getString("country")+ " ,coordenates: " +rsContact.getString("coordenates"));
//		
//		Address address = new Address(rsAddress.getInt("address_id"),rsContact.getString("street"),Integer.valueOf(rsContact.getString("street_nbr")),Integer.valueOf(rsContact.getString("floor")),rsContact.getString("postalCode"),rsContact.getString("district"),rsContact.getString("city"),rsContact.getString("province"),rsContact.getString("country"),rsContact.getString("coordenates"));
//		Contact contact = new Contact(rsContact.getInt("contact_id"),address,rsContact.getString("telephone"),rsContact.getString("cellphone"),rsContact.getString("personal_id_number"),rsContact.getString("business_id_number"));
//		Customer customer = new Customer(rsCustomer.getInt("customer_id"), contact,rsCustomer.getString("customer_name"),rsCustomer.getString("email"),rsCustomer.getString("password"),rsCustomer.getString("customer_dob"),rsCustomer.getString("customer_state"));
//
		return null;
	}

	private int insertCustomer(Customer customer) throws SQLException {
		String sqlInsertCustomer = "INSERT INTO customers (contact_id, customer_name, email, password, customer_dob, customer_state) VALUES ('" + customer.getContact().getContactId() + "','" + customer.getCustomerName() + "','" + customer.getCustomerEmail() + "','"
				+ customer.getCustomerPassword() + "','" + customer.getCustomerDob() + "','" + customer.getCustomerState() + "');";

		return insertGetID(sqlInsertCustomer);
	}

	private int insertContact(Contact contact) throws SQLException {
		String sqlInsertContact = "INSERT INTO contacts (address_id, telephone, cellphone, personal_id_number, business_id_number) VALUES ('" + contact.getAddress().getAddressId() + "','" + contact.getTelephone() + "','" + contact.getCellphone() + "','"
				+ contact.getPersonalIdNumber() + "','" + contact.getBusinessIdNumber() + "');";

		return insertGetID(sqlInsertContact);
	}

	private int insertAddress(Address address) throws SQLException {

		String sqlInsertAddress = "INSERT INTO addresses(street,street_nbr,floor,postalCode,district,city,province,country,coordenates) VALUES ('" + address.getStreet() + "','" + address.getNumber() + "','" + address.getFloor() + "','" + address.getPostalCode() + "','"
				+ address.getDistrict() + "','" + address.getCity() + "','" + address.getProvince() + "','" + address.getCountry() + "','" + address.getCoordenates() + "');";

		return insertGetID(sqlInsertAddress);
	}

	private int insertGetID(String sqlInsert) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
		int id = stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();

		if (rs.next()) {
			id = rs.getInt(1);
		} else {
			throw new RuntimeException("Not able to get last inserted value");
		}
		rs.close();
		rs = null;

		return id;

	}

}
