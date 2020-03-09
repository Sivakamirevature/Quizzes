package com.example.quizzes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "quiz_questions")
public class Quiz_Question {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column
	private Integer quiz_id;

	@OneToOne()
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Question question;

	@OneToOne
	@JoinColumn(name="pool_id")
	private Pool pool;

	public Integer getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Integer quiz_id) {
		this.quiz_id = quiz_id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
	
	
}

