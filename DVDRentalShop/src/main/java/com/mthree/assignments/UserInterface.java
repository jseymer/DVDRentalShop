package com.mthree.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserInterface {
	BufferedReader reader;
	EntityManagerFactory factory;
	private boolean cont;
	public static final String QUIT = "q";
	public static final String PERS = "DVDRentalShop";
	
	public UserInterface() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		factory = Persistence.createEntityManagerFactory(PERS);
		cont = true;
	}

	public void begin() {
		System.out.println("Welcome Select an Option");
		do {
			displayInitalOptions();
		} while (shouldCont());
		System.out.println("Goodbye");
	}

	private void displayInitalOptions() {
		int selectedOption;
		try {
			System.out.println(
					"1 Customer Management\n2 Rental Management\n3 Film Magement\n4 Staff Management\nq Quit\n");
			String userInput = reader.readLine();
			if (userInput.equals(QUIT)) {
				setCont(false);
				return;
			} else {
				selectedOption = Integer.parseInt(userInput);
				switch (selectedOption) {
				case 1:
					displayCustomerManagement();
					break;
				case 2:
					displayRentalManagement();
					break;
				case 3:
					displayFilmManagement();
					break;
				case 4:
					displayStaffManagement();
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

	private void displayCustomerManagement() {
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
					userInput = reader.readLine();
					executeCustomerSearch(userInput);
					break;
				case 2:
					System.out.println("Customer Managment-Customers with Outstanding Late Rentals:");
					executeCustomerOutstandingLateRentalSearch();
					break;
				case 3:
					System.out.println("Customer Managment-Customers with Pending Fees:");
					executeCustomerPendingFeeSearch();
					break;
				case 4:
					System.out.println("Customer Managment-Customers by Most Late Rentals:");
					executeCustomerMostLateSearch();
					break;
				case 5:
					System.out.println("Customer Managment-Customers by Largest Revenue:");
					executeCustomerLargestRevenueSearch();
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void executeCustomerSearch(String userInput) {
		DAO<Customer> dao = new DAO<>(factory);
		Optional<List<Customer>> oCustomerList = null;;
		try {
			oCustomerList = dao.read("FIRST_NAME", userInput, Customer.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oCustomerList);
		
		oCustomerList = null;;
		try {
			oCustomerList = dao.read("LAST_NAME", userInput, Customer.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oCustomerList);
	}
	private void executeCustomerOutstandingLateRentalSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	private void executeCustomerPendingFeeSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	private void executeCustomerMostLateSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	private void executeCustomerLargestRevenueSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}

	private void displayRentalManagement() {
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
					executeCurrentRentalSearch();
					break;
				case 2:
					System.out.println("Rental Managment-Late Rentals:");
					executeLateRentalSearch();
					break;
				case 3:
					System.out.println("Rental Managment-Rentals Due Tomorrow:");
					executeRentalDueTomorrowSearch();
					break;
				default:
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void executeCurrentRentalSearch() {
		DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);
	}
	
	private void executeLateRentalSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	
	private void executeRentalDueTomorrowSearch() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	
	

	private void displayFilmManagement() {
		System.out.println("Film Management: ");
		System.out.println(
				"1 Film Search\n2 Most Popular Films\n3 Most Popular Category\n4 Films in Stock\n5 Films Checked Out\nq Quit\n");
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
					userInput = reader.readLine();
					executeFilmSearch(userInput);
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void executeFilmSearch(String userInput) {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}

	private void displayStaffManagement() {
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
					userInput = reader.readLine();
					executeEmployeeSearch(userInput);
					break;
				case 2:
					System.out.println("Staff Managment-Highest Grossing Employee:");
					executeHighestEmployee();
					break;
				case 3:
					System.out.println("Staff Managment-Total Store Revenue:");
					executeTotalStoreRevenue();
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void executeEmployeeSearch(String userInput) {
		DAO<Staff> dao = new DAO<>(factory);
		Optional<List<Staff>> oCustomerList = null;
		try {
			oCustomerList = dao.read("FIRST_NAME", userInput, Staff.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oCustomerList);
		
		oCustomerList = null;;
		try {
			oCustomerList = dao.read("LAST_NAME", userInput, Staff.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oCustomerList);
	}
	private void executeHighestEmployee() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}
	private void executeTotalStoreRevenue() {
		//TODO
		/*DAO<Rental> dao = new DAO<>(factory);
		Optional<List<Rental>> oList = null;
		try {
			oList = dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL", Rental.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);*/
	}

	public boolean shouldCont() {
		return cont;
	}

	public void setCont(boolean cont) {
		this.cont = cont;
	}

}
