package smartict.person.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.joda.time.DateTime;

import java.io.IOException;
import java.sql.*;

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
				+ "INNER JOIN provinces as province on (teach.addr_provinceid = province.PROVINCE_ID) "
				+ "INNER JOIN amphures as aumphure on (teach.addr_aumphurid = aumphure.AMPHUR_ID) "
				+ "INNER JOIN districts as district on (teach.addr_districtid = district.DISTRICT_ID) where ";
		
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
				
				teachModel = new TeacherModel(rs.getString("firstname"), rs.getString("lastname"), rs.getString("identification"), rs.getString("addr_no"), 
 						rs.getString("addr_bloc"), rs.getString("addr_village"), rs.getString("addr_alley"), rs.getString("addr_road"),
 						rs.getString("addr_provinceid"), rs.getString("addr_aumphurid"), rs.getString("addr_districtid"), rs.getString("addr_zipcode"), 
 						rs.getString("tel_number"), rs.getString("email"), rs.getString("line_id"), rs.getString("username"), 
 						rs.getString("password"), rs.getString("identification_type_name"), rs.getString("prename_name_short"), rs.getString("province_name"), 
 						rs.getString("amphur_name"), rs.getString("district_name"), rs.getDate("startdate"), rs.getDate("createdatetime"), 
 						rs.getInt("prename_id"), rs.getInt("identification_type_id"), rs.getInt("teacher_id")
 						);
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
}
