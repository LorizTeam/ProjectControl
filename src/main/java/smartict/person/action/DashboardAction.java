package smartict.person.action;

import com.opensymphony.xwork2.ActionSupport;

import smartict.person.data.StudentData;
import smartict.person.data.TeacherData;
import smict.project.data.ProjectData;

public class DashboardAction extends ActionSupport {
	String numberProject, numberTeacher, numberStudent;
	
	public String goDashBoard(){
		
		numberStudent = new StudentData().countStudent();
		numberTeacher = new TeacherData().countTeacher();
		numberProject = new ProjectData().countProject();
		
		return SUCCESS;
	}

	public String getNumberProject() {
		return numberProject;
	}

	public void setNumberProject(String numberProject) {
		this.numberProject = numberProject;
	}

	public String getNumberTeacher() {
		return numberTeacher;
	}

	public void setNumberTeacher(String numberTeacher) {
		this.numberTeacher = numberTeacher;
	}

	public String getNumberStudent() {
		return numberStudent;
	}

	public void setNumberStudent(String numberStudent) {
		this.numberStudent = numberStudent;
	}
	
}
