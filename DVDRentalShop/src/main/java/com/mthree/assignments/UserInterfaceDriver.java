package com.mthree.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterfaceDriver {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private boolean cont = true;
	public static final String QUIT = "q";

	public static void main(String[] args) {
		UserInterfaceDriver io = new UserInterfaceDriver();
		System.out.println("Welcome Select an Option");
		do {
			io.welcomeOptions(io);
		} while (io.shouldCont());
		System.out.println("Goodbye");
	}

	private void welcomeOptions(UserInterfaceDriver io) {
		int selectedOption;
		try {
			System.out.println(
					"1 Customer Management\n2 Rental Management\n3 Film Magement\n4 Staff Management\nq Quit\n");
			String userInput = io.reader.readLine();
			if (userInput.equals(QUIT)) {
				io.setCont(false);
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					io.customerManagement();
					break;
				case 2:
					io.rentalManagement();
					break;
				case 3:
					io.filmManagement();
					break;
				case 4:
					io.staffManagement();
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Invalid Selection Please Try Again");
		}
	}

	private void customerManagement() {
		System.out.println("Customer Managment: ");
		System.out.println("1 Customer Search\n2 Customers with Outstanding Late Rentals\n3 Customers with Pending Fees"
				+ "\n4 Customers by Late Rentals\n5 Customers by Largest Revenue");
		int selectedOption;
		try {
			String userInput = reader.readLine();
			if (userInput.equals(QUIT)) {
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					System.out.println("Customer Managment-CustomerSearch: Enter your search:");
					// TODO Add Query Call
					break;
				case 2:
					System.out.println("Customer Managment-Customers with Outstanding Late Rentals:");
					// TODO Add Query Call
					break;
				case 3:
					System.out.println("Customer Managment-Customers with Pending Fees:");
					// TODO Add Query Call
					break;
				case 4:
					System.out.println("Customer Managment-Customers by Late Rentals:");
					// TODO Add Query Call
					break;
				case 5:
					System.out.println("Customer Managment-Customers by Largest Revenue:");
					// TODO Add Query Call
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void rentalManagement() {
		System.out.println("Rental Management: ");
		System.out.println("1 Current Rentals\n2 Late Rentals\n3 Rentals Due Tomorrow\nq Quit\n");
		int selectedOption;
		try {
			String userInput = reader.readLine();
			if (userInput.equals(QUIT)) {
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					System.out.println("Rental Managment-Current Rentals:");
					// TODO Add Query Call
					break;
				case 2:
					System.out.println("Rental Managment-Late Rentals:");
					// TODO Add Query Call
					break;
				case 3:
					System.out.println("Rental Managment-Rentals Due Tomorrow:");
					// TODO Add Query Call
					break;
				default:
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void filmManagement() {
		System.out.println("Film Management: ");
		System.out.println(
				"1 Film Search\n2 Most Popular Films\n3 Most Popular Category\n4 Films in Stock\5 Films Checked Out\nq Quit\n");
		int selectedOption;
		try {
			String userInput = reader.readLine();
			if (userInput.equals(QUIT)) {
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					System.out.println("Film Managment-Film Search: Enter your search:");
					// TODO Add Query Call
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void staffManagement() {
		System.out.println("Staff Management: ");
		System.out.println("1 Employee Search\n2 Highest Grossing Employee\n3 Total Store Revenue\nq Quit\n");
		int selectedOption;
		try {
			String userInput = reader.readLine();
			if (userInput.equals(QUIT)) {
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					System.out.println("Staff Managment-Employee Search: Enter your search:");
					// TODO Add Query Call
					break;
				case 2:
					System.out.println("Staff Managment-Highest Grossing Employee:");
					// TODO Add Query Call
					break;
				case 3:
					System.out.println("Staff Managment-Total Store Revenue:");
					// TODO Add Query Call
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean shouldCont() {
		return cont;
	}

	public void setCont(boolean cont) {
		this.cont = cont;
	}

}
