package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Aircraft;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Aircraft> aircraftDAO = DaoFactory.createAircraftDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<Aircraft> aircraftList = aircraftDAO.findAll();

		for (Aircraft aircraft : aircraftList) {
			System.out.println(aircraft);
		}
		System.out.println("\n");

		int objTest = 3;
		
		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(aircraftDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		Aircraft insObj = new Aircraft();
		insObj.setId(666);
		insObj.setAircraft("77777");	
		System.out.println("Obj Before: " + insObj + "\n");
		aircraftDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + aircraftDAO.findById(insObj.getId()));
		System.out.println("\n");
		
		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		Aircraft updateObj = aircraftDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");		
		updateObj.setAircraft("THESE LINE HAS BEEN CHANGED");
		aircraftDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");
		
		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(aircraftDAO.findById(objTest));
		aircraftDAO.deleteById(objTest);		
		System.out.println("Database contains the object? " + aircraftDAO.findById(objTest));
	}
}
