package smartict.person.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.PersonInterface;
import smartict.model.TeacherModel;
import smartict.person.data.PersonData;
import smartict.person.data.StudentData;
import smartict.person.data.TeacherData;

public class TeacherAction extends ActionSupport implements SessionAware,PersonInterface {
	private Map<String,Object> sessionMap;
	String alertStatus, alertMessage;
	Map<String, String> mapPrename;
	TeacherModel teaModel;
	List<TeacherModel> listTeacher;
	
	public String viewAll() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		TeacherData teaDB = new TeacherData();
		teaModel = new TeacherModel();
		teaModel.setTeacher_id(0);
		listTeacher = teaDB.listTeacherModel(teaModel);
		
		return forwardText;
	}

	public String viewDetail() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		buildMapPrename();
		TeacherData teaDB = new TeacherData();
		teaDB.getTeacherDetail(teaModel);
		return forwardText;
	}

	public String inputData() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		buildMapPrename();
		return forwardText;
	}

	public String addData() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		TeacherData teaDB = new TeacherData();
		boolean hasAddTeacher = teaDB.hasAddTeacher(teaModel);
		if(hasAddTeacher){
			alertStatus = "green green-text";
			alertMessage = "ทำการเพิ่มข้อมูลสำเร็จ";
			TeacherModel tempTeacherModel = new TeacherModel();
			tempTeacherModel.setTeacher_id(0);
			listTeacher = teaDB.listTeacherModel(tempTeacherModel);
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถเพิ่มข้อมูลได้ กรุณาทำการใหม่อีกครั้ง";
			buildMapPrename();
			forwardText = "failed";
		}
		return forwardText;
	}

	public String deleteData() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		TeacherData teaDB = new TeacherData();
		boolean hasDelete = teaDB.hasDelete(teaModel);
		if(hasDelete){
			alertStatus = "green green-text";
			alertMessage = "ทำการลบข้อมูลสำเร็จ";
			
			TeacherModel tempTeacherModel = new TeacherModel();
			tempTeacherModel.setTeacher_id(0);
			listTeacher = teaDB.listTeacherModel(tempTeacherModel);
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถลบข้อมูลอาจารย์ได้";
			buildMapPrename();
			teaModel = teaDB.getTeacherDetail(teaModel);
			forwardText = "failed";
		}
		
		return forwardText;
	}

	public String updateData() {
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		TeacherData teaDB = new TeacherData();
		boolean hasUpdateTeacher = teaDB.hasUpdateTeacher(teaModel);
		if(hasUpdateTeacher){
			alertStatus = "green green-text";
			alertMessage = "ทำการแก้ไขข้อมูลสำเร็จ";
			
		}else{
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถแก้ไขข้อมูลอาจารย์ได้";
		}
		
		buildMapPrename();
		teaModel = teaDB.getTeacherDetail(teaModel);
		return forwardText;
	}
	
	public void buildMapPrename(){
		PersonData perDB = new PersonData();
		mapPrename = perDB.getMapPrename();
	}
	
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
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
	public Map<String, String> getMapPrename() {
		return mapPrename;
	}
	public void setMapPrename(Map<String, String> mapPrename) {
		this.mapPrename = mapPrename;
	}
	public TeacherModel getTeaModel() {
		return teaModel;
	}
	public void setTeaModel(TeacherModel teaModel) {
		this.teaModel = teaModel;
	}
	public List<TeacherModel> getListTeacher() {
		return listTeacher;
	}
	public void setListTeacher(List<TeacherModel> listTeacher) {
		this.listTeacher = listTeacher;
	}

}
