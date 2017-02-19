package smartict.model;

public class SectionModel extends CourseModel {
	int sectionId, sectionYear, isActive;
	String sectionName, studentId;
	
	public SectionModel() {
		super();
	}
	
	public void clearSecModel(){
		this.sectionName = "";
		this.sectionYear = 0;
	}
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getSectionYear() {
		return sectionYear;
	}
	public void setSectionYear(int sectionYear) {
		this.sectionYear = sectionYear;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
