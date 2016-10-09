package smartict.model;

public class BranchModel extends MasterIDCODE {
	int facultyId;
	String facultyNameTh, facultyNameEn, facultyCode;

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public String getFacultyNameTh() {
		return facultyNameTh;
	}

	public void setFacultyNameTh(String facultyNameTh) {
		this.facultyNameTh = facultyNameTh;
	}

	public String getFacultyNameEn() {
		return facultyNameEn;
	}

	public void setFacultyNameEn(String facultyNameEn) {
		this.facultyNameEn = facultyNameEn;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
	public BranchModel(){}

	public BranchModel(int braId, String code, String nameth, String  nameen, 
						int facId, String facNameTH, String facNameEn, String facCode) {
		super(braId, code, nameth, nameen);
		this.facultyId = facId;
		this.facultyNameTh = facNameTH;
		this.facultyNameEn = facNameEn;
		this.facultyCode = facCode;
	}
	
	
}
