/**
 * CourseName.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

public final class CourseName {

	private int id;
	private String course;
	private String createDate;
	private String updateDate;
	private String userLoggin;

	public CourseName() {
	}

	public CourseName(int id, String course, String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.course = course;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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
		return "CourseName [id=" + id + ", course=" + course + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", user=" + userLoggin + "]";
	}
}
