package smartict.model;

public class CourseModel extends MasterIDCODE{
	int branchId;
	String branchNameTh, branchNameEn, branchCode;
	
	public CourseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CourseModel(int courseId, String courseCode, String courseNameTh, String courseNameEn,
						int branchId, String branchCode, String branchNameTh, String branchNameEn) {
		super(courseId, courseCode, courseNameTh, courseNameEn);
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchNameTh = branchNameTh;
		this.branchNameEn = branchNameEn;
		
	}

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchNameTh() {
		return branchNameTh;
	}
	public void setBranchNameTh(String branchNameTh) {
		this.branchNameTh = branchNameTh;
	}
	public String getBranchNameEn() {
		return branchNameEn;
	}
	public void setBranchNameEn(String branchNameEn) {
		this.branchNameEn = branchNameEn;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
}
