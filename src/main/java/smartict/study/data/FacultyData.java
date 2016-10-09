package smartict.study.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.model.FacultyModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;

public class FacultyData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	
	public boolean addFaculty(FacultyModel facModel){
		String sql = "insert into faculty (faculty_code, faculty_nameth, faculty_nameen) values "
						+ "('"+facModel.getCode()+"', '"+facModel.getNameth()+"', '"+facModel.getNameen()+"')";
		
		boolean hasAddFaculty = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddFaculty = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasAddFaculty;
	}
	
	public boolean updateFaculty(FacultyModel facModel){
		String sql = "update faculty set faculty_code = '"+facModel.getCode()+"', faculty_nameth = '"+facModel.getNameth()+"', "
						+ "faculty_nameen = '"+facModel.getNameen()+"' where faculty_id = '"+facModel.getId()+"'";
						
		
		boolean hasAddFaculty = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddFaculty = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasAddFaculty;
	}
	
	public boolean deleteFaculty(FacultyModel facModel){
		String sql = "delete from faculty where faculty_id = '"+facModel.getId()+"'";
						
		
		boolean hasDeleteFaculty = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteFaculty = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteFaculty;
	}
	
	public List<FacultyModel> getListFaculty(FacultyModel facModel){
		
		String sql = "select * from faculty where ";
		
		if(facModel.getId() > 0) 
			sql += "faculty_id = '"+facModel.getId()+"' and ";
		
		if(!facModel.getCode().equals("")) 
			sql += "faculty_code = '"+facModel.getCode()+"' and ";
		
		if(!facModel.getNameth().equals("")) 
			sql += "faculty_nameth = '"+facModel.getNameth()+"' and ";
		
		if(!facModel.getNameen().equals("")) 
			sql += "faculty_nameen = '"+facModel.getNameen()+"' and ";
		
		sql += "faculty_id > 0";
		
		List<FacultyModel> listFacModel = new ArrayList<FacultyModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				facModel = new FacultyModel();
				facModel.setId(rs.getInt("faculty_id"));
				facModel.setCode(rs.getString("faculty_code"));
				facModel.setNameth(rs.getString("faculty_nameth"));
				facModel.setNameen(rs.getString("faculty_nameen"));
				listFacModel.add(facModel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listFacModel;
	}
	
	public Map<String, String> getMapFaculty(FacultyModel facModel){
		
		String sql = "select * from faculty where ";
		
		if(facModel.getId() > 0) 
			sql += "faculty_id = '"+facModel.getId()+"' and ";
		
		if(!facModel.getCode().equals("")) 
			sql += "faculty_code = '"+facModel.getCode()+"' and ";
		
		if(!facModel.getNameth().equals("")) 
			sql += "faculty_nameth = '"+facModel.getNameth()+"' and ";
		
		if(!facModel.getNameen().equals("")) 
			sql += "faculty_nameen = '"+facModel.getNameen()+"' and ";
		
		sql += "faculty_id > 0";
		
		Map<String, String> mapFac = new HashMap<String, String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				mapFac.put(rs.getString("faculty_id"), rs.getString("faculty_nameth"));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapFac;
	}
}
