/**
 * QuestionDaoJDBC.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 28 de jan de 2019
 *  GNU License
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
import model.dao.CrudParametersDAO;
import model.entities.Question;

/**
 * Implementation of CrudParametersDAO for QuestionDaoJDBC entity. It uses JDBC
 * connection only and cannot be extended for safe.
 */
public final class QuestionDaoJDBC implements CrudParametersDAO<Question> {

	private Connection conn;

	public QuestionDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	// A new Question object has to be created before. Then use that as the
	// parameter for this method.
	public void insert(Question obj) {

		String sql = "INSERT INTO questions (ata, aircraft, dif_level, course_effec, effectivity, question,"
				+ " create_date, update_date, user_loggin, approved_by_loggin, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			/*
			 * The id field is filled manually, since it has to have the same Question's id
			 * field
			 */

			pstmt.setInt(1, obj.getAta());
			pstmt.setInt(2, obj.getAircraft());
			pstmt.setInt(3, obj.getDifLevel());
			pstmt.setInt(4, obj.getCourseEffec());
			pstmt.setInt(5, obj.getEffectivity());
			pstmt.setString(6, obj.getQuestion());
			pstmt.setString(7, new Date().toString()); // Set to today always
			pstmt.setString(8, obj.getUpdateDate());
			pstmt.setString(9, obj.getUserLoggin());
			pstmt.setString(10, obj.getApprovedByLoggin());
			pstmt.setString(11, Boolean.toString(obj.isActive()));

			int insRows = pstmt.executeUpdate();

			if (insRows > 0) {

				ResultSet rs = pstmt.getGeneratedKeys();

				if (rs.next()) {
					obj.setId(rs.getInt(1)); // Set a new object Id according to database
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unespected error when trying to set a new id for the question!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	// An new Question object has to be created before. Then use that as the
	// parameter for this method
	public void upDate(Question obj) {

		String sql = "UPDATE questions SET ata=?, aircraft=?, dif_level=?, course_effec=?, effectivity=?, question=?,"
				+ "create_date=?, update_date=?, user_loggin=?, approved_by_loggin=?, active=? WHERE id=?";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, obj.getAta());
			pstmt.setInt(2, obj.getAircraft());
			pstmt.setInt(3, obj.getDifLevel());
			pstmt.setInt(4, obj.getCourseEffec());
			pstmt.setInt(5, obj.getEffectivity());
			pstmt.setString(6, obj.getQuestion());
			pstmt.setString(7, obj.getCreateDate());
			pstmt.setString(8, new Date().toString()); // Set to today always
			pstmt.setString(9, obj.getUserLoggin());
			pstmt.setString(10, obj.getApprovedByLoggin());
			pstmt.setString(11, Boolean.toString(obj.isActive()));
			pstmt.setInt(12, obj.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM questions WHERE id=?";

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
	public Question findById(int id) {

		String sql = "SELECT * FROM questions WHERE id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				return createQuestionObj(rs);
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
	public List<Question> findAll() {

		// A list which contains all Question's elements read from database
		List<Question> questionList = new ArrayList<>();

		String sql = "SELECT * FROM questions ORDER BY id";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				questionList.add(createQuestionObj(rs));
			}

			return questionList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Question> findByParameters(Question obj) {

		List<Question> foundQuestionsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM questions WHERE";

		// This block checks which parameter is set and completes the sql string
		sql += obj.getAta() != 0 ? (" ata=" + obj.getAta()) : "";
		sql += obj.getAircraft() != 0 ? (" AND aircraft=" + obj.getAircraft()) : "";
		sql += obj.getDifLevel() != 0 ? (" AND dif_level=" + obj.getDifLevel()) : "";
		sql += obj.getCourseEffec() != 0 ? (" AND course_effec=" + obj.getCourseEffec()) : "";
		sql += obj.getEffectivity() != 0 ? (" AND effectivity=" + obj.getEffectivity()) : "";
		sql += obj.getCreateDate() != null ? (" AND create_date=" + obj.getCreateDate()) : "";
		sql += obj.getUpdateDate() != null ? (" AND update_date=" + obj.getUpdateDate()) : "";
		sql += obj.getUserLoggin() != null ? (" AND user_loggin=" + obj.getUserLoggin()) : "";
		sql += obj.getApprovedByLoggin() != null ? (" AND approved_by_loggin=" + obj.getApprovedByLoggin()) : "";

		if (sql.length() > 30) {
			sql += " AND active='" + obj.isActive() + "'";
		} else {
			/*
			 * If obj has no other parameter it returns all questions according to active
			 * parameter which default value is true
			 */
			sql = "SELECT * FROM questions WHERE active='" + obj.isActive() + "'";
		}

		sql += obj.getAta() != 0 ? " ORDER BY ata" : "";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				foundQuestionsList.add(createQuestionObj(rs));
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}

		return foundQuestionsList;
	}

	/*
	 * Instantiate a Question object from a ResulSet which is used by findAll() and
	 * findById()
	 */
	private Question createQuestionObj(ResultSet rs) throws SQLException {

		Question question = new Question(rs.getInt("id"), rs.getInt("ata"), rs.getInt("aircraft"),
				rs.getInt("dif_level"), rs.getInt("course_effec"), rs.getInt("effectivity"), rs.getString("question"),
				rs.getString("create_date"), rs.getString("update_date"), rs.getString("user_loggin"),
				rs.getString("approved_by_loggin"), Boolean.valueOf(rs.getString("active")));

		return question;
	}
}
