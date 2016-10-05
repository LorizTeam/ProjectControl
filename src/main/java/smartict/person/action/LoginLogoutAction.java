package smartict.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.PersonModel;
import smartict.person.data.LoginData;
import smartict.person.data.PersonData;

public class LoginLogoutAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> sessionMap;
	String username, password, firstname, lastname,
	alertStatus, alertMessage;

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
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
	public String Login(){
		
		String forwardText = "login";
		LoginData loginDB = new LoginData();
		PersonData personDB = new PersonData();
		boolean hasUser = false;
		if(loginDB.isTeacherUser(username, password)){
			sessionMap.put("type", "1");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getTeacherDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}else if(loginDB.isStudentUser(username, password)){
			sessionMap.put("type", "2");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getStudentDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}else if(loginDB.isEmployeeUser(username, password)){
			sessionMap.put("type", "3");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getEmployeeDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}else{
			alertStatus = "green green-text";
			alertMessage = "Username หรือ Password ผิดพลาด";
		}
		
		sessionMap.put("username", username);
		sessionMap.put("password", password);
		sessionMap.put("firstname", firstname);
		sessionMap.put("lastname", lastname);
		
		return forwardText;
	}
	
	public String Logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		alertStatus = "green green-text";
		alertMessage = "ออกจากระบบสำเร็จ";
		return "login";
	}
}
