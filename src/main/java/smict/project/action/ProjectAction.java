package smict.project.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

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
	String inputStudentId, inputTeacherId, alertStatus, alertMessage;
	Validate cValidate = new Validate();
	Map<String, String> mapTeacher, mapCourse, mapStudent, mapExaminer;
	List<ProjectModel> listProModel;
	List<String> listExaminer, listStudent;
	
	public String viewProjectAll(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listProModel = projectDB.getListProject("project_id");
		
		return forwardText;
	}
	
	public String viewProjectSequence(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listProModel = projectDB.getListProject("exam_number");
		
		return forwardText;
	}
	
	public String viewProjectDetail(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		System.out.println("Username : "+sessionMap.get("username").toString());
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		proModel = projectDB.getProjectModelValue(proModel);
		proModel.setCanAddExamScore(projectDB.isAvailableInput(sessionMap.get("username").toString(), proModel.getProject_id()));
		getMapAddProject();
		return forwardText;
	}
	
	public String viewProjectDetailExam(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(sessionMap.get("type").equals("1")){
			String username = sessionMap.get("username").toString();
			proModel.setTeacher_id(projectDB.getTeacherId(username));
		}
		
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		proModel = projectDB.getProjectModelValue(proModel);
		proModel = projectDB.getTeacherAddExamScoreStatus(proModel);
		
		getMapAddProject();
		return forwardText;
	}
	
	public String addExamScore(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		proModel = projectDB.getProjectModelValue(proModel);
		proModel = projectDB.getTeacherAddExamScoreStatus(proModel);
		projectDB.addProjectExamScore(proModel);
		proModel.setTeacher_id(Integer.parseInt(sessionMap.get("username").toString()));
		projectDB.updateProjectExaminer(proModel);
		projectDB.updateProjectStatus(proModel);
		getMapAddProject();
		
		
		return forwardText;
	}
		
	public String inputProjectData(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		getMapAddProject();
		
		return forwardText;
	}
	
	public String randomProject(){
		String forwardText = "random";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		List<String> listProjectId = projectDB.getProjectWaitingExam();
		if(listProjectId.size() == 0){
			alertStatus = "red red-text";
			alertMessage = "ทุกโปรเจคได้ทำการสอบไปหมดแล้ว";
			return "login";
		}else{
			
			projectDB.clearExamNumberWithProjectExamScoreEmpty();
			for(int i = 0; i < listProjectId.size();i++){
				List<Integer> listMinMax = projectDB.getNumberProjectMinMax();
				
				boolean isRandomAgain = true;
				do{
					int randomNumber = projectDB.getRandomInteger(listMinMax.get(0), listMinMax.get(1));
					if(projectDB.isAvailableUseExamNumber(randomNumber)){
						proModel = new ProjectModel();
						proModel.setExam_number(randomNumber);
						proModel.setProject_id(Integer.parseInt(listProjectId.get(i)));
						projectDB.updateProjectExamNumber(proModel);
						isRandomAgain = false;
						System.out.println("Here In Loop . . . ");
					}
					
					
					
				}while(isRandomAgain);
				
			}
			
			
			
		}
		
		listProModel = projectDB.getListProject("exam_number");
		
		return forwardText;
	}
	
	public String addProject(){
		String forwardText = "";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(!cValidate.Check_String_notnull_notempty(proModel.getProject_nameth())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลชื่อ Project ภาษาไทย";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(proModel.getProject_nameen())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลชื่อ Project ภาษาอังกฤษ";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getExam_fullscore())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลคะแนนเต็ม";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getScore_pass())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกคะแนนที่ทำให้สามารถผ่านโปรเจคได้";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getTeacher_id())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลอาจารย์ที่ปรึกษา";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getCourse_id())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลคอร์สการเรียนให้แก่โปรเจค";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(inputStudentId)){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลนักเรียนที่อยู่ในโปรเจค";
			getMapAddProject();
			return "input";
		}else if(!cValidate.Check_String_notnull_notempty(inputTeacherId)){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลอาจารย์ผู้คุมสอบ";
			getMapAddProject();
			return "input";
		}
		
		int projectId = projectDB.addProject(proModel);
		if( projectId > 0 ){
			
			projectDB.updateProjectToStudent(projectId, inputStudentId.split(","));
			projectDB.addProjectExaminer(projectId, inputTeacherId.split(","));
			
			alertStatus = "green green-text";
			alertMessage = "เพิ่มข้อมูล Project สำเร็จ";
			forwardText = "success";
		}
		
		listProModel = projectDB.getListProject("project_id");
		
		return forwardText;
	}
	
	public void getMapAddProject(){
		mapTeacher = teachDB.getMapTeacher();
		CourseModel couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		mapCourse = courseDB.getMapCourse(couModel);
		mapStudent = studentDB.getMapStudent();
		mapExaminer = teachDB.getMapTeacherForMultiselect();
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

	public Map<String, String> getMapExaminer() {
		return mapExaminer;
	}

	public void setMapExaminer(Map<String, String> mapExaminer) {
		this.mapExaminer = mapExaminer;
	}

	public List<String> getListExaminer() {
		return listExaminer;
	}

	public void setListExaminer(List<String> listExaminer) {
		this.listExaminer = listExaminer;
	}

	public List<String> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<String> listStudent) {
		this.listStudent = listStudent;
	}

}
