package com.mthree.assignments;

import java.sql.SQLException;
import java.util.Optional;

public interface Crud<T> {
	void create(T t);
	Optional<T> read(long id) throws SQLException;
	void update(long id, String columnName, String value);
	void delete(long id) throws SQLException;

}
