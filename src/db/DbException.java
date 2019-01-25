/**
 * DdException.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package db;

/**
 * It throws all exceptions occurred during DataBase connections
 */
public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
}
