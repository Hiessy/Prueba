package com.web.appointment.test.datasource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.web.appointment.model.Slot;
import com.web.appointment.service.AppointmenHandler;

public class DataAccessIntegrationTestTemplate {
	
	 private EmbeddedDatabase db;

	    @Before
	    public void setUp() {
	        // creates an HSQL in-memory database populated from default scripts
	        // classpath:schema.sql and classpath:data.sql
	        db = new EmbeddedDatabaseBuilder()
	                .generateUniqueName(true)
	                .setType(org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2)
	                .setScriptEncoding("UTF-8")
	                .ignoreFailedDrops(true)
	                .addScript("/datasource/create_schema.sql")
	                .addScript("/datasource/insert_data.sql")
	                .build();
	        }
	

	    @Test
	    public void testDataAccess() {
	    	
	    	String sql = "INSERT INTO customers (address_id, customer_name, email, password) VALUES (7,'Agustin Larrarte','alarrarte@mail.com','1234abcd');";
	        JdbcTemplate template = new JdbcTemplate(db);
//	        template.execute(sql);
//	        Map<String, Object> resultSet = template.queryForMap("SELECT * FROM CUSTOMERS");

	        
//	        List<Map<String, Object>> resultSet2 = template.queryForList("SELECT * FROM PROVIDERS");
	        
	        //TODO hacer consultas que se hace por servicio-- que es en si una lista de subcategorias
	        int id = 0; //service_id
	        String subCategory = ""; //subcategory_name tabla subtegory
	        int beginHour = 0; //provider 
	        
	        int beginMinute = 0; //provider 
	        int  endHour = 0; //provider 
	        int  endMinute = 0; //provider 
	        String serviceState = "";
	        String serviceName = "";
	        int appointmentDuration = 0; //duration
	        
	        AppointmenHandler appointmenHandler = new AppointmenHandler(new Slot(id, subCategory, beginHour, beginMinute, endHour, endMinute, appointmentDuration));// TODO
	        
//	        System.out.println(resultSet.size());
//	        System.out.println(resultSet2.size());
//	        System.out.println(resultSet2.get(0).get("provider_id").toString());
	    }

	    @After
	    public void tearDown() {
	        db.shutdown();
	    }
}
