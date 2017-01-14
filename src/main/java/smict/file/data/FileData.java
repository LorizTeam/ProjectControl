package smict.file.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.model.CourseModel;
import smartict.model.FileModel;
import smartict.util.DBConnect;

public class FileData {
	DBConnect dbcon = new DBConnect();
	
	public List<FileModel> getListFileGroupModel(){
		String sql = "select * from File_group";
		List<FileModel> listFileGroup = new ArrayList<FileModel>();
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				FileModel aFileModel = new FileModel();
				aFileModel.setFileGroupId(rs.getString("filegroup_id"));
				aFileModel.setFileGroupNameTh(rs.getString("filegroup_nameth"));
				aFileModel.setFileGroupNameEn(rs.getString("filegroup_nameen"));
				listFileGroup.add(aFileModel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listFileGroup;
	}
	
	public List<FileModel> getListFileModel(){
		String sql = "select * from File_path "
				+ "INNER JOIN File_group on (File_path.filegroup_id = File_group.filegroup_id)";
		List<FileModel> listFileModel = new ArrayList<FileModel>();
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				FileModel aFileModel = new FileModel();
				aFileModel.setFileId(rs.getString("file_id"));
				aFileModel.setFileNameTh(rs.getString("file_nameth"));
				aFileModel.setFileNameEn(rs.getString("file_nameen"));
				aFileModel.setFilePath(rs.getString("file_path"));
				aFileModel.setContentType(rs.getString("content_type"));
				aFileModel.setAddedDateTime(rs.getString("added_datetime"));
				aFileModel.setFileGroupNameTh(rs.getString("filegroup_nameth"));
				listFileModel.add(aFileModel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listFileModel;
	}
	
	public List<FileModel> getListFileModel(FileModel fileModel){
		String sql = "select * from File_path where filegroup_id = '"+fileModel.getFileGroupId()+"' ";
		List<FileModel> listFileModel = new ArrayList<FileModel>();
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				FileModel aFileModel = new FileModel();
				aFileModel.setFileId(rs.getString("file_id"));
				aFileModel.setFileNameTh(rs.getString("file_nameth"));
				aFileModel.setFileNameEn(rs.getString("file_nameen"));
				aFileModel.setFilePath(rs.getString("file_path"));
				aFileModel.setContentType(rs.getString("content_type"));
				aFileModel.setAddedDateTime(rs.getString("added_datetime"));
				listFileModel.add(aFileModel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listFileModel;
	}
	
	public Map<String, String> getMapFileGroup(){
		String sql = "select * from File_group";
		Map<String, String> mapFileGroup = new HashMap<String, String>();
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mapFileGroup.put(rs.getString("filegroup_id"), rs.getString("filegroup_nameth"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapFileGroup;
	}
	
	public boolean deleteFileGroup(FileModel aFileModel){
		String sql = "delete from File_group where filegroup_id = '"+aFileModel.getFileGroupId()+"'";
						
		
		boolean hasDeleteCourse = false;
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteCourse = true;
			}
			
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteCourse;
	}
	
	public boolean deleteFile(FileModel aFileModel){
		String sql = "delete from File_path where file_id = '"+aFileModel.getFileId()+"'";
						
		
		boolean hasDeleteCourse = false;
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteCourse = true;
			}
			
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteCourse;
	}
	
	public boolean addFileGroup(FileModel aFileModel){
		String sql = "insert into File_group (filegroup_nameth, filegroup_nameen) "
				+ "values "
				+ "('"+aFileModel.getFileGroupNameTh()+"', '"+aFileModel.getFileGroupNameEn()+"')";
						
		
		boolean hasDeleteCourse = false;
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteCourse = true;
			}
			
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteCourse;
	}
	
	public boolean addFile(FileModel aFileModel){
		String sql = "insert into File_path (file_nameth, file_nameen, file_path, content_type,"
				+ "added_datetime, filegroup_id) "
				+ "values "
				+ "('"+aFileModel.getFileNameTh()+"', '"+aFileModel.getFileNameEn()+"', '"+aFileModel.getFilePath()+"', '"+aFileModel.getContentType()+"', "
				+ "now(), '"+aFileModel.getFileGroupId()+"')";
						
		
		boolean hasDeleteCourse = false;
		try {
			Connection conn = dbcon.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteCourse = true;
			}
			
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteCourse;
	}
}
