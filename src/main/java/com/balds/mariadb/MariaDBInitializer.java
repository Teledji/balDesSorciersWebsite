package com.balds.mariadb;
import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Profile;

@Profile("local")
public class MariaDBInitializer {
	private DB db;
	private Connection conn;
	
	public MariaDBInitializer(){
		DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
		configBuilder.setPort(3307); // OR, default: setPort(0); => autom. detect free port
		configBuilder.setDataDir("/home/theapp/db"); // just an example
		try {
			db = DB.newEmbeddedDB(configBuilder.build());
		} catch (ManagedProcessException e) {
			e.printStackTrace();
		}
		try {
			db.start();
		} catch (ManagedProcessException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
