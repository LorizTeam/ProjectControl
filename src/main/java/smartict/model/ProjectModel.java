package smartict.model;

import org.joda.time.DateTime;

public class ProjectModel {
	int project_id, teacher_id, exam_number, score_pass,
	project_status_id, course_id;
	String project_nameth, project_nameen;
	Double exam_score;
	DateTime createdatetime;
	
	public ProjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProjectModel(int project_id, int teacher_id, int exam_number, int score_pass, int project_status_id,
			int course_id, String project_nameth, String project_nameen, Double exam_score, DateTime createdatetime) {
		super();
		this.project_id = project_id;
		this.teacher_id = teacher_id;
		this.exam_number = exam_number;
		this.score_pass = score_pass;
		this.project_status_id = project_status_id;
		this.course_id = course_id;
		this.project_nameth = project_nameth;
		this.project_nameen = project_nameen;
		this.exam_score = exam_score;
		this.createdatetime = createdatetime;
	}
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getExam_number() {
		return exam_number;
	}
	public void setExam_number(int exam_number) {
		this.exam_number = exam_number;
	}
	public int getScore_pass() {
		return score_pass;
	}
	public void setScore_pass(int score_pass) {
		this.score_pass = score_pass;
	}
	public int getProject_status_id() {
		return project_status_id;
	}
	public void setProject_status_id(int project_status_id) {
		this.project_status_id = project_status_id;
	}
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getProject_nameth() {
		return project_nameth;
	}
	public void setProject_nameth(String project_nameth) {
		this.project_nameth = project_nameth;
	}
	public String getProject_nameen() {
		return project_nameen;
	}
	public void setProject_nameen(String project_nameen) {
		this.project_nameen = project_nameen;
	}
	public Double getExam_score() {
		return exam_score;
	}
	public void setExam_score(Double exam_score) {
		this.exam_score = exam_score;
	}
	public DateTime getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(DateTime createdatetime) {
		this.createdatetime = createdatetime;
	}
	
	
	
	
	
	

}
