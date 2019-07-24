package com.mthree.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class Driver {
	private static String classForName;
	private static String connectionString = null;
	private static String username;
	private static String password;
	private static Connection connection;
	private static Statement stmt;
	
	public static void main(String[] args) {
		loadPropertiesFile();
		UserInterface io = new UserInterface();
		io.begin();
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
