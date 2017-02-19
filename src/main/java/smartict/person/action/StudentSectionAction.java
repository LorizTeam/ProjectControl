package smartict.person.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.BranchModel;
import smartict.model.StudentModel;
import smartict.model.StudentSectionModel;
import smartict.person.data.PersonData;
import smartict.person.data.StudentData;
import smartict.study.data.BranchData;
import smartict.study.data.CourseData;
import smartict.study.data.SectionData;

public class StudentSectionAction extends ActionSupport implements SessionAware {
	private Map<String,Object> sessionMap;
	String alertStatus, alertMessage;
	Map<String, String> mapCourse;
	StudentModel stdModel;
	List<StudentSectionModel> listStudentSection;
	CourseData courseDB = new CourseData();
	SectionData secDB = new SectionData();
	StudentData stdDB = new StudentData();
	
	public String inputStudentSection(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		mapCourse = courseDB.getMapCourse(stdModel.getBranchId());
		listStudentSection = stdDB.getListStudentSectionModel(stdModel.getStudent_id());
		
		return SUCCESS;
	}
	
	public String addStudentSection(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(secDB.addStudentSection(stdModel)){
			alertStatus = "green green-text";
			alertMessage = "ทำการเพิ่มข้อมูลสำเร็จ";
			
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถเพิ่มข้อมูลได้ กรุณาทำการใหม่อีกครั้ง";
		}
		
		mapCourse = courseDB.getMapCourse(stdModel.getBranchId());
		listStudentSection = stdDB.getListStudentSectionModel(stdModel.getStudent_id());
		
		return SUCCESS;
	}
	
	public String deleteStudentSection(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(secDB.deleteStudentSection(stdModel)){
			alertStatus = "green green-text";
			alertMessage = "ทำการลบข้อมูลสำเร็จ";
			
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถลบข้อมูลได้ กรุณาทำการใหม่อีกครั้ง";
		}
		
		mapCourse = courseDB.getMapCourse(stdModel.getBranchId());
		listStudentSection = stdDB.getListStudentSectionModel(stdModel.getStudent_id());
		
		return SUCCESS;
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

	public StudentModel getStdModel() {
		return stdModel;
	}

	public void setStdModel(StudentModel stdModel) {
		this.stdModel = stdModel;
	}


	public Map<String, String> getMapCourse() {
		return mapCourse;
	}


	public void setMapCourse(Map<String, String> mapCourse) {
		this.mapCourse = mapCourse;
	}


	public List<StudentSectionModel> getListStudentSection() {
		return listStudentSection;
	}


	public void setListStudentSection(List<StudentSectionModel> listStudentSection) {
		this.listStudentSection = listStudentSection;
	}

	
}
