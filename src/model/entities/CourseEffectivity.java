/**
 * CourseEffectivity.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

import java.util.Date;

/**
 * Information about engine type, special operation courses or specific courses
 * It means how a course is applicable
 */
public class CourseEffectivity {

	private int id;
	private String courseEffecInfo;
	private Date createDate;
	private Date updateDate;
	private String userLogin;

	public CourseEffectivity() {
	}

	public CourseEffectivity(int id, String courseEffecInfo, Date createDate, Date updateDate, String userLogin) {
		this.id = id;
		this.courseEffecInfo = courseEffecInfo;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userLogin = userLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseEffecInfo() {
		return courseEffecInfo;
	}

	public void setCourseEffecInfo(String courseEffecInfo) {
		this.courseEffecInfo = courseEffecInfo;
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

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@Override
	public String toString() {
		return "CourseEffectivity [id=" + id + ", courseEffecInfo=" + courseEffecInfo + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", userLogin=" + userLogin + "]";
	}
}
