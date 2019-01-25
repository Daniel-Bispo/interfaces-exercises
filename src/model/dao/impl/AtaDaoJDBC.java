/**
 * AtaDaoJDBC.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
 *
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import db.DbException;
import model.dao.CrudDAO;
import model.entities.Ata;

/**
 * Implementation of CrudDAO for Ata entity. It uses JDBC connection only.
 */
public class AtaDaoJDBC implements CrudDAO<Ata> {

	private Connection conn;

	public AtaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Ata obj) {
	}

	@Override
	public void upDate(Ata obj) {
	}

	@Override
	public void deleteById(Ata obj) {
	}

	@Override
	public Ata findById(int id) {

		return null;
	}

	@Override
	public List<Ata> findAll() {

		// A list which contains all Ata elements read from database
		List<Ata> ataList = new ArrayList<>();
		
		String sql = "SELECT * FROM ata ORDER BY ata_number";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// It uses a Set to sort all object before store them into the return list
			Set<Ata> ataSet = new TreeSet<>();

			while (rs.next()) {
				
				Ata ataObj = createAtaObj(rs);
				
				// Check whether an element is into the set to prevent rewrite it
				if(!ataSet.contains(ataObj)) {
					ataSet.add(ataObj);
				}				
			}
			
			// Fill the return list with sorted objects
			for(Ata ata : ataSet) {
				ataList.add(ata);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return ataList;
	}

	// Instantiate an Ata object used by findAll()
	private Ata createAtaObj(ResultSet rs) throws SQLException{

		Ata ata = new Ata();

			ata.setId(rs.getInt("id"));
			ata.setAtaNumber(rs.getInt("ata_number"));
			ata.setInfo(rs.getString("info"));
			ata.setCreateDate(rs.getDate("create_date"));
			ata.setUpdateDate(rs.getDate("update_date"));
			ata.setUserLoggin(rs.getString("user_loggin"));

		return ata;
	}
}
