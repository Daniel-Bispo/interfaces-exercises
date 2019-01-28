package application;

import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Answers;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Answers> answersDAO = DaoFactory.createAnswersDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<Answers> answersList = answersDAO.findAll();

		for (Answers answers : answersList) {
			System.out.println(answers);
		}
		System.out.println("\n");

		int objTest = 1;

		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(answersDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		Answers insObj = new Answers();

		insObj.setId(3656);
		insObj.setCorr1(true);
		insObj.setAns1("Answer 1 test");
		insObj.setCorr2(false);
		insObj.setAns2("Answer 2 test");
		insObj.setCorr3(false);
		insObj.setAns3("Answer 3 test");
		insObj.setUserLoggin(DaoFactory.createUserDAO().findById(2));

		System.out.println("Obj Before: " + insObj + "\n");
		answersDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + answersDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		Answers updateObj = answersDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");
		updateObj.setAns1("THESE LINE HAS BEEN CHANGED");
		updateObj.setAns2("THESE LINE HAS BEEN CHANGED");
		updateObj.setAns3("THESE LINE HAS BEEN CHANGED");
		answersDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");

		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(answersDAO.findById(objTest));
		answersDAO.deleteById(objTest);
		System.out.println("Database contains the object? " + answersDAO.findById(objTest));
	}
}
