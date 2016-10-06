package smartict.study.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.FacultyModel;
import smartict.study.data.FacultyData;

public class FacultyAction extends ActionSupport implements SessionAware{

	private Map<String,Object> sessionMap;
	FacultyModel facModel;
	List<FacultyModel> listFacModel;
	String alertStatus, alertMessage;
	FacultyData facDB = new FacultyData();
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

	public FacultyModel getFacModel() {
		return facModel;
	}

	public void setFacModel(FacultyModel facModel) {
		this.facModel = facModel;
	}
	
	public List<FacultyModel> getListFacModel() {
		return listFacModel;
	}

	public void setListFacModel(List<FacultyModel> listFacModel) {
		this.listFacModel = listFacModel;
	}

	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
	public String addFaculty(){
		
		String forwardText = "";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(facDB.addFaculty(facModel)){
			alertStatus = "green green-text";
			alertMessage = "เพิ่มข้อมูลคณะสำเร็จ";
			forwardText = "success";
		}else{
			alertStatus = "red red-text";
			alertMessage = "เพิ่มข้อมูลคณะไม่สำเร็จ";
			forwardText = "success";
		}
		
		return forwardText;
	}
	
	public String viewAllFaculty(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		FacultyModel setfacModel = new FacultyModel(0,"","","");
		listFacModel = facDB.getListFaculty(setfacModel);
		
		return forwardText;
	}
	
	public String viewFaculty(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		FacultyModel setfacModel = new FacultyModel(0,facModel.getCode(),"","");
		listFacModel = facDB.getListFaculty(setfacModel);
		if(listFacModel.size() > 0){
			facModel = (FacultyModel) listFacModel.get(0);
		}
		
		return forwardText;
	}
	
	public String updateFaculty(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		if(facDB.updateFaculty(facModel)){
			alertStatus = "green green-text";
			alertMessage = "เพิ่มข้อมูลคณะสำเร็จ";
		}
		
		return forwardText;
	}
}
