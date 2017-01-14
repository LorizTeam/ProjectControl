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
	
	public boolean hasUpdatePassword(String username, String password, String type){
		boolean hasUpdate = false;
		String tableName = "";
		if(type.equals("1")){
			tableName = "teacher";
		}else if(type.equals("2")){
			tableName = "student";
		}else if(type.equals("3")){
			tableName = "employee";
		}
		String sql = "update "+tableName+" set username = '"+username+"', password = '"+password+"' where username = '"+username+"'";
		PersonModel persModel = new PersonModel();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasUpdate = true;
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
		
		return hasUpdate;
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
