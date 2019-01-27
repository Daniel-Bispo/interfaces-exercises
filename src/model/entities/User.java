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
	private int userProfile;
	private boolean active;

	public User() {
	}

	public User(int id, String login, String password, String username, String email, int userProfile, boolean active) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.username = username;
		this.email = email;
		this.active = active;
		this.userProfile = userProfile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(int userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", username=" + username + ", email="
				+ email +  ", userProfile=" + userProfile + ", active=" + active  + "]";
	}
}
