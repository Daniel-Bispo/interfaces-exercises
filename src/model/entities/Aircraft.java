/**
 * Aircraft.java
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
public class Aircraft {

	private int id;
	private String aircraft;
	private String createDate;
	private String updateDate;
	private String userLoggin;

	public Aircraft() {
	}

	public Aircraft(int id, String aircraft, String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.aircraft = aircraft;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userLoggin = userLoggin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserLoggin() {
		return userLoggin;
	}

	public void setUserLoggin(String userLoggin) {
		this.userLoggin = userLoggin;
	}

	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", aircraft=" + aircraft + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", userLoggin=" + userLoggin + "]";
	}
}
