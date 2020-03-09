package com.example.quizzes.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name ="quiz_settings")
public class Quiz {
	@Id
	@Column(name="quiz_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer quiz_id;

	public Integer getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Integer quiz_id) {
		this.quiz_id = quiz_id;
	}

	@Column(name = "quiz_name")
	private String quiz_name;

	@Column(name = "tags")
	private String tags;

	@Column(name = "activity_points")
	private short activity_points;

	@Column(name = "duration")
	private Time duration;

	@Column(name = "max_no_of_attempts")
	private short max_no_of_attempts;

	@Column(name = "level_override")
	private boolean level_override;

	@Column(name = "slug")
	private String slug;

	@Column(name = "description")
	private String description;

	@Column(name = "meta_keywords")
	private String meta_keywords;

	@Column(name = "meta_description")
	private String meta_description;

	@Column(name = "icon")
	private String icon;

	@Column(name = "instructions")
	private String instructions;

	@Column(name = "pass_percentage")
	private float pass_percentage;

	@Column(name = "is_available_pre_signup")
	private Boolean is_available_pre_signup;

	@Column(name = "is_available_via_slug")
	private Boolean is_available_via_slug;

	@Column(name = "is_available_dashboard")
	private Boolean is_available_dashboard;

	@Column(name = "is_timer_enabled")
	private Boolean is_timer_enabled;

	@Column(name = "is_shuffle_questions")
	private Boolean is_shuffle_questions;

	@Column(name = "is_shuffle_answers")
	private Boolean is_shuffle_answers;

	@Column(name = "is_display_score")
	private Boolean is_display_score;

	@Column(name = "is_allow_attempt_review")
	private Boolean is_allow_attempt_review;

	@Column(name = "is_show_correct_answers_passed")
	private Boolean is_show_correct_answers_passed;

	@Column(name = "is_show_correct_answers_failed")
	private Boolean is_show_correct_answers_failed;

	@Column(name = "is_show_answer_explanations")
	private Boolean is_show_answer_explanations;

	@Column(name = "is_enable_save_resume")
	private Boolean is_enable_save_resume;

	@Column(name = "created_on")
	private Timestamp created_on;

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_on")
	private Timestamp modified_on;

	@Column(name = "modified_by")
	private String modified_by;

	@Column(name = "modified_count")
	private int modified_count;

	@OneToOne()
	@JoinColumn(name="level_id", referencedColumnName = "id")
	private Level  level;
	
	@OneToOne()
	@JoinColumn(name="category_id", referencedColumnName = "category_id")
    	private Category category;
	
	@Column(name = "status")
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="quiz_id")
	private List<Quiz_Question> quizQuestionObj;

	public List<Quiz_Question> getQuizQuestionObj() {
		return quizQuestionObj;
	}

	public void setQuizQuestionObj(List<Quiz_Question> quizQuestionObj) {
		this.quizQuestionObj = quizQuestionObj;
	}

	public String getQuiz_name() {
		return quiz_name;
	}

	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public short getActivity_points() {
		return activity_points;
	}

	public void setActivity_points(short activity_points) {
		this.activity_points = activity_points;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public short getMax_no_of_attempts() {
		return max_no_of_attempts;
	}

	public void setMax_no_of_attempts(short max_no_of_attempts) {
		this.max_no_of_attempts = max_no_of_attempts;
	}

	public boolean isLevel_override() {
		return level_override;
	}

	public void setLevel_override(boolean level_override) {
		this.level_override = level_override;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta_keywords() {
		return meta_keywords;
	}

	public void setMeta_keywords(String meta_keywords) {
		this.meta_keywords = meta_keywords;
	}

	public String getMeta_description() {
		return meta_description;
	}

	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public float getPass_percentage() {
		return pass_percentage;
	}

	public void setPass_percentage(float pass_percentage) {
		this.pass_percentage = pass_percentage;
	}

	public Boolean getIs_available_pre_signup() {
		return is_available_pre_signup;
	}

	public void setIs_available_pre_signup(Boolean is_available_pre_signup) {
		this.is_available_pre_signup = is_available_pre_signup;
	}

	public Boolean getIs_available_via_slug() {
		return is_available_via_slug;
	}

	public void setIs_available_via_slug(Boolean is_available_via_slug) {
		this.is_available_via_slug = is_available_via_slug;
	}

	public Boolean getIs_available_dashboard() {
		return is_available_dashboard;
	}

	public void setIs_available_dashboard(Boolean is_available_dashboard) {
		this.is_available_dashboard = is_available_dashboard;
	}

	public Boolean getIs_timer_enabled() {
		return is_timer_enabled;
	}

	public void setIs_timer_enabled(Boolean is_timer_enabled) {
		this.is_timer_enabled = is_timer_enabled;
	}

	public Boolean getIs_shuffle_questions() {
		return is_shuffle_questions;
	}

	public void setIs_shuffle_questions(Boolean is_shuffle_questions) {
		this.is_shuffle_questions = is_shuffle_questions;
	}

	public Boolean getIs_shuffle_answers() {
		return is_shuffle_answers;
	}

	public void setIs_shuffle_answers(Boolean is_shuffle_answers) {
		this.is_shuffle_answers = is_shuffle_answers;
	}

	public Boolean getIs_display_score() {
		return is_display_score;
	}

	public void setIs_display_score(Boolean is_display_score) {
		this.is_display_score = is_display_score;
	}

	public Boolean getIs_allow_attempt_review() {
		return is_allow_attempt_review;
	}

	public void setIs_allow_attempt_review(Boolean is_allow_attempt_review) {
		this.is_allow_attempt_review = is_allow_attempt_review;
	}

	public Boolean getIs_show_correct_answers_passed() {
		return is_show_correct_answers_passed;
	}

	public void setIs_show_correct_answers_passed(Boolean is_show_correct_answers_passed) {
		this.is_show_correct_answers_passed = is_show_correct_answers_passed;
	}

	public Boolean getIs_show_correct_answers_failed() {
		return is_show_correct_answers_failed;
	}

	public void setIs_show_correct_answers_failed(Boolean is_show_correct_answers_failed) {
		this.is_show_correct_answers_failed = is_show_correct_answers_failed;
	}

	public Boolean getIs_show_answer_explanations() {
		return is_show_answer_explanations;
	}

	public void setIs_show_answer_explanations(Boolean is_show_answer_explanations) {
		this.is_show_answer_explanations = is_show_answer_explanations;
	}

	public Boolean getIs_enable_save_resume() {
		return is_enable_save_resume;
	}

	public void setIs_enable_save_resume(Boolean is_enable_save_resume) {
		this.is_enable_save_resume = is_enable_save_resume;
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

	public int getModified_count() {
		return modified_count;
	}

	public void setModified_count(int modified_count) {
		this.modified_count = modified_count;
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
	
	public Quiz() {}	
	
	@Override
	public String toString() {
		return "Quiz [quiz_id=" + quiz_id + ", quiz_name=" + quiz_name + ", tags=" + tags + ", activity_points="
				+ activity_points + ", duration=" + duration + ", max_no_of_attempts=" + max_no_of_attempts
				+ ", level_override=" + level_override + ", slug=" + slug + ", description=" + description
				+ ", meta_keywords=" + meta_keywords + ", meta_description=" + meta_description + ", icon=" + icon
				+ ", instructions=" + instructions + ", pass_percentage=" + pass_percentage
				+ ", is_available_pre_signup=" + is_available_pre_signup + ", is_available_via_slug="
				+ is_available_via_slug + ", is_available_dashboard=" + is_available_dashboard + ", is_timer_enabled="
				+ is_timer_enabled + ", is_shuffle_questions=" + is_shuffle_questions + ", is_shuffle_answers="
				+ is_shuffle_answers + ", is_display_score=" + is_display_score + ", is_allow_attempt_review="
				+ is_allow_attempt_review + ", is_show_correct_answers_passed=" + is_show_correct_answers_passed
				+ ", is_show_correct_answers_failed=" + is_show_correct_answers_failed
				+ ", is_show_answer_explanations=" + is_show_answer_explanations + ", is_enable_save_resume="
				+ is_enable_save_resume + ", created_on=" + created_on + ", created_by=" + created_by + ", modified_on="
				+ modified_on + ", modified_by=" + modified_by + ", modified_count=" + modified_count + ", level="
				+ level + ", category=" + category + ", status=" + status + ", quizQuestionObj=" + quizQuestionObj
				+ "]";
	}
}