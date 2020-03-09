package com.example.quizzes.dto;

import java.util.List;

public class QuizQuestionsAssigning {

	private List<Integer> questionIdList;
	int pool_id;

	public List<Integer> getQuestionIdList() {
		return questionIdList;
	}

	public void setQuestionIdList(List<Integer> questionIdList) {
		this.questionIdList = questionIdList;
	}

	public int getPool_id() {
		return pool_id;
	}

	public void setPool_id(int pool_id) {
		this.pool_id = pool_id;
	}
}
