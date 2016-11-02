package smartict.person.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.joda.time.DateTime;

import java.io.IOException;
import java.sql.*;

import smartict.model.StudentModel;
import smartict.model.TeacherModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;
import smartict.util.Validate;

public class TeacherData {
	
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	Validate cValidate = new Validate();
	
	public List<TeacherModel> listTeacherModel(TeacherModel teachModel){
		
		String sql ="SELECT * FROM teacher as teach "
				+ "Inner JOIN identification_type identype on (teach.identification_type_id = identype.identification_type_id) "
				+ "inner JOIN pre_name as pre on (teach.prename_id = pre.prename_id) "
				+ "where ";
		
		if(cValidate.checkIntegerNotZero(teachModel.getTeacher_id()) ){
			sql += "teacher_id = "+teachModel.getTeacher_id()+ " and ";
		}
		
		sql += "teacher_id > 0 ";
		
		List<TeacherModel> listTeacherModel = new ArrayList<TeacherModel>();
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				teachModel = new TeacherModel();
				teachModel.setTeacher_id(rs.getInt("teacher_id"));
				teachModel.setFirstname(rs.getString("firstname"));
				teachModel.setLastname(rs.getString("lastname"));
				teachModel.setIdentification(rs.getString("identification"));
				teachModel.setTel_number(rs.getString("tel_number"));
				teachModel.setEmail(rs.getString("email"));
				teachModel.setLine_id(rs.getString("line_id"));
				teachModel.setPrename_name_short(rs.getString("prename_name_short"));
				teachModel.setCreatedatetime(rs.getDate("createdatetime"));
				
				listTeacherModel.add(teachModel);
				
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
		
		return listTeacherModel;
	}
	
	public Map<String, String> getMapTeacher(){
		String sql ="SELECT * FROM teacher as teach inner JOIN pre_name as pre on (teach.prename_id = pre.prename_id)";
		Map<String, String> mapTeacher = new HashMap<String, String>();
		try {
				
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next()) {
				
				mapTeacher.put(rs.getString("teacher_id"), rs.getString("prename_name_short")+" "+rs.getString("firstname")+" "+rs.getString("lastname"));
				
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
		
		return mapTeacher;
	}
	
	public Map<String, String> getMapTeacherForMultiselect(){
		String sql ="SELECT * FROM teacher as teach inner JOIN pre_name as pre on (teach.prename_id = pre.prename_id)";
		Map<String, String> mapTeacher = new HashMap<String, String>();
		try {
				
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				mapTeacher.put("", "Choose your option");
			while (rs.next()) {
				
				mapTeacher.put(rs.getString("teacher_id"), rs.getString("prename_name_short")+" "+rs.getString("firstname")+" "+rs.getString("lastname"));
				
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
		
		return mapTeacher;
	}
	
	public boolean hasAddTeacher(TeacherModel teaModel){
		boolean hasAddTeacher = false;
		String sql ="insert into teacher (teacher_id, firstname, lastname, identification, "
				+ "identification_type_id, tel_number, email, line_id, "
				+ "createdatetime, username, password, prename_id) "
				+ "values "
				+ "('"+teaModel.getTeacher_id()+"','"+teaModel.getFirstname()+"','"+teaModel.getLastname()+"','"+teaModel.getIdentification()+"',"
				+ "'"+teaModel.getIdentification_type_id()+"','"+teaModel.getTel_number()+"','"+teaModel.getEmail()+"','"+teaModel.getLine_id()+"',"
				+ "now(),'"+teaModel.getTeacher_id()+"','12345','"+teaModel.getPrename_id()+"')";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddTeacher = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hasAddTeacher;
	}
}
