package com.web.application.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.web.application.config.DataSourceConfig;
import com.web.application.model.dto.Customer;
import com.web.application.model.dto.Address;
import com.web.appointment.test.model.alternative.Provider;

public class CustomerDAO {

	private DataSource dataSource;
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerDAO.class);

	public CustomerDAO() {
		this.dataSource = DataSourceConfig.dataSource();
	}

	// TODO manejar la logica para multiples insert si uno falla y otro funca
	//TODO get last inserted ID and set to address --> contact --> customer
	public Customer[] addCustomers(Customer[] customers) {
		// TODO Add TO DataBase
		JdbcTemplate template = new JdbcTemplate(dataSource);

		for (int i = 0; i < customers.length; i++) {
			LOGGER.info("Storing customers in database, working with customer id: " + (100 + i));
			Address address = customers[i].getContact().getAddress();
			String sqlInsertAddress = "INSERT INTO addresses(street,street_nbr,floor,postalCode,district,city,province,country,coordenates) VALUES ('" + address.getStreet() + "','" + address.getNumber() + "','" + address.getFloor() + "','" + address.getPostalCode() + "','"
					+ address.getDistrict() + "','" + address.getCity() + "','" + address.getProvince() + "','" + address.getCountry() + "','" + address.getCoordenates() + "');";

			String sqlGetId = "SELECT * FROM ADDRESSES";
			List<Address> resultSet =  template.query(sqlGetId, new RowMapper<Address>() {
				public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
					Address address = new Address(rs.getInt("address_id"), rs.getString("street"), rs.getInt("street_nbr"), rs.getInt("floor"), rs.getString("postalCode"), rs.getString("district"), rs.getString("city"), rs.getString("province"), rs.getString("country"), rs.getString("coordenates"));
					return address;
				}
			});
			
			System.out.println(resultSet.get(6));
			
			int addressId = template.update(sqlInsertAddress);
			customers[i].getContact().getAddress().setAddressId(addressId);

			String sqlInsertContact = "INSERT INTO contacts (address_id, telephone, cellphone, personal_id_number, business_id_number) VALUES ('" + addressId + "','" + customers[i].getContact().getTelephone() + "','" + customers[i].getContact().getCellphone() + "','"
					+ customers[i].getContact().getPersonalIdNumber() + "','" + customers[i].getContact().getBusinessIdNumber() + "');";
			int contactId = template.update(sqlInsertContact);
			customers[i].getContact().setContactId(contactId);

			String sqlInsertCustomer = "INSERT INTO customers (contact_id, customer_name, email, password, customer_state) VALUES ('" + contactId + "','" + customers[i].getCustomerName() + "','" + customers[i].getCustomerEmail() + "','" + customers[i].getCustomerPassword()
					+ "','" + customers[i].getCustomerState() + "');";
			int customerId = template.update(sqlInsertCustomer);
			customers[i].setCustomerId(customerId);

		}
		try {
			this.dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

}
