package model.entities;

import java.util.Date;

public class CourseName {

	private int id;
	private String course;
	private Date createDate;
	private Date updateDate;
	private String user;

	public CourseName() {
	}

	public CourseName(int id, String course, Date createDate, Date updateDate, String user) {
		this.id = id;
		this.course = course;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CourseName [id=" + id + ", course=" + course + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", user=" + user + "]";
	}
}
