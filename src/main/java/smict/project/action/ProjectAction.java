package smict.project.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.CourseModel;
import smartict.model.ProjectModel;
import smartict.person.data.TeacherData;
import smartict.study.data.CourseData;
import smict.project.data.ProjectData;

public class ProjectAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> sessionMap;
	ProjectModel proModel;
	ProjectData projectDB = new ProjectData();
	TeacherData teachDB = new TeacherData();
	CourseData courseDB = new CourseData();
	Map<String, String> mapTeacher, mapCourse;
	
	public Map<String, String> getMapTeacher() {
		return mapTeacher;
	}

	public void setMapTeacher(Map<String, String> mapTeacher) {
		this.mapTeacher = mapTeacher;
	}

	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
	public Map<String, String> getMapCourse() {
		return mapCourse;
	}

	public void setMapCourse(Map<String, String> mapCourse) {
		this.mapCourse = mapCourse;
	}

	public String inputProjectData(){
		System.out.println("Input Method");
		
		mapTeacher = teachDB.getMapTeacher();
		CourseModel couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		mapCourse = courseDB.getMapCourse(couModel);
		return "success";
	}
}
