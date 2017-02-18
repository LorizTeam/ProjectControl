package smartict.study.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.BranchModel;
import smartict.model.CourseModel;
import smartict.model.FacultyModel;
import smartict.model.SectionModel;
import smartict.study.data.BranchData;
import smartict.study.data.CourseData;
import smartict.study.data.FacultyData;
import smartict.study.data.SectionData;

public class SectionAction extends ActionSupport implements SessionAware{
	SectionModel secModel;
	private Map<String,Object> sessionMap;
	CourseData courseDB = new CourseData();
	BranchData branchDB = new BranchData();
	Map<String, String> mapBraModel;
	List<CourseModel> listCourseModel;
	List<SectionModel> listSectionModel;
	
	String alertStatus, alertMessage;
	CourseModel couModel;
	SectionData secDB = new SectionData();
	
	public String addSection(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		couModel = new CourseModel(couModel.getId(), "", "", "", 0, "", "", "");
		listCourseModel = courseDB.getListcourse(couModel);
		
		if(listCourseModel.size() > 0){
			couModel = (CourseModel) listCourseModel.get(0);
		}
		
		BranchModel BraModel = new BranchModel(0, "", "", "");
		mapBraModel = branchDB.getMapBranch(BraModel);
		
		secModel.setSectionName(couModel.getCode()+"/"+secModel.getSectionYear()+"/section "+secModel.getSectionName());
		secModel.setId(couModel.getId());
		if(secDB.addSection(secModel)){
			alertStatus = "green green-text";
			alertMessage = "เพิ่มรายการ Section สำเร็จ";
			
		}else{
			alertStatus = "red red-text";
			alertMessage = "เพิ่มรายการ Section ไม่สำเร็จ";
		}
		listSectionModel = secDB.getListSection(secModel.getId());
		secModel.clearSecModel();
		
		return "input";
	}

	public SectionModel getSecModel() {
		return secModel;
	}

	public void setSecModel(SectionModel secModel) {
		this.secModel = secModel;
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

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public CourseData getCourseDB() {
		return courseDB;
	}

	public void setCourseDB(CourseData courseDB) {
		this.courseDB = courseDB;
	}

	public BranchData getBranchDB() {
		return branchDB;
	}

	public void setBranchDB(BranchData branchDB) {
		this.branchDB = branchDB;
	}

	public Map<String, String> getMapBraModel() {
		return mapBraModel;
	}

	public void setMapBraModel(Map<String, String> mapBraModel) {
		this.mapBraModel = mapBraModel;
	}

	public List<CourseModel> getListCourseModel() {
		return listCourseModel;
	}

	public void setListCourseModel(List<CourseModel> listCourseModel) {
		this.listCourseModel = listCourseModel;
	}

	public CourseModel getCouModel() {
		return couModel;
	}

	public void setCouModel(CourseModel couModel) {
		this.couModel = couModel;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<SectionModel> getListSectionModel() {
		return listSectionModel;
	}

	public void setListSectionModel(List<SectionModel> listSectionModel) {
		this.listSectionModel = listSectionModel;
	}
	
	
	
}
