/**
 * User.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

/**
*
*
*/
public class User {

	private int id;
	private String login;
	private String password;
	private String username;
	private String email;
	private boolean active;

	private UserProfile userProfile;

	public User() {
	}

	public User(int id, String login, String password, String username, String email, boolean active,
			UserProfile userProfile) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.username = username;
		this.email = email;
		this.active = active;
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", username=" + username + ", email="
				+ email + ", active=" + active + ", userProfile=" + userProfile + "]";
	}
}
