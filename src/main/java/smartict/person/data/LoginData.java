package smartict.person.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import smartict.util.DBConnect;
import smartict.util.DateUtil;

public class LoginData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	
	public boolean isTeacherUser(String username, String password){
		
		String sql = "select * from teacher where username = '"+username+"' and password = '"+password+"'";
		
		boolean isTeacher = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isTeacher = true;
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
		
		return isTeacher;
	}
	
	public boolean isStudentUser(String username, String password){
		
		String sql = "select * from student where username = '"+username+"' and password = '"+password+"'";
		
		boolean isStudent = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isStudent = true;
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
		
		return isStudent;
	}

	public boolean isEmployeeUser(String username, String password){
		
		String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
		
		boolean isStudent = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isStudent = true;
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
		
		return isStudent;
	}
}
