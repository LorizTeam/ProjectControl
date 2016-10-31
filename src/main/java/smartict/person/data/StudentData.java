package smartict.person.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.util.DBConnect;
import smartict.util.DateUtil;
import smartict.util.Validate;
import smartict.model.*;
public class StudentData {
	
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	Validate cValidate = new Validate();
	public boolean hasAddStudent(){
		boolean hasAddStudent = false;
		String sql ="insert into student (student_id, firstname, lastname, identification, "
				+ "identification_type, tel_number, email, line_id, "
				+ "createdatetime, username, password, branch_id, "
				+ "prename_id) values ()";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddStudent = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hasAddStudent;
	}
	public Map<String, String> getMapStudent(){
		String sql ="SELECT * FROM student inner JOIN pre_name as pre on (student.prename_id = pre.prename_id)";
		Map<String, String> mapStudent = new HashMap<String, String>();
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				mapStudent.put("", "Choose your option");
			while (rs.next()) {
				
				mapStudent.put(rs.getString("student_id"), rs.getString("prename_name_short")+" "+rs.getString("firstname")+" "+rs.getString("lastname"));
				
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapStudent;
	}
	
	public List<StudentModel> getListStudentModel(){
		String sql ="SELECT student.student_id, student.firstname, student.lastname, pre.prename_name_short, "
							+ "bra.branch_nameth, fac.faculty_nameth "
				+ "FROM student "
				+ "inner JOIN pre_name as pre on (student.prename_id = pre.prename_id) "
				+ "inner join branch as bra on (student.branch_id = bra.branch_id) "
				+ "inner join faculty as fac on (bra.faculty_id = fac.faculty_id)";
		List<StudentModel> listStudentModel = new ArrayList<StudentModel>(); 
		
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentModel stdModel = new StudentModel();
				stdModel.setPrename_name_short(rs.getString("prename_name_short"));
				stdModel.setStudent_id(rs.getString("student_id"));
				stdModel.setFirstname(rs.getString("firstname"));
				stdModel.setLastname(rs.getString("lastname"));
				stdModel.setBranch_nameth(rs.getString("branch_nameth"));
				stdModel.setFaculty_nameth(rs.getString("faculty_nameth"));
				listStudentModel.add(stdModel);
				
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudentModel;
	}
}
