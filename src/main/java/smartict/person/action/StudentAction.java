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
		
		buildMapBranch();
		
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
