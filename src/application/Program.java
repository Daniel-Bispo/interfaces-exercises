package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Ata;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Ata> ataDAO = DaoFactory.createAtaDAO();
		
		List<Ata> ataList = ataDAO.findAll();
		
		for(Ata ata : ataList) {
			System.out.println(ata);
		}

	}

}
