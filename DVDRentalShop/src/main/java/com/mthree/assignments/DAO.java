package com.mthree.assignments;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAO<S>{
	private EntityManager eManager;
	
	public DAO (EntityManagerFactory factory) {
		this.eManager = factory.createEntityManager();
	}

	
	public void create(S s) throws SQLException{
		eManager.getTransaction().begin();
		eManager.persist(s);
		eManager.getTransaction().commit();
	}

	public Optional<S> read(long id, Class<S> clazz) throws SQLException{
		return Optional.of(eManager.find(clazz, id));
	}
	
	public void update(long id, String columnName, String setterMethodName, String value, Class<S> clazz) throws Exception{
		S s = eManager.find(clazz, id);
		Method method = clazz.getMethod(setterMethodName, clazz);
		Constructor<?>[] constr = clazz.getConstructors();
		
		//parameters and tyes to constructor
		//method.invoke(new clazz(), value); //Invokes the setter method of the generic class
		
		eManager.getTransaction().begin();
		eManager.merge(s);
		eManager.getTransaction().commit();
	}

	
	public void delete(long id, Class<S> clazz) throws SQLException {
		eManager.getTransaction().begin();
		S s = eManager.find(clazz, id);
		eManager.remove(s);
		eManager.getTransaction().commit();
	}
}
