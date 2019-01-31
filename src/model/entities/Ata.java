/**
 * Ata.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

public final class Ata {
	
	private int id;
	private String ataNumber;
	private String info;
	private String createDate;
	private String updateDate;
	private String userLoggin;
	
	public Ata() {}

	public Ata(int id, String ataNumber, String info, String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.ataNumber = ataNumber;
		this.info = info;
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

	public String getAtaNumber() {
		return ataNumber;
	}

	public void setAtaNumber(String ataNumber) {
		this.ataNumber = ataNumber;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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
		return "Ata [id=" + id + ", ataNumber=" + ataNumber + ", info=" + info + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", userLoggin=" + userLoggin + "]";
	}	
}
