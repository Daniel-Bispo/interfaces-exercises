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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		String sql = "SELECT * FROM ata ORDER BY ata_number";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<Ata> ataList = new ArrayList<>();
			Map<Integer, Ata> ataMap = new HashMap<>();

			while (rs.next()) {

				Ata newAtaListItem = ataMap.get(rs.getInt("ata_number")); //Needed to sort the Map

				if (newAtaListItem == null) {
					newAtaListItem = createAtaObj(rs);
					ataMap.put(rs.getInt("id"), newAtaListItem);
				}
				
				ataList.add(newAtaListItem);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return null;
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
