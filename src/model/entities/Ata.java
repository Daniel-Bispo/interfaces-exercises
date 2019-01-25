/**
 * Ata.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

import java.util.Date;

/**
*
*
*/
public class Ata {
	
	private int id;
	private int ataNumber;
	private String info;
	private Date createDate;
	private Date updateDate;
	private String userLoggin;
	
	public Ata() {}

	public Ata(int id, int ataNumber, String info, Date createDate, Date updateDate, String userLoggin) {
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

	public int getAtaNumber() {
		return ataNumber;
	}

	public void setAtaNumber(int ataNumber) {
		this.ataNumber = ataNumber;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserLoggin() {
		return userLoggin;
	}

	public void setUserLoggin(String userLoggin) {
		this.userLoggin = userLoggin;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ataNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ata other = (Ata) obj;
		if (ataNumber != other.ataNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ata [id=" + id + ", ataNumber=" + ataNumber + ", info=" + info + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", userLoggin=" + userLoggin + "]";
	}
}
