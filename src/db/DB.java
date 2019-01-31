/**
 * DB.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Establishes the main DataBase connection
 */
public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {

		if (conn == null) {

			try {

				Properties info = loadProperties();
				String url = info.getProperty("dburl");
				conn = DriverManager.getConnection(url, info);

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

		return conn;
	}

	// Read properties connection form external file to make the class more flexible
	private static Properties loadProperties() {
		
		try (FileInputStream propFile = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(propFile);
			return properties;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	/*
	 * The following methods are here to make it possible to
	 * throw any exception related to connection from DB class only.
	 * So that, most exception connections can be managed here.
	 */
	
	public static void closeStatement(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			
			try {
				conn.close();
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}			
		}
	}
}
