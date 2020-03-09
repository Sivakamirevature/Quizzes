package com.example.quizzes.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	String title;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_Id", referencedColumnName = "category_id")
    	private Category category;
	
	@Column(name = "content")
	private String content;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="level_Id", referencedColumnName = "id")
	private Level level;
		
	@Column(name = "skill_points")
	private short skill_points;
	
	@Column(name = "score")
	private short score;
	
	@Column(name = "duration")
	Timestamp duration;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="question_type_Id", referencedColumnName = "id")
    	private QuestionType questionType;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "tags")
	private String tags;
	
	@Column(name = "created_on")
	private Timestamp created_on;

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_on")
	private Timestamp modified_on;

	@Column(name = "modified_by")
	private String modified_by;
	
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="question_id") private List<Quiz_Question>
	 * questionquizobjList;
	 */

	public short getSkill_points() {
		return skill_points;
	}

	public void setSkill_points(short skill_points) {
		this.skill_points = skill_points;
	}

	/*
	 * public List<Quiz_Question> getQuestionquizobjList() { return
	 * questionquizobjList; }
	 * 
	 * public void setQuestionquizobjList(List<Quiz_Question> questionquizobjList) {
	 * this.questionquizobjList = questionquizobjList; }
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getSkill_point() {
		return skill_points;
	}

	public void setSkill_point(short skill_point) {
		this.skill_points= skill_point;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public Timestamp getDuration() {
		return duration;
	}

	public void setDuration(Timestamp duration) {
		this.duration = duration;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getModified_on() {
		return modified_on;
	}

	public void setModified_on(Timestamp modified_on) {
		this.modified_on = modified_on;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
}
