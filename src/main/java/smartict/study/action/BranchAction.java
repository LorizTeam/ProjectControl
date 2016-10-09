package smartict.study.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.BranchModel;
import smartict.model.FacultyModel;
import smartict.study.data.BranchData;
import smartict.study.data.FacultyData;
import smartict.util.Validate;

public class BranchAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> sessionMap;
	BranchModel braModel;
	Map<String, String> mapFacModel;
	FacultyData facDB = new FacultyData();
	String alertStatus, alertMessage;
	List<BranchModel> listBranchModel;
	
	public BranchModel getBraModel() {
		return braModel;
	}

	public void setBraModel(BranchModel braModel) {
		this.braModel = braModel;
	}

	public Map<String, String> getMapFacModel() {
		return mapFacModel;
	}

	public void setMapFacModel(Map<String, String> mapFacModel) {
		this.mapFacModel = mapFacModel;
	}
	
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
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

	public List<BranchModel> getListBranchModel() {
		return listBranchModel;
	}

	public void setListBranchModel(List<BranchModel> listBranchModel) {
		this.listBranchModel = listBranchModel;
	}
	
	public String viewAllBranch(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		braModel = new BranchModel(0, "", "", "", 0, "", "", "");
		listBranchModel = branchDB.getListBranch(braModel);
		
		return forwardText;
	}
	
	public String viewBranchDetail(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		braModel = new BranchModel(braModel.getId(), "", "", "", 0, "", "", "");
		listBranchModel = branchDB.getListBranch(braModel);
		
		if(listBranchModel.size() > 0){
			braModel = (BranchModel) listBranchModel.get(0);
		}
		
		FacultyModel setfacModel = new FacultyModel(0, "", "", "");
		mapFacModel = facDB.getMapFaculty(setfacModel);
		return forwardText;
	}
	
	public String updateBranch(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		
		if(branchDB.updateBranch(braModel)){
			alertStatus = "green green-text";
			alertMessage = "แก้ไขข้อมูลคณะสำเร็จ";
		}
		
		FacultyModel setfacModel = new FacultyModel(0, "", "", "");
		mapFacModel = facDB.getMapFaculty(setfacModel);
		return forwardText;
	}
	
	public String deleteBranch(){
		if(!sessionMap.containsKey("username"))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		BranchData branchDB = new BranchData();
		
		if(branchDB.deleteBranch(braModel))
		{
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูลคณะสำเร็จ";
		}
		
		braModel = new BranchModel(0, "", "", "", 0, "", "", "");
		listBranchModel = branchDB.getListBranch(braModel);
		
		return forwardText;
	}

	public String inputBranchData(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		String forwardText = "success";
		FacultyModel setfacModel = new FacultyModel(0, "", "", "");
		mapFacModel = facDB.getMapFaculty(setfacModel);
		
		return forwardText;
	}
	
	public String addBranch(){
		if(!sessionMap.containsKey("username"))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		Validate aValidate = new Validate();
		String forwardText = "success";
		
		//Validate Input Before Add
		if(!aValidate.Check_String_notnull_notempty(braModel.getCode()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล Code ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.Check_String_notnull_notempty(braModel.getNameth()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล ชื่อสาขาภาษาไทย ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.Check_String_notnull_notempty(braModel.getNameen()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณากรอกข้อมูล ชื่อสาขาภาษาอังกฤษ ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		else if(!aValidate.checkIntegerNotZero(braModel.getFacultyId()))
		{
			alertStatus = "red red-text";
			alertMessage = "กรุณาเลือกคณะ ก่อนทำการเพิ่มข้อมูล";
			forwardText = "inputbranch";
		}
		
		
		//Check After Validate
		if(forwardText.equals("inputbranch"))
		{
			FacultyModel setfacModel = new FacultyModel(0, "", "", "");
			mapFacModel = facDB.getMapFaculty(setfacModel);
		}
		else
		{
			//passed input validate
			BranchData branchDB = new BranchData();
			if(branchDB.addBranch(braModel))
			{
				alertStatus = "green green-text";
				alertMessage = "เพิ่มข้อมูลสาขาเรียบร้อย";
				
				braModel = new BranchModel(0, "", "", "", 0, "", "", "");
				listBranchModel = branchDB.getListBranch(braModel);
			}
			
		}
		
		return forwardText;
	}
}
