package smict.project.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.CourseModel;
import smartict.model.ProjectModel;
import smartict.person.data.StudentData;
import smartict.person.data.TeacherData;
import smartict.study.data.CourseData;
import smartict.util.Validate;
import smict.project.data.ProjectData;

public class ProjectAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> sessionMap;
	ProjectModel proModel;
	ProjectData projectDB = new ProjectData();
	TeacherData teachDB = new TeacherData();
	StudentData studentDB = new StudentData();
	CourseData courseDB = new CourseData();
	String inputStudentId, inputTeacherId, alertStatus, alertMessage;;
	Validate cValidate = new Validate();
	Map<String, String> mapTeacher, mapCourse, mapStudent;
	List<ProjectModel> listProModel;
	
	public String viewProjectAll(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "��سҷӡ�� Login ��͹����¡��";
			return "login";
		}
		
		listProModel = projectDB.getListProject();
		
		return forwardText;
	}
	
	public String inputProjectData(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "��سҷӡ�� Login ��͹����¡��";
			return "login";
		}
		
		getMapAddProject();
		
		return forwardText;
	}
	
	public String addProject(){
		String forwardText = "";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "��سҷӡ�� Login ��͹����¡��";
			return "login";
		}
		
		if(!cValidate.Check_String_notnull_notempty(proModel.getProject_nameth())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�����Ū��� Project ������";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(proModel.getProject_nameen())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�����Ū��� Project �����ѧ���";
			getMapAddProject();
			return "input";
		}else if(!cValidate.DoubleIsZero(proModel.getExam_score())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�����Ť�ṹ���";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getScore_pass())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡��ṹ�����������ö��ҹ��ਤ��";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getTeacher_id())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�������Ҩ�������֡��";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getCourse_id())){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�����Ť���ʡ�����¹�������ਤ";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(inputStudentId)){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�����Źѡ���¹����������ਤ";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(inputTeacherId)){
			alertStatus = "red red-text";
			alertMessage = "��سҡ�͡�������Ҩ���������ͺ";
			getMapAddProject();
			return "input";
		}
		
		int projectId = projectDB.addProject(proModel);
		if( projectId > 0 ){
			
			projectDB.updateProjectToStudent(projectId, inputStudentId.split(","));
			projectDB.addProjectExaminer(projectId, inputTeacherId.split(","));
			
			alertStatus = "green green-text";
			alertMessage = "���������� Project �����";
			forwardText = "success";
		}
		
		listProModel = projectDB.getListProject();
		
		return forwardText;
	}
	
	public void getMapAddProject(){
		mapTeacher = teachDB.getMapTeacher();
		CourseModel couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		mapCourse = courseDB.getMapCourse(couModel);
		mapStudent = studentDB.getMapStudent();
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

	public ProjectModel getProModel() {
		return proModel;
	}

	public void setProModel(ProjectModel proModel) {
		this.proModel = proModel;
	}

	public List<ProjectModel> getListProModel() {
		return listProModel;
	}

	public void setListProModel(List<ProjectModel> listProModel) {
		this.listProModel = listProModel;
	}

}
