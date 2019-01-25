package model.entities;

import java.util.Date;

public class Effectivity {
	
	private int id;
	private String effecInfo;
	private Date createDate;
	private Date updateDate;
	private String userLoggin;
	
	public Effectivity() {}

	public Effectivity(int id, String effecInfo, Date createDate, Date updateDate, String userLoggin) {
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
	public String toString() {
		return "Effectivity [id=" + id + ", effecInfo=" + effecInfo + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", userLoggin=" + userLoggin + "]";
	}
}
