package smartict.person.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import smartict.person.data.LoginData;

public class LoginLogoutAction extends ActionSupport {
	
	String username, password;

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
	
	public String Login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		String forwardText = "login";
		LoginData loginDB = new LoginData();
		
		if(loginDB.isTeacherUser(username, password)){
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("type", "1");
			forwardText = "success";
		}else if(loginDB.isStudentUser(username, password)){
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("type", "2");
			forwardText = "success";
		}else if(loginDB.isEmployeeUser(username, password)){
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("type", "3");
			forwardText = "success";
		}
		
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
