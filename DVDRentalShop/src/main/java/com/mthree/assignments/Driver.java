package com.mthree.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Driver {
	
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
			prop.getProperty("ClassForName");
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
