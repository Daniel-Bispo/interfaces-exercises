/**
 * CrudDAO.java
 *
 *  @author Daniel Bispo <danielvbispo@outlook.com>
 *  
 *  Created in 2019
 *
 */
package model.dao;

import java.util.List;

/** 
 * Interfaces all common methods with each model.dao.impl entity to connect to the database.
 * 
 * <p><u>These are the common methods:</u></p>
 * <blockquote>
 * 		<li>insert(T obj)</li>
 * 		<li>upDate(T obj)</li>
 * 		<li>deleteById(int id)</li>
 * 		<li>findById(int id)</li>
 * 		<li>findAll()</li>
 * </blockquote>
 * 
 * @param T obj -> an object type T could be: 
 * 		<li>{@link model.entities.Aircraft}</li>
 * 		<li>{@link model.entities.Answers}</li>
 * 		<li>{@link model.entities.Ata}</li>
 * 		<li>{@link model.entities.CourseEffectivity}</li>
 * 		<li>{@link model.entities.CourseName}</li>
 * 		<li>{@link model.entities.Effectivity}</li>
 * 		<li>{@link model.entities.Question}</li>
 * 		<li>{@link model.entities.User}</li>
 * 		<li>{@link model.entities.UserProfile}</li><p>
 * 
 * @return Each method returns its specific connection.
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
public interface CrudDAO<T> {
	/* Each method is detailed into its implementation */

	void insert(T obj);

	void upDate(T obj);

	void deleteById(int id);

	T findById(int id);

	List<T> findAll();
}
