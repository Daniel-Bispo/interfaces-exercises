package model.entities;

import java.util.Date;

public class Aircraft {
	
	private int id;
	private String aircraft;
	private Date createDate;
	private Date updateDate;
	private String userLoggin;
	
	public Aircraft() {}

	public Aircraft(int id, String aircraft, Date createDate, Date updateDate, String userLoggin) {
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
		result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userLoggin == null) ? 0 : userLoggin.hashCode());
		return result;
	}
}
