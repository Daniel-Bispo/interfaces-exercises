/**
 * Question.java
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
public class Question {

	private int id;
	private int difLevel;
	private String question;
	private Date createDate;
	private Date updateDate;
	private String userLoggin;
	private String approvedByLoggin;
	private boolean active;
	
	private Answers answers;
	private Ata ata;
	private Aircraft aircraft;
	private CourseEffectivity courseEffec;
	private Effectivity effectivity;
	
	public Question() {}

	public Question(int id, int difLevel, String question, Date createDate, Date updateDate, String userLoggin,
			String approvedByLoggin, boolean active, Answers answers, Ata ata, Aircraft aircraft,
			CourseEffectivity courseEffec, Effectivity effectivity) {
		this.id = id;
		this.difLevel = difLevel;
		this.question = question;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userLoggin = userLoggin;
		this.approvedByLoggin = approvedByLoggin;
		this.active = active;
		this.answers = answers;
		this.ata = ata;
		this.aircraft = aircraft;
		this.courseEffec = courseEffec;
		this.effectivity = effectivity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDifLevel() {
		return difLevel;
	}

	public void setDifLevel(int difLevel) {
		this.difLevel = difLevel;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getApprovedByLoggin() {
		return approvedByLoggin;
	}

	public void setApprovedByLoggin(String approvedByLoggin) {
		this.approvedByLoggin = approvedByLoggin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Answers getAnswers() {
		return answers;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	public Ata getAta() {
		return ata;
	}

	public void setAta(Ata ata) {
		this.ata = ata;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public CourseEffectivity getCourseEffec() {
		return courseEffec;
	}

	public void setCourseEffec(CourseEffectivity courseEffec) {
		this.courseEffec = courseEffec;
	}

	public Effectivity getEffectivity() {
		return effectivity;
	}

	public void setEffectivity(Effectivity effectivity) {
		this.effectivity = effectivity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ata == null) ? 0 : ata.hashCode());
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Question other = (Question) obj;
		if (ata == null) {
			if (other.ata != null)
				return false;
		} else if (!ata.equals(other.ata))
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
}
