package smict.project.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.CourseModel;
import smartict.model.ProjectModel;
import smartict.person.data.StudentData;
import smartict.person.data.TeacherData;
import smartict.study.data.CourseData;
import smict.project.data.ProjectData;

public class ProjectAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> sessionMap;
	ProjectModel proModel;
	ProjectData projectDB = new ProjectData();
	TeacherData teachDB = new TeacherData();
	StudentData studentDB = new StudentData();
	CourseData courseDB = new CourseData();
	String inputStudentId, inputTeacherId;
	
	Map<String, String> mapTeacher, mapCourse, mapStudent;
	
	public String inputProjectData(){

		mapTeacher = teachDB.getMapTeacher();
		CourseModel couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		mapCourse = courseDB.getMapCourse(couModel);
		mapStudent = studentDB.getMapStudent();
		
		String[] studentId, teacherId;
		studentId = inputStudentId.split(",");
		teacherId = inputTeacherId.split(",");
		
		
		
		return "success";
	}
	
	
	//GetSet
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
	public Map<String, String> getMapStudent() {
		return mapStudent;
	}

	public void setMapStudent(Map<String, String> mapStudent) {
		this.mapStudent = mapStudent;
	}
	
	public String getInputStudentId() {
		return inputStudentId;
	}


	public void setInputStudentId(String inputStudentId) {
		this.inputStudentId = inputStudentId;
	}


	public String getInputTeacherId() {
		return inputTeacherId;
	}


	public void setInputTeacherId(String inputTeacherId) {
		this.inputTeacherId = inputTeacherId;
	}

}
