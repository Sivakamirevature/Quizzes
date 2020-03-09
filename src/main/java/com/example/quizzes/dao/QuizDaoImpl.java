package com.example.quizzes.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.model.Quiz;

@Repository
public class QuizDaoImpl implements IQuizDao {
	@Autowired
	SessionFactory sessionFactory;
	
	Transaction transaction;
	@Override
	public List<Quiz> getAllQuizzes() throws DBExceptions {
		DBExceptions dbExceptions = new DBExceptions();
		List<Quiz> quizzes = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			TypedQuery<Quiz> query = session.createQuery("from Quiz");
			quizzes = ((org.hibernate.query.Query) query).list();
			System.out.println("Checking: "+ quizzes.get(0).getQuizQuestionObj().get(0).getQuestion().getContent());
			if (quizzes.isEmpty()) {
				System.out.println("quizzes list is: " + quizzes);
				dbExceptions.IDNotFound("Given Id is not found");
			}
		} catch (NullPointerException e) {
			dbExceptions.IDNotFound("Nothing will fetched", e);
		}
		return quizzes;
	}

	@Override
	public List<Quiz> getQuizByID(int id) throws DBExceptions {
		DBExceptions dbExceptions = new DBExceptions();
		List<Quiz> quizzesList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "From Quiz where quiz_id=:id";
			TypedQuery<Quiz> query = (TypedQuery<Quiz>) session.createQuery(queryString);
			query.setParameter("id", id);
			quizzesList = ((org.hibernate.query.Query) query).list();
			if (quizzesList.isEmpty()) {
				System.out.println("quizzes list is: " + quizzesList);
				dbExceptions.IDNotFound("Given Id is not found");
			}
		} catch (NullPointerException e) {
			dbExceptions.IDNotFound("Given Id is not found", e);
		} catch (Exception e) {
			throw new DBExceptions("Exceptions", e);
		}
		return quizzesList;
	}

	@Override
	public Quiz createQuiz(Quiz quiz) throws DBExceptions {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			// LOGGER.info("time is now: "+ts);
			quiz.setCreated_on(ts);
			session.save(quiz);
			transaction.commit();
		} catch (Exception e) {
			throw new DBExceptions("Inserting the data failed", e);
		} finally {
			session.close();
		}
		return quiz;
	}

	@Override
	public int DeleteAllQuizzes() {
		Session session = null;
		DBExceptions dbExceptions = new DBExceptions();
		int id = 0;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("truncate table Quiz");
			id = query.executeUpdate();
		} catch (NullPointerException e) {
			dbExceptions.IDNotFound("Nothing will deleted");
		}
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public int deleteById(int qid) {
		Session session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		String hql = "delete Quiz where id = :id";
		org.hibernate.query.Query q = session.createQuery(hql).setParameter("id", qid);
		int id = q.executeUpdate();
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Quiz updateById(Quiz quiz) throws DBExceptions {
		Session session = null;
		int id = 0;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			id = quiz.getQuiz_id();
			System.out.println("id Count1" + id);
			int modified_count = ((Integer) session
					.createSQLQuery("SELECT modified_count from quiz_settings where quiz_id=" + id + " LIMIT 1")
					.uniqueResult()).intValue();
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			quiz.setModified_on(ts);
			quiz.setModified_count(++(modified_count));

			session.saveOrUpdate(quiz);
			transaction.commit();
		} catch (NullPointerException e) {
			throw new DBExceptions("Cannot Find the id", e);
		} finally {
			session.close();
		}
		return quiz;
	}

	@Override
	public int activeDeactiveQuiz(int qid) throws DBExceptions {
		Session session = null;
		int id;
		String hql;
		byte status;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			status = ((Byte) session
					.createSQLQuery("SELECT status from quiz_settings where quiz_id=" + qid + " LIMIT 1")
					.uniqueResult()).byteValue();
			if (status == 1) {
				hql = "Update Quiz set status = 0 where id = :id";
			} else {
				hql = "Update Quiz set status = 1 where id = :id";
			}
			org.hibernate.query.Query q = session.createQuery(hql).setParameter("id", qid);
			id = q.executeUpdate();
			transaction.commit();
		} catch (NullPointerException e) {
			throw new DBExceptions("Cannot Find the id", e);
		} finally {
			session.close();
		}
		return id;
	}

	/*
	 * @Override public List<Quiz> cloneQuiz(int id) throws DBExceptions {
	 * List<Quiz> quizzesList = null; quizzesList = getQuizByID(id); quiz =
	 * quizzesList.get(0); try { Session session =
	 * sessionFactory.getCurrentSession(); transaction = session.beginTransaction();
	 * session.evict(quiz); // quiz.setId(null); quiz.setCreated_by("Sivakami");
	 * session.save(quiz); transaction.commit(); } catch (NullPointerException e) {
	 * throw new DBExceptions("Due to id mismatch cant do the clone operation", e);
	 * } return quizzesList; }
	 */

	@Override
	public QuizQuestionsAssigning mappingQuestions(QuizQuestionsAssigning quizQuestionsAssigning) throws DBExceptions {
		int result;
		String queryString;
		Session session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		//queryString = "select quiz_id from quiz_settings order by quiz_id desc";
		//org.hibernate.query.Query quiz_id= session.createSQLQuery(queryString);
		int quiz_id1 = 1;
		//System.out.println("last inserted id is: "+queryString);
		int pool_id = quizQuestionsAssigning.getPool_id();
		List<Integer> questionIds;
		questionIds = quizQuestionsAssigning.getQuestionIdList();
		for (int question_id : questionIds) {
			 queryString = "INSERT INTO quiz_questions(quiz_id, question_id, pool_id) values(" + quiz_id1 + ","
					+ question_id + "," + pool_id + ")";
			 org.hibernate.query.Query query = (org.hibernate.query.Query) session.createSQLQuery(queryString);
			 transaction.commit();
		}
		return quizQuestionsAssigning;
	}
}
