package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.UserProfile;

public class Program {

	public static void main(String[] args) {

		CrudDAO<UserProfile> userProfileDAO = DaoFactory.createUserProfileDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<UserProfile> userProfileList = userProfileDAO.findAll();

		for (UserProfile userProfile : userProfileList) {
			System.out.println(userProfile);
		}
		System.out.println("\n");

		int objTest = 2;

		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(userProfileDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		UserProfile insObj = new UserProfile();
		insObj.setId(666);
		insObj.setUserProfile("77777");
		System.out.println("Obj Before: " + insObj + "\n");
		userProfileDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + userProfileDAO.findById(insObj.getId()));
		System.out.println("\n");

		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		UserProfile updateObj = userProfileDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");
		updateObj.setUserProfile("THESE LINE HAS BEEN CHANGED");
		userProfileDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");

		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(userProfileDAO.findById(objTest));
		userProfileDAO.deleteById(objTest);
		System.out.println("Database contains the object? " + userProfileDAO.findById(objTest));
	}
}
