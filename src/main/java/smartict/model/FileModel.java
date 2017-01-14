package smartict.model;

import java.util.List;

public class FileModel {
	String fileId, fileGroupId, fileGroupNameTh, fileGroupNameEn,
		fileNameTh, fileNameEn, filePath, addedDateTime,
		contentType;
	List<FileModel> listFile;

	public FileModel() {
		super();

	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileGroupId() {
		return fileGroupId;
	}

	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}

	public String getFileGroupNameTh() {
		return fileGroupNameTh;
	}

	public void setFileGroupNameTh(String fileGroupNameTh) {
		this.fileGroupNameTh = fileGroupNameTh;
	}

	public String getFileGroupNameEn() {
		return fileGroupNameEn;
	}

	public void setFileGroupNameEn(String fileGroupNameEn) {
		this.fileGroupNameEn = fileGroupNameEn;
	}

	public String getFileNameTh() {
		return fileNameTh;
	}

	public void setFileNameTh(String fileNameTh) {
		this.fileNameTh = fileNameTh;
	}

	public String getFileNameEn() {
		return fileNameEn;
	}

	public void setFileNameEn(String fileNameEn) {
		this.fileNameEn = fileNameEn;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getAddedDateTime() {
		return addedDateTime;
	}

	public void setAddedDateTime(String addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<FileModel> getListFile() {
		return listFile;
	}

	public void setListFile(List<FileModel> listFile) {
		this.listFile = listFile;
	}
	
	
}
