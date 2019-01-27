package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.CourseEffectivity;

public class Program {

	public static void main(String[] args) {

		CrudDAO<CourseEffectivity> courseEffectivityDAO = DaoFactory.createCourseEffectivityDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<CourseEffectivity> courseEffectivityList = courseEffectivityDAO.findAll();

		for (CourseEffectivity courseEffectivity : courseEffectivityList) {
			System.out.println(courseEffectivity);
		}
		System.out.println("\n");

		int objTest = 3;
		
		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(courseEffectivityDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		CourseEffectivity insObj = new CourseEffectivity();
		insObj.setId(666);
		insObj.setCourseEffecInfo("77777");	
		System.out.println("Obj Before: " + insObj + "\n");
		courseEffectivityDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + courseEffectivityDAO.findById(insObj.getId()));
		System.out.println("\n");
		
		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		CourseEffectivity updateObj = courseEffectivityDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");		
		updateObj.setCourseEffecInfo("THESE LINE HAS BEEN CHANGED");
		courseEffectivityDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");
		
		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(courseEffectivityDAO.findById(objTest));
		courseEffectivityDAO.deleteById(objTest);		
		System.out.println("Database contains the object? " + courseEffectivityDAO.findById(objTest));
	}
}
