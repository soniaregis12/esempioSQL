package it.polito.tdp.esempioSQLdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect {
	
	public static Connection getConnection() throws SQLException {
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=MuccaVolante98";

		return DriverManager.getConnection(jdbcURL);
	}

}
