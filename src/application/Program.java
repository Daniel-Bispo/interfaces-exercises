package application;

import java.util.Date;
import java.util.List;

import model.dao.CrudDAO;
import model.dao.DaoFactory;
import model.entities.Question;

public class Program {

	public static void main(String[] args) {

		CrudDAO<Question> questionDAO = DaoFactory.createQuestionDAO();

		/*
		 * TEST 1 - findAll()
		 */
		System.out.println("=== TEST 1 - findAll() ===");
		List<Question> questionList = questionDAO.findAll();

		for (Question question : questionList) {
			System.out.println(question);
		}
		System.out.println("\n");

		int objTest = 1;

		/*
		 * TEST 2 - findById()
		 */
		System.out.println("=== TEST 2 - findById() ===");
		System.out.println(questionDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 3 - insert()
		 */
		System.out.println("=== TEST 3 - insert() ===");
		Question insObj = new Question();

		insObj.setId(999);
		insObj.setDifLevel(2);

		insObj.setAta(DaoFactory.createAtaDAO().findById(4));
		insObj.setAircraft(DaoFactory.createAircraftDAO().findById(3));
		insObj.setCourseEffec(DaoFactory.createCourseEffectivityDAO().findById(2));
		insObj.setEffectivity(DaoFactory.createEffectivityDAO().findById(4));

		insObj.setQuestion("A QUESTION TEST");
		insObj.setCreateDate(new Date().toString());
		insObj.setUpdateDate(null);
		insObj.setUserLoggin("loggin3.log");
		insObj.setApprovedByLoggin("loggin1.log");
		insObj.setActive(true);

		System.out.println("Obj Before: " + insObj + "\n");
		questionDAO.insert(insObj);
		objTest = insObj.getId(); // For the next tests
		System.out.println("Obj after: " + insObj + "\n");
		System.out.println("Database after: " + questionDAO.findById(objTest));
		System.out.println("\n");

		/*
		 * TEST 4 - update()
		 */
		System.out.println("=== TEST 4 - update() ===");
		Question updateObj = questionDAO.findById(objTest);
		System.out.println("Before: " + updateObj + "\n");
		updateObj.setQuestion("THESE LINE HAS BEEN CHANGED");
		updateObj.setAircraft(DaoFactory.createAircraftDAO().findById(5));
		questionDAO.upDate(updateObj);
		System.out.println("After: " + updateObj);
		System.out.println("\n");

		/*
		 * TEST 5 - deleteById()
		 */
		System.out.println("=== TEST 5 - deleteById() ===");
		System.out.println(questionDAO.findById(objTest));
		questionDAO.deleteById(objTest);
		System.out.println("Database contains the object? " + questionDAO.findById(objTest));
	}
}
