package com.mthree.assignments;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;



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

	public Optional<List<S>> read(String columnName, String columnValue, Class<S> clazz) throws SQLException{
		//Query query = eManager.createNativeQuery("select * from CITY where CITY.CITY = '" + columnValue + "'", clazz);
		Query query = eManager.createNativeQuery("select * from "+clazz.getSimpleName()+" where "+
				clazz.getSimpleName()+"."+columnName+" = '" + columnValue + "'", clazz);
		
		
	
		System.out.println("select * from "+clazz.getSimpleName().toUpperCase()+" where "+
				clazz.getSimpleName()+"."+columnName+" = '" + columnValue + "'");
		List<S> list = new ArrayList<>();
	
		for(Object result : query.getResultList()) {
			if(clazz.isInstance(result)) {
				list.add((clazz.cast(result)));
			}
		}
		return Optional.of(list);
		//Optional.of(eManager.find(clazz, id));
	}
	
	public void update(long id, String columnName, String setterMethodName, String value, Class<S> clazz) throws Exception{
	/*	S s = eManager.find(clazz, id);
		Method method = clazz.getMethod(setterMethodName, clazz);
		Constructor<?>[] constr = clazz.getConstructors();
		
		//parameters and tyes to constructor
		//method.invoke(new clazz(), value); //Invokes the setter method of the generic class
		
		eManager.getTransaction().begin();
		eManager.merge(s);
		eManager.getTransaction().commit();*/
	}

	
	public void delete(long id, Class<S> clazz) throws SQLException {
		eManager.getTransaction().begin();
		S s = eManager.find(clazz, id);
		eManager.remove(s);
		eManager.getTransaction().commit();
	}
}
