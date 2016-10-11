package smartict.study.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.model.CourseModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;

public class CourseData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	
	public boolean addCourse(CourseModel couModel){
		String sql = "insert into course (course_code, course_nameth, course_nameen, branch_id) values "
						+ "('"+couModel.getCode()+"', '"+couModel.getNameth()+"', '"+couModel.getNameen()+"', '"+couModel.getBranchId()+"')";
		
		boolean hasAddFaculty = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddFaculty = true;
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
		return hasAddFaculty;
	}
	
	public boolean updateCourse(CourseModel couModel){
		String sql = "update course set course_code = '"+couModel.getCode()+"', course_nameth = '"+couModel.getNameth()+"', "
						+ "course_nameen = '"+couModel.getNameen()+"', course_id = "+couModel.getBranchId()+" where course_id = '"+couModel.getId()+"'";
						
		
		boolean hasAddFaculty = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddFaculty = true;
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
		return hasAddFaculty;
	}
	
	public boolean deleteCourse(CourseModel couModel){
		String sql = "delete from course where course_id = '"+couModel.getId()+"'";
						
		
		boolean hasDeleteCourse = false;
		try {
			Connection conn = agent.getConnectMYSql();
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
	
	public List<CourseModel> getListcourse(CourseModel couModel){
		
		String sql = "select * from course inner join branch on (course.branch_id = branch.branch_id) where ";
		
		if(couModel.getId() > 0) 
			sql += "course_id = '"+couModel.getId()+"' and ";
		
		if(!couModel.getCode().equals("")) 
			sql += "course_code = '"+couModel.getCode()+"' and ";
		
		if(!couModel.getNameth().equals("")) 
			sql += "course_nameth = '"+couModel.getNameth()+"' and ";
		
		if(!couModel.getNameen().equals("")) 
			sql += "course_nameen = '"+couModel.getNameen()+"' and ";
		
		sql += "course_id > 0";
		
		List<CourseModel> listcouModel = new ArrayList<CourseModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				listcouModel.add(new CourseModel(rs.getInt("course_id"), rs.getString("course_code"), rs.getString("course_nameth"), rs.getString("course_nameen"), 
									rs.getInt("branch_id"), rs.getString("branch_code"), rs.getString("branch_nameth"), rs.getString("branch_nameen")));
			}
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listcouModel;
	}
	
	public Map<String, String> getMapCourse(CourseModel couModel){
		
		String sql = "select * from course where ";
		
		if(couModel.getId() > 0) 
			sql += "course_id = '"+couModel.getId()+"' and ";
		
		if(!couModel.getCode().equals("")) 
			sql += "course_code = '"+couModel.getCode()+"' and ";
		
		if(!couModel.getNameth().equals("")) 
			sql += "course_nameth = '"+couModel.getNameth()+"' and ";
		
		if(!couModel.getNameen().equals("")) 
			sql += "course_nameen = '"+couModel.getNameen()+"' and ";
		
		sql += "course_id > 0";
		
		Map<String, String> mapBra = new HashMap<String, String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				mapBra.put(rs.getString("course_id"), rs.getString("course_nameth"));
				
			}
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapBra;
	}
}
