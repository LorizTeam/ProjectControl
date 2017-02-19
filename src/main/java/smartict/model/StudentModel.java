package smartict.model;

public class StudentModel extends PersonModel{
	String student_id, branch_nameth, faculty_nameth, branchId,
			oldstudent_id, receiveYear;
	
	int sectionId,studentSectionId;
	
	public StudentModel() {
		super();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getBranch_nameth() {
		return branch_nameth;
	}

	public void setBranch_nameth(String branch_nameth) {
		this.branch_nameth = branch_nameth;
	}

	public String getFaculty_nameth() {
		return faculty_nameth;
	}

	public void setFaculty_nameth(String faculty_nameth) {
		this.faculty_nameth = faculty_nameth;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getOldstudent_id() {
		return oldstudent_id;
	}

	public void setOldstudent_id(String oldstudent_id) {
		this.oldstudent_id = oldstudent_id;
	}

	public String getReceiveYear() {
		return receiveYear;
	}

	public void setReceiveYear(String receiveYear) {
		this.receiveYear = receiveYear;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getStudentSectionId() {
		return studentSectionId;
	}

	public void setStudentSectionId(int studentSectionId) {
		this.studentSectionId = studentSectionId;
	}
	
}
