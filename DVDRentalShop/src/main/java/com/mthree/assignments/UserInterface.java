package com.mthree.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.ResultSet;
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
		userInput = userInput.toUpperCase();
		DAO<Customer> dao = new DAO<>(factory);
		Optional<List<Customer>> oList = null;
		try {
			oList = dao.readCustomQuery("select c from Customer c where c.lName LIKE '%" + userInput + "%'",
					Customer.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);

		oList = null;
		try {
			oList = dao.readCustomQuery("select c from Customer c where c.fName LIKE '%" + userInput + "%'",
					Customer.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);
	}

	private void executeCustomerOutstandingLateRentalSearch() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
		
		
		/*String qlString = "select Max(total) as maximum from (SELECT STAFF_ID, Sum(AMOUNT) AS TOTAL FROM Payment GROUP BY STAFF_ID)";
		DAO<Payment> dao = new DAO<>(factory);
		ResultSet resultSet = dao.readSQLQuery(qlString);
		try {
			resultSet.next();
			Double employeeMaximumEarnings = resultSet.getDouble("maximum");
			System.out.println("The highest employee earnings was $"+employeeMaximumEarnings);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	private void executeCustomerPendingFeeSearch() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}

	private void executeCustomerMostLateSearch() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}

	private void executeCustomerLargestRevenueSearch() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
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
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}

	private void executeRentalDueTomorrowSearch() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
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
				case 2:
					System.out.println("Film Managment-Most Popular Films");
					executeMostPopularFilms();
					break;
				case 3:
					System.out.println("Film Managment-Most Popular Caetgory");
					executeMostPopularFilmCategory();
					break;
				case 4:
					System.out.println("Film Managment-Films in Stock");
					executeFilmsInStock();
					break;
				case 5:
					System.out.println("Film Managment-Films Checked Out");
					executeFilmsCheckedOut();
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void executeFilmSearch(String userInput) {
		DAO<Film> dao = new DAO<>(factory);
		Optional<List<Film>> oList = null;
		try {
			oList = dao.readCustomQuery("select f from Film f where f.title LIKE '%" + userInput + "%'", Film.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);
	}

	private void executeMostPopularFilms() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}
	private void executeMostPopularFilmCategory() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}
	private void executeFilmsInStock() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
	}
	private void executeFilmsCheckedOut() {
		// TODO
		/*
		 * DAO<Rental> dao = new DAO<>(factory); Optional<List<Rental>> oList = null;
		 * try { oList =
		 * dao.readCustomQuery("select r from Rental r where r.returnDate IS NOT NULL",
		 * Rental.class); } catch (SQLException e) { e.printStackTrace(); }
		 * DAO.printList(oList);
		 */
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
					System.out.println("Staff Managment-Total Store Revenue: Enter Employee/Store ID:");
					userInput = reader.readLine();
					executeTotalStoreRevenue(userInput);
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
		Optional<List<Staff>> oList = null;
		try {
			oList = dao.readCustomQuery("select s from Staff s where s.lastName LIKE '%" + userInput + "%'",
					Staff.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);

		oList = null;
		try {
			oList = dao.readCustomQuery("select s from Staff s where s.firstName LIKE '%" + userInput + "%'",
					Staff.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.printList(oList);
	}

	private void executeHighestEmployee() {
		String qlString = "select Max(total) as maximum from (SELECT STAFF_ID, Sum(AMOUNT) AS TOTAL FROM Payment GROUP BY STAFF_ID)";
		DAO<Payment> dao = new DAO<>(factory);
		ResultSet resultSet = dao.readSQLQuery(qlString);
		try {
			resultSet.next();
			Double employeeMaximumEarnings = resultSet.getDouble("maximum");
			System.out.println("The highest employee earnings was $"+employeeMaximumEarnings);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void executeTotalStoreRevenue(String userInput) {
		// Using staffId == StoreId
		DAO<Payment> dao = new DAO<>(factory);
		Optional<List<Payment>> oList = null;
		try {
			oList = dao.readCustomQuery("select p from Payment p where p.staffId =" + userInput, Payment.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Payment> paymentList = oList.get();
		BigDecimal sumTotal = BigDecimal.ZERO;
		for (Payment payment : paymentList) {
			sumTotal.add(payment.getAmount());
		}
		System.out.println("Total store revenue is: $" + sumTotal.toString());
	}

	public boolean shouldCont() {
		return cont;
	}

	public void setCont(boolean cont) {
		this.cont = cont;
	}

}
