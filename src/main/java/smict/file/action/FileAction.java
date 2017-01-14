package smict.file.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import smartict.model.FileModel;
import smartict.util.Validate;
import smict.file.data.FileData;

public class FileAction extends ActionSupport implements SessionAware{
	FileModel fileModel;
	File fileUpload;
	String fileUploadContentType;
	String fileUploadFileName;
	private Map<String,Object> sessionMap;
	String alertStatus, alertMessage;
	Map<String, String> mapFileGroup;
	List<FileModel> listFileModel,listGroupFile;

	public String inputFile(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		FileData filDB = new FileData();
		mapFileGroup = filDB.getMapFileGroup();
		listFileModel = filDB.getListFileModel();
		
		return SUCCESS;
	}
	
	public String getAllFile(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		FileData filDB = new FileData();
		listGroupFile = filDB.getListFileGroupModel();
		for(FileModel afileModel : listGroupFile){
			afileModel.setListFile(filDB.getListFileModel(afileModel));
		}
		
		
		return SUCCESS;
	}
	
	public String addFile(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		FileData filDB = new FileData();
		Validate classValidate = new Validate();
		if(classValidate.Check_String_notnull_notempty(fileUploadFileName)){
			String destPath = request.getSession().getServletContext().getRealPath("/")+"../FileProjectControl";
			Date curDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			FilenameUtils.getExtension(fileUploadFileName);
			String fileType = "."+FilenameUtils.getExtension(fileUploadFileName);
			String fileName = sdf.format(curDate)+fileType;
			
			File destFile  = new File(destPath, fileName);
			File destFolder = new File(destPath);
			if(!destFolder.exists()){
				destFolder.mkdir();
			}
			
			try {
				FileUtils.copyFile(fileUpload, destFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			if(destFile.exists()){
				fileModel.setFilePath("../FileProjectControl/"+fileName);
				fileModel.setContentType(fileUploadContentType);
				filDB.addFile(fileModel);
				alertStatus = "green green-text";
				alertMessage = "Upload ไฟล์สำเร็จ";
			}else{
				alertStatus = "red red-text";
				alertMessage = "Upload ไฟล์ไม่สำเร็จ";
			}
			
		}else{
			alertStatus = "red red-text";
			alertMessage = "กรุณาเลือกไฟล์ก่อนทำการ Upload";
		}
		
		
		mapFileGroup = filDB.getMapFileGroup();
		listFileModel = filDB.getListFileModel();
		
		return SUCCESS;
	}
	
	public String deleteFile(){
		if(!sessionMap.containsKey("username")){
			alertStatus = "red red-text";
			alertMessage = "กรุณาทำการ Login ก่อนทำรายการ";
			return "login";
		}
		
		FileData filDB = new FileData();
		
		
		boolean isDeleted = filDB.deleteFile(fileModel);
		if(isDeleted){
			alertStatus = "green green-text";
			alertMessage = "ลบข้อมูลไฟล์สำเร็จ";
		}else{
			alertStatus = "red red-text";
			alertMessage = "ลบข้อมูลไฟล์ไม่สำเร็จ";
		}
		
		mapFileGroup = filDB.getMapFileGroup();
		listFileModel = filDB.getListFileModel();
		
		return SUCCESS;
	}
	
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
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

	public Map<String, String> getMapFileGroup() {
		return mapFileGroup;
	}

	public void setMapFileGroup(Map<String, String> mapFileGroup) {
		this.mapFileGroup = mapFileGroup;
	}

	public FileModel getFileModel() {
		return fileModel;
	}

	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
	}

	public List<FileModel> getListFileModel() {
		return listFileModel;
	}

	public void setListFileModel(List<FileModel> listFileModel) {
		this.listFileModel = listFileModel;
	}

	public List<FileModel> getListGroupFile() {
		return listGroupFile;
	}

	public void setListGroupFile(List<FileModel> listGroupFile) {
		this.listGroupFile = listGroupFile;
	}
}
