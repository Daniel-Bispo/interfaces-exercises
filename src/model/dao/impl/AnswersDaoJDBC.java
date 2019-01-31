/**
 * AnswersDaoJDBC.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  
 *  Created in 2019
 *
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CrudDAO;
import model.entities.Answers;

public class AnswersDaoJDBC implements CrudDAO<Answers> {

	private Connection conn;

	public AnswersDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	/* A new Answers object has to be created before. Then use that as the
	 * parameter for this method.
	 */
	public void insert(Answers obj) {

		String sql = "INSERT INTO answers (id, corr_1, ans_1, corr_2, ans_2, corr_3, ans_3, create_date, update_date, user_loggin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			// The id field is filled manually, since it has to have the same Question object's id

			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, String.valueOf(obj.isCorr1()));
			pstmt.setString(3, obj.getAns1());
			pstmt.setString(4, String.valueOf(obj.isCorr2()));
			pstmt.setString(5, obj.getAns2());
			pstmt.setString(6, String.valueOf(obj.isCorr3()));
			pstmt.setString(7, obj.getAns3());
			pstmt.setString(8, new Date().toString()); // Set to today always
			pstmt.setString(9, obj.getUpdateDate());
			pstmt.setString(10, obj.getUserLoggin());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	// An new Answers object has to be created before. Then use that as the
	// parameter for this method
	public void upDate(Answers obj) {

		String sql = "UPDATE answers SET corr_1=?, ans_1=?, corr_2=?, ans_2=?, corr_3=?, ans_3=?, create_date=?, update_date=?, user_loggin=? WHERE id=?";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, String.valueOf(obj.isCorr1()));
			pstmt.setString(2, obj.getAns1());
			pstmt.setString(3, String.valueOf(obj.isCorr2()));
			pstmt.setString(4, obj.getAns2());
			pstmt.setString(5, String.valueOf(obj.isCorr3()));
			pstmt.setString(6, obj.getAns3());
			pstmt.setString(7, obj.getCreateDate().toString());
			pstmt.setString(8, new Date().toString()); // Set to today always
			pstmt.setString(9, obj.getUserLoggin());
			pstmt.setInt(10, obj.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM answers WHERE id=?";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	/**
	 * Returns an Answers object.
	 */
	public Answers findById(int id) {

		String sql = "SELECT * FROM answers WHERE id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				return createAnswersObj(rs);
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}
	}

	@Override
	/**
	 * Returns a {@code List<Answers>} containing all Answers objects in database.
	 */
	public List<Answers> findAll() {

		List<Answers> answersList = new ArrayList<>();

		String sql = "SELECT * FROM answers ORDER BY id";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				answersList.add(createAnswersObj(rs));
			}

			return answersList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}
	}

	// Instantiate an Answers object used by findAll()
	private Answers createAnswersObj(ResultSet rs) throws SQLException {

		Answers answers = new Answers();

		answers.setId(rs.getInt("id"));
		answers.setCorr1(Boolean.valueOf(rs.getString("corr_1")));
		answers.setAns1(rs.getString("ans_1"));
		answers.setCorr2(Boolean.valueOf(rs.getString("corr_2")));
		answers.setAns2(rs.getString("ans_2"));
		answers.setCorr3(Boolean.valueOf(rs.getString("corr_3")));
		answers.setAns3(rs.getString("ans_3"));
		answers.setCreateDate(rs.getString("create_date"));
		answers.setUpdateDate(rs.getString("update_date"));
		answers.setUserLoggin(rs.getString("user_loggin"));

		return answers;
	}
}
