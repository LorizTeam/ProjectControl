package smartict.model;

public class StudentModel extends PersonModel{
	String student_id, branch_nameth, faculty_nameth, branchId;
	
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
	
}
