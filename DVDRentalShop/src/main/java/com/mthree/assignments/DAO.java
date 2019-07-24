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
import javax.persistence.TypedQuery;

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
		Query query = eManager.createNativeQuery("select * from "+clazz.getSimpleName()+" where "+
				clazz.getSimpleName()+"."+columnName+" = '" + columnValue + "'", clazz);
		List<S> list = new ArrayList<>();
		for(Object result : query.getResultList()) {
			if(clazz.isInstance(result)) {
				list.add((clazz.cast(result)));
			}
		}
		return Optional.of(list);
	}
	
	public Optional<List<S>> readCustomQuery(String queryStr, Class<S> clazz) throws SQLException{
		System.out.println("Query executed: " + queryStr); //TODO REMOVE PRINT AFTER TESTING
		TypedQuery<S> typedQuery = eManager.createQuery(queryStr, clazz);  
		List<S> list = typedQuery.getResultList();
		return Optional.of(list);
	}
	
	public static <T> void printList(Optional<List<T>> oList){
		List<T> list = oList.get();
		for(T t : list) {
			System.out.println("Result: "+ t + "\n");
		}
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
		/*eManager.getTransaction().begin();
		S s = eManager.find(clazz, id);
		eManager.remove(s);
		eManager.getTransaction().commit();*/
	}
}
