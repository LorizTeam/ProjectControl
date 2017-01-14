package smartict.model;

import java.util.List;

import org.joda.time.DateTime;

public class ProjectModel extends PersonModel {
	int project_id, teacher_id, exam_number, score_pass,
		addExamScoreStatusId, project_status_id, course_id, faclulty_id, 
		exam_fullscore, personadded;
	String project_nameth, project_nameen, course_nameth, course_nameen,
			showScoreProject, faclulty_nameth, faclulty_nameen, project_status_name,
			project_description;
	Double exam_score;
	DateTime createdatetime;
	boolean canAddExamScore;
	List<StudentModel> listStudent;
	
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
	public List<StudentModel> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<StudentModel> listStudent) {
		this.listStudent = listStudent;
	}

	public String getCourse_nameth() {
		return course_nameth;
	}

	public void setCourse_nameth(String course_nameth) {
		this.course_nameth = course_nameth;
	}

	public String getCourse_nameen() {
		return course_nameen;
	}

	public void setCourse_nameen(String course_nameen) {
		this.course_nameen = course_nameen;
	}

	public String getShowScoreProject() {
		return showScoreProject;
	}

	public void setShowScoreProject(String showScoreProject) {
		this.showScoreProject = showScoreProject;
	}

	public int getFaclulty_id() {
		return faclulty_id;
	}

	public void setFaclulty_id(int faclulty_id) {
		this.faclulty_id = faclulty_id;
	}

	public String getFaclulty_nameth() {
		return faclulty_nameth;
	}

	public void setFaclulty_nameth(String faclulty_nameth) {
		this.faclulty_nameth = faclulty_nameth;
	}

	public String getFaclulty_nameen() {
		return faclulty_nameen;
	}

	public void setFaclulty_nameen(String faclulty_nameen) {
		this.faclulty_nameen = faclulty_nameen;
	}

	public int getExam_fullscore() {
		return exam_fullscore;
	}

	public void setExam_fullscore(int exam_fullscore) {
		this.exam_fullscore = exam_fullscore;
	}

	public int getAddExamScoreStatusId() {
		return addExamScoreStatusId;
	}

	public void setAddExamScoreStatusId(int addExamScoreStatusId) {
		this.addExamScoreStatusId = addExamScoreStatusId;
	}

	public void setCreatedatetime(DateTime createdatetime) {
		this.createdatetime = createdatetime;
	}

	public boolean isCanAddExamScore() {
		return canAddExamScore;
	}

	public void setCanAddExamScore(boolean canAddExamScore) {
		this.canAddExamScore = canAddExamScore;
	}

	public int getPersonadded() {
		return personadded;
	}

	public void setPersonadded(int personadded) {
		this.personadded = personadded;
	}

	public String getProject_status_name() {
		return project_status_name;
	}

	public void setProject_status_name(String project_status_name) {
		this.project_status_name = project_status_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	
}
