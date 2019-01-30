/**
 * CourseEffectivity.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

/**
 * Information about engine type, special operation courses or specific courses
 * It means how a course is applicable
 */
public final class CourseEffectivity {

	private int id;
	private String courseEffecInfo;
	private String createDate;
	private String updateDate;
	private String userLoggin;

	public CourseEffectivity() {
	}

	public CourseEffectivity(int id, String courseEffecInfo, String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.courseEffecInfo = courseEffecInfo;
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

	public String getCourseEffecInfo() {
		return courseEffecInfo;
	}

	public void setCourseEffecInfo(String courseEffecInfo) {
		this.courseEffecInfo = courseEffecInfo;
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
		return "CourseEffectivity [id=" + id + ", courseEffecInfo=" + courseEffecInfo + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", userLogin=" + userLoggin + "]";
	}
}
