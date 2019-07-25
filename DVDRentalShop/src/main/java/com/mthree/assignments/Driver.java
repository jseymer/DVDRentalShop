package com.mthree.assignments;

public class Driver {
	
	public static void main(String[] args) {
		DAO.loadPropertiesFile();
		UserInterface io = new UserInterface();
		io.begin();
	}
	



}
