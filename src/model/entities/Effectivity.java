/**
 * Effectivity.java
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
public class Effectivity {

	private int id;
	private String effecInfo;
	private String createDate;
	private String updateDate;
	private String userLoggin;

	public Effectivity() {
	}

	public Effectivity(int id, String effecInfo, String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.effecInfo = effecInfo;
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

	public String getEffecInfo() {
		return effecInfo;
	}

	public void setEffecInfo(String effecInfo) {
		this.effecInfo = effecInfo;
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
		return "Effectivity [id=" + id + ", effecInfo=" + effecInfo + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", userLoggin=" + userLoggin + "]";
	}
}
