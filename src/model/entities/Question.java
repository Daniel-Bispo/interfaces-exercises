/**
 * Question.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

/**
 *
 * The class and fields are final to ensure that class can't be mutable
 */
public final class Question {

	private int id;
	private int ata;
	private int aircraft;
	private int difLevel;
	private int courseEffec;
	private int effectivity;
	private String question;
	private String createDate;
	private String updateDate;
	private String userLoggin;
	private String approvedByLoggin;
	private boolean active = true;

	public Question() {
	}

	public Question(int id, int ata, int aircraft, int difLevel, int courseEffec, int effectivity, String question,
			String createDate, String updateDate, String userLoggin, String approvedByLoggin, boolean active) {
		this.id = id;
		this.ata = ata;
		this.aircraft = aircraft;
		this.difLevel = difLevel;
		this.courseEffec = courseEffec;
		this.effectivity = effectivity;
		this.question = question;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userLoggin = userLoggin;
		this.approvedByLoggin = approvedByLoggin;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAta() {
		return ata;
	}

	public void setAta(int ata) {
		this.ata = ata;
	}

	public int getAircraft() {
		return aircraft;
	}

	public void setAircraft(int aircraft) {
		this.aircraft = aircraft;
	}

	public int getDifLevel() {
		return difLevel;
	}

	public void setDifLevel(int difLevel) {
		this.difLevel = difLevel;
	}

	public int getCourseEffec() {
		return courseEffec;
	}

	public void setCourseEffec(int courseEffec) {
		this.courseEffec = courseEffec;
	}

	public int getEffectivity() {
		return effectivity;
	}

	public void setEffectivity(int effectivity) {
		this.effectivity = effectivity;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + aircraft;
		result = prime * result + ((approvedByLoggin == null) ? 0 : approvedByLoggin.hashCode());
		result = prime * result + ata;
		result = prime * result + courseEffec;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + difLevel;
		result = prime * result + effectivity;
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Question other = (Question) obj;
		if (active != other.active)
			return false;
		if (aircraft != other.aircraft)
			return false;
		if (approvedByLoggin == null) {
			if (other.approvedByLoggin != null)
				return false;
		} else if (!approvedByLoggin.equals(other.approvedByLoggin))
			return false;
		if (ata != other.ata)
			return false;
		if (courseEffec != other.courseEffec)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (difLevel != other.difLevel)
			return false;
		if (effectivity != other.effectivity)
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
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
		return "Question [id=" + id + ", ata=" + ata + ", aircraft=" + aircraft + ", difLevel=" + difLevel
				+ ", courseEffec=" + courseEffec + ", effectivity=" + effectivity + ", question=" + question
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", userLoggin=" + userLoggin
				+ ", approvedByLoggin=" + approvedByLoggin + ", active=" + active + "]";
	}
}
