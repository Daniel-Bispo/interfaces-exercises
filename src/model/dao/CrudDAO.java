/**
 * CrudDAO.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package model.dao;

import java.util.List;

/**
 * CrudDAO declares all operations with the entities Using type T enables
 * CrudDAO's flexibility. Insert, update and delete any type of object.
 */
public interface CrudDAO<T> {
	
	void insert(T obj);

	void upDate(T obj);

	void deleteById(int id);

	T findById(int id); // Return any type of object

	List<T> findAll(); // Return a list of any type of object
}
