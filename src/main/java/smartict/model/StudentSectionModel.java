package smartict.model;

public class StudentSectionModel extends StudentModel {
	int sectionId, year, courseId, isCourseActive;
	String sectionName;
	
	public StudentSectionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getIsCourseActive() {
		return isCourseActive;
	}
	public void setIsCourseActive(int isCourseActive) {
		this.isCourseActive = isCourseActive;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}
