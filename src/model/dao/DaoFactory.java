/**
 * DaoFactory.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package model.dao;

import db.DB;
import model.dao.impl.AtaDaoJDBC;
import model.entities.Ata;

/**
* It instantiates all implementation of entities DAO.
* DaoFactory makes DAO more flexible for any type of database management system 
*/
public class DaoFactory {

	public static CrudDAO<Ata> createAtaDAO(){
		return new AtaDaoJDBC(DB.getConnection());
	}
}
