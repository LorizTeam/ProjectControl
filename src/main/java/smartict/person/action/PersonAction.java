package smartict.person.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.person.data.PersonData;

public class PersonAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> sessionMap;
	String username, password,alertStatus, alertMessage;
	PersonData personDB = new PersonData();
	public String inputChangePassword(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		return SUCCESS;
	}
	
	public String changePassword(){
		String forwardText = "false";
		boolean hasUpdate = personDB.hasUpdatePassword(username, password, sessionMap.get("type").toString());
		password = "";
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
	
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
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

}
