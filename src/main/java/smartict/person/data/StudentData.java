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
	public boolean hasAddStudent(StudentModel stdModel){
		boolean hasAddStudent = false;
		String sql ="insert into student (student_id, firstname, lastname, identification, "
				+ "identification_type, tel_number, email, line_id, "
				+ "createdatetime, username, password, branch_id, "
				+ "prename_id, receive_year) "
				+ "values "
				+ "('"+stdModel.getStudent_id()+"','"+stdModel.getFirstname()+"','"+stdModel.getLastname()+"','"+stdModel.getIdentification()+"',"
				+ "'"+stdModel.getIdentification_type_id()+"','"+stdModel.getTel_number()+"','"+stdModel.getEmail()+"','"+stdModel.getLine_id()+"',"
				+ "now(),'"+stdModel.getStudent_id()+"','12345','"+stdModel.getBranchId()+"',"
				+ "'"+stdModel.getPrename_id()+"', "+stdModel.getReceiveYear()+")";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAddStudent = true;
			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hasAddStudent;
	}
	
	public boolean hasUpdateStudent(StudentModel stdModel){
		boolean hasUpdateStudent = false;
		String sql ="update student set student_id = '"+stdModel.getStudent_id()+"', firstname = '"+stdModel.getFirstname()+"', lastname = '"+stdModel.getLastname()+"', identification = '"+stdModel.getIdentification()+"', "
				+ "identification_type = '"+stdModel.getIdentification_type_id()+"', tel_number = '"+stdModel.getTel_number()+"', email = '"+stdModel.getEmail()+"', line_id = '"+stdModel.getLine_id()+"', "
				+ "branch_id = '"+stdModel.getBranchId()+"',prename_id = '"+stdModel.getPrename_id()+"', "
				+ "receive_year = "+stdModel.getReceiveYear()+" "
				+ "where student_id = '"+stdModel.getOldstudent_id()+"'";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasUpdateStudent = true;
			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hasUpdateStudent;
	}
	
	public boolean hasDelete(StudentModel stdModel){
		boolean hasDelete = false;
		String sql ="delete from student where student_id = '"+stdModel.getStudent_id()+"'";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDelete = true;
			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hasDelete;
	}
	
	public boolean hasUpdatePassword(StudentModel stdModel){
		boolean hasUpdate = false;
		String sql ="update student set password = '"+stdModel.getPassword()+"'  where student_id = '"+stdModel.getUsername()+"'";
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasUpdate = true;
			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hasUpdate;
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
	
	public String countStudent(){
		String sql ="SELECT count(*) as numberStudent FROM student ";
		String numberStudent = "";
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				numberStudent = rs.getString("numberStudent");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return numberStudent;
	}
	
	public List<StudentModel> getListStudentModel(){
		String sql ="SELECT student.student_id, student.firstname, student.lastname, pre.prename_name_short, "
							+ "bra.branch_nameth, fac.faculty_nameth, student.receive_year "
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
				stdModel.setReceiveYear("รุ่น "+rs.getString("receive_year"));
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
	
	public List<StudentSectionModel> getListStudentSectionModel(String studentId){
		String sql ="SELECT "
				+ "student_section.student_id,"
				+ "student_section.section_id,"
				+ "student_section.is_study,"
				+ "student.firstname,"
				+ "student.lastname,"
				+ "section.`name`,"
				+ "section.`year`,"
				+ "section.`is_active` "
				+ "FROM "
				+ "student_section "
				+ "INNER JOIN student ON student.student_id = student_section.student_id "
				+ "INNER JOIN section ON section.id = student_section.section_id "
				+ "where ";
		
			if(cValidate.Check_String_notnull_notempty(studentId))
				sql += "student.student_id = '"+studentId+"' and ";
			
			sql += "section.id > 0 ";
		List<StudentSectionModel> listStudentModel = new ArrayList<StudentSectionModel>(); 
		
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentSectionModel stdModel = new StudentSectionModel();
				/*stdModel.setPrename_name_short(rs.getString("prename_name_short"));
				stdModel.setStudent_id(rs.getString("student_id"));
				stdModel.setFirstname(rs.getString("firstname"));
				stdModel.setLastname(rs.getString("lastname"));
				stdModel.setBranch_nameth(rs.getString("branch_nameth"));
				stdModel.setFaculty_nameth(rs.getString("faculty_nameth"));*/
				stdModel.setSectionId(rs.getInt("section_id") );
				stdModel.setSectionName(rs.getString("name"));
				stdModel.setYear(rs.getInt("year"));
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
	
	public StudentModel getStudentDetail(StudentModel stdModel){
		String sql ="SELECT student.student_id, student.firstname, student.lastname, pre.prename_name_short, "
							+ "bra.branch_nameth, student.tel_number, student.email, student.line_id,"
							+ "student.identification, student.prename_id, receive_year "
				+ "FROM student "
				+ "inner JOIN pre_name as pre on (student.prename_id = pre.prename_id) "
				+ "inner join branch as bra on (student.branch_id = bra.branch_id) "
				+ "where student.student_id = '"+stdModel.getStudent_id()+"'";
		
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				stdModel.setPrename_name_short(rs.getString("prename_name_short"));
				stdModel.setStudent_id(rs.getString("student_id"));
				stdModel.setFirstname(rs.getString("firstname"));
				stdModel.setLastname(rs.getString("lastname"));
				stdModel.setBranch_nameth(rs.getString("branch_nameth"));
				stdModel.setIdentification(rs.getString("identification"));
				stdModel.setEmail(rs.getString("email"));
				stdModel.setTel_number(rs.getString("tel_number"));
				stdModel.setLine_id(rs.getString("line_id"));
				stdModel.setPrename_id(rs.getInt("prename_id"));
				stdModel.setReceiveYear(rs.getString("receive_year"));
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stdModel;
	}
}
