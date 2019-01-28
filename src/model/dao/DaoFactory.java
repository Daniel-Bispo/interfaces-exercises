/**
 * DaoFactory.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  Created on 25 de jan de 2019
 *  GNU License
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
import model.dao.impl.UserDaoJDBC;
import model.dao.impl.UserProfileDaoJDBC;
import model.entities.Aircraft;
import model.entities.Answers;
import model.entities.Ata;
import model.entities.CourseEffectivity;
import model.entities.CourseName;
import model.entities.Effectivity;
import model.entities.User;
import model.entities.UserProfile;

/**
 * It instantiates all implementation of entities DAO. DaoFactory makes DAO more
 * flexible for any type of database management system
 */
public class DaoFactory {

	public static CrudDAO<Ata> createAtaDAO() {
		return new AtaDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<Aircraft> createAircraftDAO() {
		return new AircraftDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<CourseEffectivity> createCourseEffectivityDAO() {
		return new CourseEffectivityDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<Effectivity> createEffectivityDAO() {
		return new EffectivityDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<CourseName> createCourseNameDAO() {
		return new CourseNameDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<UserProfile> createUserProfileDAO() {
		return new UserProfileDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<User> createUserDAO() {
		return new UserDaoJDBC(DB.getConnection());
	}
	
	public static CrudDAO<Answers> createAnswersDAO() {
		return new AnswersDaoJDBC(DB.getConnection());
	}
}
