/**
 * DaoFactory.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *
 *  Created in 2019
 *  
 */
package model.dao;

import db.DB;
import model.dao.impl.AircraftDaoJDBC;
import model.dao.impl.AnswersDaoJDBC;
import model.dao.impl.AtaDaoJDBC;
import model.dao.impl.CourseEffectivityDaoJDBC;
import model.dao.impl.CourseNameDaoJDBC;
import model.dao.impl.EffectivityDaoJDBC;
import model.dao.impl.QuestionDaoJDBC;
import model.dao.impl.UserDaoJDBC;
import model.dao.impl.UserProfileDaoJDBC;
import model.entities.Aircraft;
import model.entities.Answers;
import model.entities.Ata;
import model.entities.CourseEffectivity;
import model.entities.CourseName;
import model.entities.Effectivity;
import model.entities.Question;
import model.entities.User;
import model.entities.UserProfile;

/** 
 * Connects the entity class to the database.
 * 
 * <p><u>These are the static methods:</u></p>
 * <blockquote>
 * 		<li>createAtaDAO()</li>
 * 		<li>createAircraftDAO()</li>
 * 		<li>createCourseEffectivityDAO()</li>
 * 		<li>createEffectivityDAO()</li>
 * 		<li>createCourseNameDAO()</li>
 * 		<li>createUserProfileDAO()</li>
 * 		<li>createUserDAO()</li>
 * 		<li>createAnswersDAO()</li>
 * 		<li>createQuestionDAO()</li>
 * </blockquote>
 * 
 * @return Each method returns its specific database connection.
 * 
 * @see <li>{@link model.dao.impl.AtaDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.AircraftDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.CourseEffectivityDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.EffectivityDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.CourseNameDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.UserProfileDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.UserDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.AnswersDaoJDBC}</li>
 * 		<li>{@link model.dao.impl.QuestionDaoJDBC}</li>
 */
public class DaoFactory {
	
	/**
	 * Implements the Ata class' methods of interaction with database.<br>
	 * Returns AtaDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <Ata> objDAO = DaoFactory.createAtaDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(Ata obj)</li>
	 * 		<li>upDate(Ata obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new AtaDaoJDBC represented by this object.
	 */
	public static CrudDAO<Ata> createAtaDAO() {
		return new AtaDaoJDBC(DB.getConnection());
	}
	

	/**
	 * Implements the Aircraft class' methods of interaction with database.<br>
	 * Returns AircraftDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <Aircraft> objDAO = DaoFactory.createAircraftDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(Aircraft obj)</li>
	 * 		<li>upDate(Aircraft obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new AircraftDaoJDBC represented by this object.
	 */
	public static CrudDAO<Aircraft> createAircraftDAO() {
		return new AircraftDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the CourseEffectivity class' methods of interaction with database.<br>
	 * Returns CourseEffectivityDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <CourseEffectivity> objDAO = DaoFactory.createCourseEffectivityDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(CourseEffectivity obj)</li>
	 * 		<li>upDate(CourseEffectivity obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new CourseEffectivityDaoJDBC represented by this object.
	 */
	public static CrudDAO<CourseEffectivity> createCourseEffectivityDAO() {
		return new CourseEffectivityDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the Effectivity class' methods of interaction with database.<br>
	 * Returns EffectivityDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <Effectivity> objDAO = DaoFactory.createEffectivityDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(Effectivity obj)</li>
	 * 		<li>upDate(Effectivity obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new EffectivityDaoJDBC represented by this object.
	 */
	public static CrudDAO<Effectivity> createEffectivityDAO() {
		return new EffectivityDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the CourseName class' methods of interaction with database.<br>
	 * Returns CourseNameDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <CourseName> objDAO = DaoFactory.createCourseNameDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(CourseName obj)</li>
	 * 		<li>upDate(CourseName obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new CourseNameDaoJDBC represented by this object.
	 */
	public static CrudDAO<CourseName> createCourseNameDAO() {
		return new CourseNameDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the UserProfile class' methods of interaction with database.<br>
	 * Returns UserProfileDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <UserProfile> objDAO = DaoFactory.createUserProfileDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(UserProfile obj)</li>
	 * 		<li>upDate(UserProfile obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new UserProfileDaoJDBC represented by this object.
	 */
	public static CrudDAO<UserProfile> createUserProfileDAO() {
		return new UserProfileDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the User class' methods of interaction with database.<br>
	 * Returns UserDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <User> objDAO = DaoFactory.createUserDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(User obj)</li>
	 * 		<li>upDate(User obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new UserDaoJDBC represented by this object.
	 */
	public static CrudDAO<User> createUserDAO() {
		return new UserDaoJDBC(DB.getConnection());
	}

	
	/**
	 * Implements the Answers class' methods of interaction with database.<br>
	 * Returns AnswersDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <Answers> objDAO = DaoFactory.createAnswersDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(Answers obj)</li>
	 * 		<li>upDate(Answers obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * </blockquote>
	 * 
	 * @return A new AnswersDaoJDBC represented by this object.
	 */
	public static CrudDAO<Answers> createAnswersDAO() {
		return new AnswersDaoJDBC(DB.getConnection());
	}
	
	
	/**
	 * Implements the Question class' methods of interaction with database.<br>
	 * Returns QuestionDaoJDBC.<p> 
	 *   
	 * <u>An example of instantiation</u>:
	 * <blockquote>
	 * {@code CrudDAO <Question> objDAO = DaoFactory.createQuestionDAO()};
	 * </blockquote>
	 * 
	 * <u>These are its methods:<p></u>
	 * <blockquote>
	 * 		<li>insert(Question obj)</li>
	 * 		<li>upDate(Question obj)</li>
	 * 		<li>deleteById(int id)</li>
	 * 		<li>findById(int id)</li>
	 * 		<li>findAll()</li>
	 * 		<li>findByParameters(Question obj)</li>
	 * </blockquote>
	 * 
	 * @return A new QuestionDaoJDBC represented by this object.
	 */
	public static CrudDAO<Question> createQuestionDAO() {
		return new QuestionDaoJDBC(DB.getConnection());
	}
}
