package com.example.quizzes.service;

import java.util.List;

import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Quiz;



public interface IQuizService {

	List<Quiz> getAllQuizzes() throws ServiceExceptions, DBExceptions;

	List<Quiz> getQuizByID(int id) throws ServiceExceptions, DBExceptions;

	Quiz createQuiz(Quiz quiz) throws ServiceExceptions, DBExceptions;

	int activeDeactiveQuiz(int qid) throws ServiceExceptions, DBExceptions;

	int DeleteById(int qid) throws ServiceExceptions, DBExceptions;

	Quiz UpdateById(Quiz quiz) throws ServiceExceptions, DBExceptions;

	QuizQuestionsAssigning mappingquestions(QuizQuestionsAssigning quizQuestionsAssigning) throws ServiceExceptions, DBExceptions;

}
