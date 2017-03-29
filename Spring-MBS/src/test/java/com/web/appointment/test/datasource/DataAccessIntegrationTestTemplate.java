package com.web.appointment.test.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.web.appointment.test.model.alternative.Appointment;
import com.web.appointment.test.model.alternative.Provider;

public class DataAccessIntegrationTestTemplate {

	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		// creates an HSQL in-memory database populated from default scripts
		// classpath:schema.sql and classpath:data.sql
		db = new EmbeddedDatabaseBuilder().setType(org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").ignoreFailedDrops(true).addScript("/datasource/create_schema.sql")
				.addScript("/datasource/insert_data.sql").build();
	}

	@Test
	public void testDataAccess() {

		String time = (LocalDate.now().toString().replace("-", "").replaceFirst("20", "")) + (LocalTime.now().toString().substring(0, 5).replace(":", ""));
		String sqlGetId = "SELECT s.service_id, s.service_duration, s.service_name, sb.subcategory_name FROM services s INNER JOIN subcategories sb ON s.subcategory_id = sb.subcategory_id WHERE s.service_name = 'Swedish Massage' and s.service_state = 'ACTIVE';";

		JdbcTemplate template = new JdbcTemplate(db);
		template.execute(sqlGetId);

		Map<String, Object> resultSet = template.queryForMap(sqlGetId);

		// TODO hacer consultas que se hace por servicio-- que es en si una
		// lista de subcategorias
		Integer id = (Integer) resultSet.get("SERVICE_ID"); // service_id
		String subCategory = (String) resultSet.get("SUBCATEGORY_NAME"); // subcategory_name

		int beginHour = 0; // provider
		int beginMinute = 0; // provider
		int endHour = 0; // provider
		int endMinute = 0; // provider

		String serviceName = (String) resultSet.get("SERVICE_NAME");
		Integer appointmentDuration = (Integer) resultSet.get("SERVICE_DURATION"); // duration

		String slqGetProvider = "SELECT provider_id, sunday, monday, tuesday, wednesday, thursday, friday, saturday FROM personal_schedules where service_id = " + id + " AND personal_state = 'ACTIVE';";

		List<Provider> providers = template.query(slqGetProvider, new RowMapper<Provider>() {
			public Provider mapRow(ResultSet rs, int rowNum) throws SQLException {
				Provider provider = new Provider(rs.getInt("provider_id"), rs.getString("sunday"), rs.getString("monday"), rs.getString("tuesday"), rs.getString("wednesday"), rs.getString("thursday"), rs.getString("friday"), rs.getString("saturday"));
				return provider;
			}
		});

		System.out.println("serviceName: " + serviceName);
		for (Provider prov : providers) {
			// SELECT appointment_time FROM appointments WHERE provider_id = 1
			// AND appointment_time >= time;

			// De todos los turnos del primer dia filtrar luego de la hora
			// actual;
			// TODO select from database all appointments for specific provider
			// that have a day greater than ecual to today and hours is grater
			// date;
			// time;
			// TODO for dias desde hoy hasta find de mes
			// TODO for horas desde ahora hasta el final del horario de la
			// persona
			System.out.println(prov.toString());
			List<Appointment> appointmentsUsed = null;

		}

	}

	@After
	public void tearDown() {
		db.shutdown();
	}
}
