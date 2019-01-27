package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Effectivity;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Effectivity> effectivityDAO = DaoFactory.createEffectivityDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<Effectivity> effectivityList = effectivityDAO.findAll();

		for (Effectivity effectivity : effectivityList) {
			System.out.println(effectivity);
		}
		System.out.println("\n");

		int objTest = 3;

		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(effectivityDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		Effectivity insObj = new Effectivity();
		insObj.setId(666);
		insObj.setEffecInfo("77777");
		System.out.println("Obj Before: " + insObj + "\n");
		effectivityDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + effectivityDAO.findById(insObj.getId()));
		System.out.println("\n");

		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		Effectivity updateObj = effectivityDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");
		updateObj.setEffecInfo("THESE LINE HAS BEEN CHANGED");
		effectivityDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");

		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(effectivityDAO.findById(objTest));
		effectivityDAO.deleteById(objTest);
		System.out.println("Database contains the object? " + effectivityDAO.findById(objTest));
	}
}
