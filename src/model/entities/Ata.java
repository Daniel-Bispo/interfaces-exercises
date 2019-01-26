/**
 * Ata.java
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
public class Ata {
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ataNumber == null) ? 0 : ataNumber.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userLoggin == null) ? 0 : userLoggin.hashCode());
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
		if (ataNumber == null) {
			if (other.ataNumber != null)
				return false;
		} else if (!ataNumber.equals(other.ataNumber))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id != other.id)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userLoggin == null) {
			if (other.userLoggin != null)
				return false;
		} else if (!userLoggin.equals(other.userLoggin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ata [id=" + id + ", ataNumber=" + ataNumber + ", info=" + info + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", userLoggin=" + userLoggin + "]";
	}	
}
