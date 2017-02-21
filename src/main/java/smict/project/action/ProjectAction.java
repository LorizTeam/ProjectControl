package smict.project.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.CourseModel;
import smartict.model.ProjectModel;
import smartict.model.SectionModel;
import smartict.model.TeacherExamProjectModel;
import smartict.person.data.StudentData;
import smartict.person.data.TeacherData;
import smartict.study.data.CourseData;
import smartict.study.data.SectionData;
import smartict.util.Validate;
import smict.project.data.ProjectData;

public class ProjectAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> sessionMap;
	ProjectModel proModel;
	ProjectData projectDB = new ProjectData();
	TeacherData teachDB = new TeacherData();
	StudentData studentDB = new StudentData();
	CourseData courseDB = new CourseData();
	SectionData secDB = new SectionData();
	String inputStudentId, inputTeacherId, alertStatus, alertMessage;
	Validate cValidate = new Validate();
	Map<String, String> mapTeacher, mapCourse, mapStudent, mapExaminer, mapSection;
	List<ProjectModel> listProModel;
	List<String> listExaminer, listStudent;
	List<TeacherExamProjectModel> listTeacherExamProject;
	List<SectionModel> listSectionModel;
	int addScore1, addScore2, addScore3;
	
	public String viewProjectAll(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listProModel = projectDB.getListProject("project_id", "", "", "");
		
		return forwardText;
	}
	
	public String viewMyProjectHeaderProject(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		String studentId, teacherId; 
		studentId = teacherId = "";
		
		if(sessionMap.get("type").toString().equals("1")){
			teacherId = sessionMap.get("username").toString();
		}else{
			studentId = sessionMap.get("username").toString();
		}
		
		listProModel = projectDB.getListProject("project_id", teacherId, studentId, "");
		
		return forwardText;
	}
	
	public String viewProjectSequence(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listProModel = projectDB.getListProject("exam_number", "", "", "1,2,3");
		
		return forwardText;
	}
	
	public String viewProjectDetail(){
		String forwardText = "success";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		proModel = projectDB.getProjectModelValue(proModel);
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		listTeacherExamProject = projectDB.getListTeacherExamProjectModel(proModel);
		
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
		
		proModel = projectDB.getTeacherAddExamScoreStatus(proModel);
		//projectDB.addProjectExamScore(proModel);
		proModel.setTeacher_id(Integer.parseInt(sessionMap.get("username").toString()));
		proModel.setScore1(addScore1);
		proModel.setScore2(addScore2);
		proModel.setScore3(addScore3);
		projectDB.updateProjectExaminer(proModel);
		projectDB.updateProjectStatus(proModel);
		
		
		
		return forwardText;
	}
	
	public void validateAddExamScore(){
		
		proModel = projectDB.getProjectModelValue(proModel);
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		getMapAddProject();
		
		if(addScore1 > proModel.getScore1()) addFieldError("addScore1", "ไม่สามารถเพิ่มคะแนนเกิน "+ proModel.getScore1() +" ได้");
		
		if(addScore2 > proModel.getScore2()) addFieldError("addScore2", "ไม่สามารถเพิ่มคะแนนเกิน "+ proModel.getScore2() +" ได้");
		
		if(addScore3 > proModel.getScore3()) addFieldError("addScore3", "ไม่สามารถเพิ่มคะแนนเกิน "+ proModel.getScore3() +" ได้");
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
					System.out.println("min : "+listMinMax.get(0));
					System.out.println("max : "+listMinMax.get(1));
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
		
		listProModel = projectDB.getListProject("exam_number", "", "", "");
		
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
		}else if(!cValidate.checkIntegerNotZero(proModel.getTeacher_id())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลอาจารย์ที่ปรึกษา";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getScore4())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลคะแนน สอบครั้งที่ 1";
			getMapAddProject();
			return "input";
		}else if(proModel.getScore4() > 40){
			alertStatus = "red red-text";
			alertMessage = "ไม่สามารถให้คะแนนการสอบครั้งที่ 1 ได้มากกว่า 40 คะแนน";
			getMapAddProject();
			return "input";
		}else if(!cValidate.checkIntegerNotZero(proModel.getCourse_id())){
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูลคอร์สการเรียนให้แก่โปรเจค";
			getMapAddProject();
			return "input";
		}
		
		proModel.setScore1(30);
		proModel.setScore2(20);
		proModel.setScore3(20);
		
		int projectId = projectDB.addProject(proModel);
		if( projectId > 0 ){
			/*
			projectDB.updateProjectToStudent(projectId, inputStudentId.split(","));
			projectDB.addProjectExaminer(projectId, inputTeacherId.split(","));
			*/
			alertStatus = "green green-text";
			alertMessage = "เพิ่มข้อมูล Project สำเร็จ";
			forwardText = "success";
		}
		
		listProModel = projectDB.getListProject("project_id" , "", "", "");
		
		return forwardText;
	}
		
	public String updateProject(){
		String forwardText = "";
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		if(projectDB.updateProject(proModel)){
			projectDB.updateProjectToStudent(proModel.getProject_id(), inputStudentId.split(","));
			projectDB.addProjectExaminer(proModel.getProject_id(), inputTeacherId.split(","));
			alertStatus = "green green-text";
			alertMessage = "Update รายการสำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "Update รายการไม่สำเร็จ";
		}
		
		
		
		listExaminer = projectDB.getListExaminerInProject(proModel);
		listStudent = projectDB.getListStudentInProject(proModel);
		listTeacherExamProject = projectDB.getListTeacherExamProjectModel(proModel);
		proModel = projectDB.getProjectModelValue(proModel);
		proModel.setCanAddExamScore(projectDB.isAvailableInput(sessionMap.get("username").toString(), proModel.getProject_id()));
		getMapAddProject();
		
		return SUCCESS;
	}
	
	public String deleteProject(){
		
		boolean isDeleted = projectDB.deletedProject(proModel);
		if(isDeleted){
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูล Project สำเร็จ";
		}
		listProModel = projectDB.getListProject("project_id" , "", "", "");
		return SUCCESS;
	}
	
	public void getMapAddProject(){
		mapTeacher = teachDB.getMapTeacher();
		CourseModel couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		mapCourse = courseDB.getMapCourse(couModel);
		mapExaminer = teachDB.getMapTeacherForMultiselect();
		
		if(proModel != null){
			mapStudent = studentDB.getMapStudent(proModel.getSectionId());
			mapSection = secDB.getMapSection(proModel.getCourse_id());
		}
		
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

	public List<TeacherExamProjectModel> getListTeacherExamProject() {
		return listTeacherExamProject;
	}

	public void setListTeacherExamProject(List<TeacherExamProjectModel> listTeacherExamProject) {
		this.listTeacherExamProject = listTeacherExamProject;
	}

	public List<SectionModel> getListSectionModel() {
		return listSectionModel;
	}

	public void setListSectionModel(List<SectionModel> listSectionModel) {
		this.listSectionModel = listSectionModel;
	}

	public Map<String, String> getMapSection() {
		return mapSection;
	}

	public void setMapSection(Map<String, String> mapSection) {
		this.mapSection = mapSection;
	}

	public int getAddScore1() {
		return addScore1;
	}

	public void setAddScore1(int addScore1) {
		this.addScore1 = addScore1;
	}

	public int getAddScore2() {
		return addScore2;
	}

	public void setAddScore2(int addScore2) {
		this.addScore2 = addScore2;
	}

	public int getAddScore3() {
		return addScore3;
	}

	public void setAddScore3(int addScore3) {
		this.addScore3 = addScore3;
	}
	
	

}
