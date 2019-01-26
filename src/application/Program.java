package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Aircraft;
import model.entities.Ata;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Ata> ataDAO = DaoFactory.createAtaDAO();
//
//		List<Ata> ataList = ataDAO.findAll();
//
//		for (Ata ata : ataList) {
//			System.out.println(ata);
//		}

		int del = 29;
//
//		System.out.println(ataDAO.findById(del));
//		
//		CrudDAO<Ata> ataDAO = DaoFactory.createAtaDAO();
//		ataDAO.deleteById(del);
//		
//		System.out.println(ataDAO.findById(del));
		
		Ata delObj = ataDAO.findById(del);
		System.out.println("Before: " + delObj + "\n");
		
		delObj.setAtaNumber("9999");
		delObj.setInfo("THESE LINE HAS BEEN CHANGED");
		
		ataDAO.upDate(delObj);
		
		System.out.println("After: " + delObj);
	}
}
