package com.mthree.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestDatabase {
	private static String classForName;
	private static String connectionString = null;
	private static String username;
	private static String password;
	private static Connection connection;
	private static Statement stmt;

	
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
			//connection = DriverManager.getConnection(connectionString, uid, pwd);
			//stmt = connection.createStatement();
			//read("Ruse");
			
			
			
			String PERS = "DVDRentalShop";
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERS);
			DAO<Actor> dao = new DAO<>(factory);
			//Optional<List<City>> oCityList = dao.read("CITY", "Lima", City.class); //ColumnName, ColumnValue, Class
			Optional<List<Actor>> oCityList = dao.read("last_name", "WAHLBERG", Actor.class);
			System.out.println(oCityList.get().get(0).toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
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

	public static String getClassForName() {
		return classForName;
	}

	public static void setClassForName(String classForName) {
		TestDatabase.classForName = classForName;
	}

	public static String getConnectionString() {
		return connectionString;
	}

	public static void setConnectionString(String connectionString) {
		TestDatabase.connectionString = connectionString;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		TestDatabase.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		TestDatabase.password = password;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		TestDatabase.connection = connection;
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static void setStmt(Statement stmt) {
		TestDatabase.stmt = stmt;
	}
}
