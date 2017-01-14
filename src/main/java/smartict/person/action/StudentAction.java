package smartict.person.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.BranchModel;
import smartict.model.StudentModel;
import smartict.person.data.PersonData;
import smartict.person.data.StudentData;
import smartict.study.data.BranchData;

public class StudentAction extends ActionSupport implements SessionAware {
	private Map<String,Object> sessionMap;
	String alertStatus, alertMessage;
	List<StudentModel> listStudent;
	Map<String, String> mapBranch, mapPrename;
	StudentModel stdModel;
	
	public String viewAllStudent(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		StudentData stdDB = new StudentData();
		listStudent = stdDB.getListStudentModel();
		
		return forwardText;
	}
	
	public String viewStudentDetail(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		StudentData stdDB = new StudentData();
		stdModel = stdDB.getStudentDetail(stdModel);
		buildMapPrename();
		buildMapBranch();
		
		return forwardText;
	}
	
	public String updateStudentDetail(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		StudentData stdDB = new StudentData();
		boolean hasUpdateStudent = stdDB.hasUpdateStudent(stdModel);
		if(hasUpdateStudent){
			alertStatus = "green green-text";
			alertMessage = "ทำการแก้ไขข้อมูลสำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถแก้ไขข้อมูลนักเรียนได้";
		}
		buildMapPrename();
		buildMapBranch();
		stdModel = stdDB.getStudentDetail(stdModel);
		return forwardText;
	}
	
	public String inputUpdatePassword(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		return forwardText;
	}
	
	public String updatePassword(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(!stdModel.getPassword().equals(stdModel.getCpassword())){
			alertStatus = "red red-text";
			alertMessage = "Password ที่กรอกนั้นไม่ตรงกัน";
		}
		boolean hasUpdate = new StudentData().hasUpdatePassword(stdModel);
		if(hasUpdate){
			forwardText = "success";
			alertStatus = "green green-text";
			alertMessage = "ทำการเปลี่ยนแปลง Password สำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "ทำการเปลี่ยนแปลง Password ไม่สำเร็จ";
		}
		
		return forwardText;
	}
	
	public String inputStudentData(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		buildMapPrename();
		buildMapBranch();
		
		return forwardText;
	}
	
	public String addStudent(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		StudentData stdDB = new StudentData();
		boolean hasAddStudent = stdDB.hasAddStudent(stdModel);
		if(hasAddStudent){
			alertStatus = "green green-text";
			alertMessage = "ทำการเพิ่มข้อมูลสำเร็จ";
			
			listStudent = stdDB.getListStudentModel();
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถเพิ่มข้อมูลได้ กรุณาทำการใหม่อีกครั้ง";
			buildMapBranch();
			buildMapPrename();
			forwardText = "failed";
		}
		
		
		return forwardText;
	}
	
	public String DeleteStudent(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		StudentData stdDB = new StudentData();
		boolean hasDelete = stdDB.hasDelete(stdModel);
		if(hasDelete){
			alertStatus = "green green-text";
			alertMessage = "ทำการลบข้อมูลสำเร็จ";
			
			listStudent = stdDB.getListStudentModel();
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถลบข้อมูลนักเรียนได้";
			buildMapPrename();
			buildMapBranch();
			stdModel = stdDB.getStudentDetail(stdModel);
			forwardText = "failed";
		}
		
		return forwardText;
	}
	
	public void buildMapBranch(){
		BranchData braDB = new BranchData();
		BranchModel BraModel = new BranchModel(0, "", "", "");
		mapBranch = braDB.getMapBranch(BraModel);
	}
	
	public void buildMapPrename(){
		PersonData perDB = new PersonData();
		mapPrename = perDB.getMapPrename();
	}
	
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

	public String getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStatus(String alertStatus) {
		this.alertStatus = alertStatus;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public List<StudentModel> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<StudentModel> listStudent) {
		this.listStudent = listStudent;
	}

	public Map<String, String> getMapBranch() {
		return mapBranch;
	}

	public void setMapBranch(Map<String, String> mapBranch) {
		this.mapBranch = mapBranch;
	}

	public StudentModel getStdModel() {
		return stdModel;
	}

	public void setStdModel(StudentModel stdModel) {
		this.stdModel = stdModel;
	}

	public Map<String, String> getMapPrename() {
		return mapPrename;
	}

	public void setMapPrename(Map<String, String> mapPrename) {
		this.mapPrename = mapPrename;
	}
	
}
