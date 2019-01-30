/**
 * CourseEffectivity.java
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
public final class UserProfile {
	
	private int id;
	private String userProfile;
	
	public UserProfile() {}

	public UserProfile(int id, String userProfile) {
		this.id = id;
		this.userProfile = userProfile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userProfile=" + userProfile + "]";
	}	
}
