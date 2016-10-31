package smartict.person.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import smartict.model.PersonModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;

public class PersonData {
	
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();

	public PersonModel getEmployeeDetail(String username, String password){
		
		String sql = "SELECT * FROM `employee` where username = '"+username+"' and password = '"+password+"'";
		PersonModel persModel = new PersonModel();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				persModel.setFirstname(rs.getString("firstname"));
				persModel.setLastname(rs.getString("lastname"));
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
		
		return persModel;
	}
	
	public PersonModel getStudentDetail(String username, String password){
		
		String sql = "SELECT * FROM `student` where username = '"+username+"' and password = '"+password+"'";
		PersonModel persModel = new PersonModel();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				persModel.setFirstname(rs.getString("firstname"));
				persModel.setLastname(rs.getString("lastname"));
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
		
		return persModel;
	}

	public PersonModel getTeacherDetail(String username, String password){
		
		String sql = "SELECT * FROM `teacher` where username = '"+username+"' and password = '"+password+"'";
		PersonModel persModel = new PersonModel();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				persModel.setFirstname(rs.getString("firstname"));
				persModel.setLastname(rs.getString("lastname"));
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
		
		return persModel;
	}
	
	public Map<String, String> getMapPrename(){
		String sql ="SELECT * FROM pre_name";
		Map<String, String> mapPrename = new HashMap<String, String>();
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			mapPrename.put("", "Choose your option");
			while (rs.next()) {
				
				mapPrename.put(rs.getString("prename_id"), rs.getString("prename_name_short"));
				
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapPrename;
	}
}
