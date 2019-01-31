/**
 * User.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

public final class User {

	private int id;
	private String login;
	private String password;
	private String userName;
	private String email;
	private int userProfile;
	private boolean active;

	public User() {
	}

	public User(int id, String login, String password, String userName, String email, int userProfile,
			boolean active) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", username=" + userName + ", email="
				+ email + ", userProfile=" + userProfile + ", active=" + active + "]";
	}
}
