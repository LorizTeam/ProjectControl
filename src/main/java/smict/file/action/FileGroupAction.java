package smict.file.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.FileModel;
import smict.file.data.FileData;

public class FileGroupAction extends ActionSupport implements SessionAware{
	FileModel fileModel;
	private Map<String,Object> sessionMap;
	String alertStatus, alertMessage;
	List<FileModel> listFileGroup;
	
	public String getFileGroup(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		listFileGroup = new FileData().getListFileGroupModel();
		
		return SUCCESS;
	}
	
	public String deleteFileGroup(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		FileData fileGroupDB = new FileData();
		boolean isDeleted = fileGroupDB.deleteFileGroup(fileModel);
		if(isDeleted){
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูลกลุ่มไฟล์สำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "ลบข้อมูลกลุ่มไฟล์ไม่สำเร็จ";
		}
		
		listFileGroup = fileGroupDB.getListFileGroupModel();
		
		return SUCCESS;
	}
	
	public String addFileGroup(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		FileData fileGroupDB = new FileData();
		boolean isDeleted = fileGroupDB.addFileGroup(fileModel);
		if(isDeleted){
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูลกลุ่มไฟล์สำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "ลบข้อมูลกลุ่มไฟล์ไม่สำเร็จ";
		}
		
		listFileGroup = fileGroupDB.getListFileGroupModel();
		
		return SUCCESS;
	}
	
	public FileModel getFileModel() {
		return fileModel;
	}

	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
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

	public List<FileModel> getListFileGroup() {
		return listFileGroup;
	}

	public void setListFileGroup(List<FileModel> listFileGroup) {
		this.listFileGroup = listFileGroup;
	}
	
}
