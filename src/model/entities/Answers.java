/**
 * Answers.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 24 de jan de 2019
 *  GNU License
 *
 */
package model.entities;

/**
 * The fields coor_1, corr_2 and corr_3 store which answer is correct
 */
public final class Answers {

	private int id;
	private boolean corr1;
	private String ans1;
	private boolean corr2;
	private String ans2;
	private boolean corr3;
	private String ans3;
	private String createDate;
	private String updateDate;
	private String userLoggin;

	public Answers() {
	}

	public Answers(int id, boolean corr1, String ans1, boolean corr2, String ans2, boolean corr3, String ans3,
			String createDate, String updateDate, String userLoggin) {
		this.id = id;
		this.corr1 = corr1;
		this.ans1 = ans1;
		this.corr2 = corr2;
		this.ans2 = ans2;
		this.corr3 = corr3;
		this.ans3 = ans3;
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

	public boolean isCorr1() {
		return corr1;
	}

	public void setCorr1(boolean corr1) {
		this.corr1 = corr1;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public boolean isCorr2() {
		return corr2;
	}

	public void setCorr2(boolean corr2) {
		this.corr2 = corr2;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public boolean isCorr3() {
		return corr3;
	}

	public void setCorr3(boolean corr3) {
		this.corr3 = corr3;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
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
		return "Answers [id=" + id + ", corr1=" + corr1 + ", ans1=" + ans1 + ", corr2=" + corr2 + ", ans2=" + ans2
				+ ", corr3=" + corr3 + ", ans3=" + ans3 + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", userLoggin=" + userLoggin + "]";
	}
}
