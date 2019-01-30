/**
 * CrudParametersDAO.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 30 de jan de 2019
 *  GNU License
 *
 */
package model.dao;

import java.util.List;

/**
 * It's a variation of CrudDao which allows to find an object by a combination
 * of ata, aircraft, dif_level and others
 */
public interface CrudParametersDAO<T> extends CrudDAO<T> {

	// It can use any field to find an object
	List<T> findByParameters(T obj);
}
