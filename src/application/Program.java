package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.User;

public class Program {

	public static void main(String[] args) {

		CrudDAO<User> userDAO = DaoFactory.createUserDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<User> userList = userDAO.findAll();

		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("\n");

		int objTest = 2;

		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(userDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		User insObj = new User();
		
		insObj.setId(666);
		insObj.setLogin("loggin4.log");
		insObj.setPassword("logginPass");
		insObj.setUserName("Loggin4 Log");
		insObj.setEmail("loggin145@email.com");			
		insObj.setUserProfile(DaoFactory.createUserProfileDAO().findById(5));;
		insObj.setActive(true);
		
		System.out.println("Obj Before: " + insObj + "\n");
		userDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + userDAO.findById(insObj.getId()));
		System.out.println("\n");

		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		User updateObj = userDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");
		updateObj.setUserName("THESE LINE HAS BEEN CHANGED");
		userDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");

		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(userDAO.findById(objTest));
		userDAO.deleteById(objTest);
		System.out.println("Database contains the object? " + userDAO.findById(objTest));
	}
}
