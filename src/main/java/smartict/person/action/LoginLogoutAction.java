package smartict.person.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.PersonModel;
import smartict.person.data.LoginData;
import smartict.person.data.PersonData;

public class LoginLogoutAction extends ActionSupport {
	
	String username, password, firstname, lastname;

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

	public String Login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		String forwardText = "login";
		LoginData loginDB = new LoginData();
		PersonData personDB = new PersonData();
		boolean hasUser = false;
		if(loginDB.isTeacherUser(username, password)){
			session.setAttribute("type", "1");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getTeacherDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}else if(loginDB.isStudentUser(username, password)){
			session.setAttribute("type", "2");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getStudentDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}else if(loginDB.isEmployeeUser(username, password)){
			session.setAttribute("type", "3");
			
			PersonModel persModel = new PersonModel();
			persModel = personDB.getEmployeeDetail(username, password);
			firstname = persModel.getFirstname();
			lastname = persModel.getLastname();
			
			forwardText = "success";
		}
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		
		return forwardText;
	}
	
	public String Logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		System.out.println("Logout !!!");
		session.invalidate();
		return "login";
	}
}
