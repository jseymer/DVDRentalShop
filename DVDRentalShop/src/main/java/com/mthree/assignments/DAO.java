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
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DAO<S> {
	private EntityManager eManager;

	public DAO(EntityManagerFactory factory) {
		this.eManager = factory.createEntityManager();
	}

	public void create(S s) throws SQLException {
		eManager.getTransaction().begin();
		eManager.persist(s);
		eManager.getTransaction().commit();
	}

	public Optional<List<S>> read(String columnName, String columnValue, Class<S> clazz) throws SQLException {
		String queryString = "select * from " + clazz.getSimpleName() + " where " + clazz.getSimpleName() + "."
				+ columnName + " = '" + columnValue + "'";
		System.out.println("Query executed: " + queryString); // TODO REMOVE PRINT AFTER TESTING
		Query query = eManager.createNativeQuery(queryString, clazz);
		List<S> list = new ArrayList<>();
		for (Object result : query.getResultList()) {
			if (clazz.isInstance(result)) {
				list.add((clazz.cast(result)));
			}
		}
		return Optional.of(list);
	}

	public Optional<List<S>> readCustomQuery(String queryStr, Class<S> clazz) throws SQLException {
		System.out.println("Query executed: " + queryStr); // TODO REMOVE PRINT AFTER TESTING
		TypedQuery<S> typedQuery = eManager.createQuery(queryStr, clazz);
		List<S> list = typedQuery.getResultList();
		return Optional.of(list);
	}

	public ResultSet readSQLQuery(String queryStr){
		Properties prop = new Properties();
		InputStream input = null;
		ResultSet result = null;
		try {
			input = new FileInputStream("sampleProperties.properties");
			prop.load(input);
			//String classForName = prop.getProperty("ClassForName");
			String connectionString = prop.getProperty("ConnectionString");
			String username = prop.getProperty("Username");
			String password = prop.getProperty("Password");
			Connection connection = DriverManager.getConnection(connectionString, username, password);
			Statement stmt = connection.createStatement();

			if (stmt.execute(queryStr)) {
				result = stmt.getResultSet();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
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
		return result;
	}

	public static <T> void printList(Optional<List<T>> oList) {
		List<T> list = oList.get();
		for (T t : list) {
			System.out.println("Result: " + t + "\n");
		}
	}

	public void update(long id, String columnName, String setterMethodName, String value, Class<S> clazz)
			throws Exception {
		/*
		 * S s = eManager.find(clazz, id); Method method =
		 * clazz.getMethod(setterMethodName, clazz); Constructor<?>[] constr =
		 * clazz.getConstructors();
		 * 
		 * //parameters and tyes to constructor //method.invoke(new clazz(), value);
		 * //Invokes the setter method of the generic class
		 * 
		 * eManager.getTransaction().begin(); eManager.merge(s);
		 * eManager.getTransaction().commit();
		 */
	}

	public void delete(long id, Class<S> clazz) throws SQLException {
		/*
		 * eManager.getTransaction().begin(); S s = eManager.find(clazz, id);
		 * eManager.remove(s); eManager.getTransaction().commit();
		 */
	}

	public static void loadPropertiesFile() {
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

	public EntityManager geteManager() {
		return eManager;
	}

	public void seteManager(EntityManager eManager) {
		this.eManager = eManager;
	}
}
