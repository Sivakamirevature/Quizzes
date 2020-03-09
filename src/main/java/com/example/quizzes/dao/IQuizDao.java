package com.example.quizzes.dao;

import java.util.List;

import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.model.Quiz;

public interface IQuizDao {

	List<Quiz> getAllQuizzes()throws DBExceptions;

	List<Quiz> getQuizByID(int id)throws DBExceptions;

	Quiz createQuiz(Quiz quiz)throws DBExceptions;

	int deleteById(int qid)throws DBExceptions;

	Quiz updateById(Quiz quiz)throws DBExceptions;

	int activeDeactiveQuiz(int qid)throws DBExceptions;

	QuizQuestionsAssigning mappingQuestions(QuizQuestionsAssigning quizQuestionsAssigning) throws DBExceptions;

	int DeleteAllQuizzes() throws DBExceptions;

}
