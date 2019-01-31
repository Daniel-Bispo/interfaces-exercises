/**
 * UserProfileDaoJDBC.java
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CrudDAO;
import model.entities.UserProfile;

public class UserProfileDaoJDBC implements CrudDAO<UserProfile> {

	private Connection conn;

	public UserProfileDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	// A new UserProfile object has to be created before. Then use that as the
	// parameter for this method.
	public void insert(UserProfile obj) {

		String sql = "INSERT INTO user_profile (user_profile) VALUES (?)";

		PreparedStatement pstmt = null;

		try {

			/*
			 * Statement.RETURN_GENERATED_KEYS is needed as second parameter to get the key
			 * generated by the database, since it will be used to update the object's id
			 */
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, obj.getUserProfile());

			// Get the amount of the inserted row
			int insRows = pstmt.executeUpdate();

			if (insRows > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();

				if (rs.next()) {
					obj.setId(rs.getInt(1)); // Set a new object Id according to database
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unespected error when trying to set a new id for the user profile!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	// A new UserProfile object has to be created before. Then use that as the
	// parameter for this method
	public void upDate(UserProfile obj) {

		String sql = "UPDATE user_profile SET user_profile=? WHERE id=?";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getUserProfile());
			pstmt.setInt(2, obj.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM user_profile WHERE id=?";

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
	 * Returns an UserProfile object.
	 */
	public UserProfile findById(int id) {

		String sql = "SELECT * FROM user_profile WHERE id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return createUserProfileObj(rs);
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
	 * Returns a {@code List<UserProfile>} containing all UserProfile objects in database.
	 */
	public List<UserProfile> findAll() {

		List<UserProfile> userProfileList = new ArrayList<>();

		String sql = "SELECT * FROM user_profile ORDER BY user_profile";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				userProfileList.add(createUserProfileObj(rs));
			}

			return userProfileList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}
	}

	// Instantiate an UserProfile object used by findAll()
	private UserProfile createUserProfileObj(ResultSet rs) throws SQLException {

		UserProfile userProfile = new UserProfile();

		userProfile.setId(rs.getInt("id"));
		userProfile.setUserProfile(rs.getString("user_profile"));

		return userProfile;
	}
}
