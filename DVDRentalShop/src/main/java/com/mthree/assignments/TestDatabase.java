package com.mthree.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class TestDatabase {
	private static String classForName;
	private static String connectionString = null;
	private static String username;
	private static String password;
	private static Connection connection;
	private static Statement stmt;

	
	
	/*Run this to verify that your database connection works
	 * Should print out:
	 * 
	 * Class loaded
	 * Result: name is Ruse CITYID is 436 and COUNTRYID is 17
	 */
	public static void main(String[] args) {
		loadPropertiesFile();
	
		try {
			Class.forName(classForName);
			System.out.println("Class loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find class");
		}
		String uid = username;
		String pwd = password;
		try {
			connection = DriverManager.getConnection(connectionString, uid, pwd);
			stmt = connection.createStatement();
			read("Ruse");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Could not connect, or other sql problem, same comment as above");
		}
	}
	
	public static void read(String cityName) {
		String query = "select CITY, CITY_ID, COUNTRY_ID from CITY where CITY.CITY = '" + cityName + "'";
		try {
			
			if (stmt.execute(query)) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					int cityId = rs.getInt("CITY_ID");
					String name = rs.getNString("CITY");
					
					int countryId = rs.getInt("COUNTRY_ID");
					System.out.println("Result: name is " + name + " CITYID is " + cityId + " and COUNTRYID is " + countryId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadPropertiesFile() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("sampleProperties.properties");
			prop.load(input);
			classForName = prop.getProperty("ClassForName");
			connectionString = prop.getProperty("ConnectionString");
			username = prop.getProperty("Username");
			password = prop.getProperty("Password");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
