/**
 * AircraftDaoJDBC.java
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
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CrudDAO;
import model.entities.Aircraft;

public class AircraftDaoJDBC implements CrudDAO<Aircraft> {

	private Connection conn;

	public AircraftDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aircraft obj) {

		String sql = "INSERT INTO aircraft (aircraft, create_date, update_date, user_loggin) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt = null;

		try {

			/*
			 * Statement.RETURN_GENERATED_KEYS is needed as second parameter to get the key
			 * generated by the database, since it will be used to update the object's id
			 */
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, obj.getAircraft());
			pstmt.setString(2, new Date().toString()); // Set to today always
			pstmt.setString(3, obj.getUpdateDate());
			pstmt.setString(4, obj.getUserLoggin());

			// Get the amount of the inserted row
			int insRows = pstmt.executeUpdate();

			if (insRows > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();

				if (rs.next()) {
					obj.setId(rs.getInt(1)); // Set a new object Id according to database
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unespected error when trying to set a new id for the aircraft!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	/* An new Aircraft object has to be created before. Then use that as the
	 * parameter for this method
	 */
	public void upDate(Aircraft obj) {

		String sql = "UPDATE aircraft SET aircraft=?, create_date=?, update_date=?, user_loggin=? WHERE id=?";

		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getAircraft());
			pstmt.setString(2, obj.getCreateDate());
			pstmt.setString(3, new Date().toString()); // Set to today always
			pstmt.setString(4, obj.getUserLoggin());
			pstmt.setInt(5, obj.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
		}
	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM aircraft WHERE id=?";

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
	 * Returns an Aircraft object.
	 */
	public Aircraft findById(int id) {

		String sql = "SELECT * FROM aircraft WHERE id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return createAircraftObj(rs);
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
	 * Returns a {@code List<Aircraft>} containing all Aircraft objects in database.
	 */
	public List<Aircraft> findAll() {

		List<Aircraft> aircraftList = new ArrayList<>();

		String sql = "SELECT * FROM aircraft ORDER BY aircraft";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				aircraftList.add(createAircraftObj(rs));
			}

			return aircraftList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pstmt);
			DB.closeResultSet(rs);
		}
	}

	// Instantiate an Aircraft object used by findAll() and findById()
	private Aircraft createAircraftObj(ResultSet rs) throws SQLException {

		Aircraft aircraft = new Aircraft();

		aircraft.setId(rs.getInt("id"));
		aircraft.setAircraft(rs.getString("aircraft"));
		aircraft.setCreateDate(rs.getString("create_date"));
		aircraft.setUpdateDate(rs.getString("update_date"));
		aircraft.setUserLoggin(rs.getString("user_loggin"));

		return aircraft;
	}
}
