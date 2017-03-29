//package com.web.application.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//
//import com.mysql.jdbc.Driver;
//
//@Context
//@Configuration
//public class DataSource {
//
//	private static Connection instance = null;
//
//	private static final Logger logger = Logger.getLogger(DataSource.class);
//
//	public static Connection getConnection() {
//		if (instance == null) {
//			instance = newConnection();
//		}
//
//		return instance;
//	}
//
//	private static Connection newConnection() {
//		Connection conn = null;
//
//		try {
//			DriverManager.registerDriver(new Driver());
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ram?autoReconnect=true", "thors", "pmdj2424");
//			logger.info("Connection to database established");
//		} catch (Exception e) {
//			logger.error("Unable to connecto to database", e);
//		}
//
//		return conn;
//	}
//	
//	public static Connection getEmbeddedDataBase(){
//		EmbeddedDatabase db = new EmbeddedDatabaseBuilder().generateUniqueName(true).setType(org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").ignoreFailedDrops(true).addScript("/datasource/create_schema.sql")
//		.addScript("/datasource/insert_data.sql").build();
//		
//		 try {
//			return db.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		 return null;
//	}
//
//}