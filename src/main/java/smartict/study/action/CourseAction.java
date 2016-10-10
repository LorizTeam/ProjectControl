package smartict.study.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.BranchModel;
import smartict.model.CourseModel;
import smartict.model.FacultyModel;
import smartict.study.data.BranchData;
import smartict.study.data.CourseData;
import smartict.util.Validate;

public class CourseAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> sessionMap;
	CourseData courseDB = new CourseData();
	BranchData branchDB = new BranchData();
	Map<String, String> mapBraModel;
	List<CourseModel> listCourseModel;
	String alertStatus, alertMessage;
	CourseModel couModel;
	
	public CourseModel getCouModel() {
		return couModel;
	}

	public void setCouModel(CourseModel couModel) {
		this.couModel = couModel;
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

	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
	public String inputCourseData(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchModel BraModel = new BranchModel(0, "", "", "");
		mapBraModel = branchDB.getMapBranch(BraModel);
		
		return forwardText;
	}
	
	public String addCourse(){
		if(!sessionMap.containsKey("username"))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		Validate aValidate = new Validate();
		String forwardText = "success";
		
		//Validate Input Before Add
		if(!aValidate.Check_String_notnull_notempty(couModel.getCode()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล Code ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.Check_String_notnull_notempty(couModel.getNameth()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล ชื่อคอร์สภาษาไทย ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.Check_String_notnull_notempty(couModel.getNameen()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล ชื่อคอร์สภาษาอังกฤษ ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.checkIntegerNotZero(couModel.getBranchId()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาเลือกสาขา ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		
		
		//Check After Validate
		if(forwardText.equals("inputbranch"))
		{
			BranchModel BraModel = new BranchModel(0, "", "", "");
			mapBraModel = branchDB.getMapBranch(BraModel);
		}
		else
		{
			//passed input validate
			
			if(courseDB.addCourse(couModel))
			{
				alertStatus = "grcouModeln-text";
				alertMessage = "เพิ่มข้อมูลคอร์สเรียบร้อย";
				
				couModel = new CourseModel(0, "", "", "", 0, "", "", "");
				listCourseModel = courseDB.getListcourse(couModel);
			}
			
		}
		
		return forwardText;
	}
	
	public String viewAllCourse(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		listCourseModel = courseDB.getListcourse(couModel);
		
		return forwardText;
	}
	
	public String viewCourseDetail(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		couModel = new CourseModel(couModel.getId(), "", "", "", 0, "", "", "");
		listCourseModel = courseDB.getListcourse(couModel);
		
		if(listCourseModel.size() > 0){
			couModel = (CourseModel) listCourseModel.get(0);
		}
		
		BranchModel BraModel = new BranchModel(0, "", "", "");
		mapBraModel = branchDB.getMapBranch(BraModel);
		return forwardText;
	}
	
	public String updateCourse(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		
		if(courseDB.updateCourse(couModel)){
			alertStatus = "green green-text";
			alertMessage = "แก้ไขข้อมูลคอร์สสำเร็จ";
		}
		
		BranchModel BraModel = new BranchModel(0, "", "", "");
		mapBraModel = branchDB.getMapBranch(BraModel);
		return forwardText;
	}
	
	public String deleteCourse(){
		if(!sessionMap.containsKey("username"))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		
		if(courseDB.deleteCourse(couModel))
		{
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูลคอร์สสำเร็จ";
		}
		
		couModel = new CourseModel(0, "", "", "", 0, "", "", "");
		listCourseModel = courseDB.getListcourse(couModel);
		
		return forwardText;
	}
}
