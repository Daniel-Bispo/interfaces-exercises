/**
 * DbIntegrityException.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package db;

/**
 * It throws DataBase integrity exception: any DB register deletion which has
 * connection with another DB table
 */
public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) {
		super(msg);
	}
}
