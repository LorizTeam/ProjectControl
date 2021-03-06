package smartict.study.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import smartict.model.BranchModel;
import smartict.model.FacultyModel;
import smartict.model.SectionModel;
import smartict.model.StudentModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;
import smartict.util.Validate;

public class SectionData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	Validate cValidate = new Validate();
	
	public boolean addSection(SectionModel secModel){
		String sql = "insert into section (name, year, course_id) values "
						+ "('"+secModel.getSectionName()+"', '"+secModel.getSectionYear()+"', "+secModel.getId()+")";
		
		boolean hasAdd = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAdd = true;
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
		return hasAdd;
	}
	
	public boolean addStudentSection(StudentModel stdModel){
		String sql = "insert into student_section (student_id, section_id) values "
						+ "('"+stdModel.getStudent_id()+"', "+stdModel.getSectionId()+")";
		
		boolean hasAdd = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAdd = true;
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
		return hasAdd;
	}
	
	public boolean deleteStudentSection(StudentModel stdModel){
		String sql = "delete from student_section where id = "+stdModel.getStudentSectionId();
		
		boolean hasAdd = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasAdd = true;
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
		return hasAdd;
	}
	
	public boolean delete(SectionModel secModel){
		String sql = "delete from section where id = '"+secModel.getSectionId()+"'";
						
		
		boolean hasDeleted = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleted = true;
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
		return hasDeleted;
	}
	
	public JSONArray getJsonArraySection(SectionModel secModel){
		String sql ="select "
				+ "	* "
				+ "from section sec "
				+ "where ("+secModel.getId()+" is null or course_id = "+secModel.getId()+") ";
		
		sql += "order by name";
		
		JSONArray jsonArray = new JSONArray();
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject jsonOBJ = new JSONObject();
				jsonOBJ.put("id", rs.getString("id"));
				jsonOBJ.put("text", rs.getString("name"));
				jsonArray.put(jsonOBJ);
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
		
		return jsonArray;
	}
	
	public JSONArray getJsonArrayStudentSection(SectionModel secModel){
		String sql ="select "
				+ "* "
				+ "from section "
				+ "where not EXISTS (select section_id from student_section "
				+ "					where section.id = student_section.section_id "
				+ "					and student_section.student_id = '"+secModel.getStudentId()+"' "
				+ "					) "
				+ "and course_id = "+secModel.getId();
		
		sql += " order by name";
		
		JSONArray jsonArray = new JSONArray();
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject jsonOBJ = new JSONObject();
				jsonOBJ.put("id", rs.getString("id"));
				jsonOBJ.put("text", rs.getString("name"));
				jsonArray.put(jsonOBJ);
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
		
		return jsonArray;
	}
	
	public List<SectionModel> getListSection(int courseId){
		
		String sql = "select * from section "
				+ "where "
				+ "id > 0 ";
		if(cValidate.checkIntegerNotZero(courseId)) sql += "and course_id = "+courseId;
		
		List<SectionModel> listBraModel = new ArrayList<SectionModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				SectionModel secModel = new SectionModel();
				secModel.setSectionId(rs.getInt("id"));
				secModel.setSectionName(rs.getString("name"));
				secModel.setSectionYear(rs.getInt("year"));
				listBraModel.add(secModel);
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
		
		return listBraModel;
	}
	
	public Map<String, String> getMapSection(int courseId){
		
		String sql = "select * from section "
				+ "where "
				+ "id > 0 ";
		if(cValidate.checkIntegerNotZero(courseId)) sql += "and course_id = "+courseId;
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				map.put(rs.getString("id"), rs.getString("name"));
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
		
		return map;
	}
	
	public Map<String, String> getMapBranch(BranchModel braModel){
		
		String sql = "select * from branch where ";
		
		if(braModel.getId() > 0) 
			sql += "branch_id = '"+braModel.getId()+"' and ";
		
		if(!braModel.getCode().equals("")) 
			sql += "branch_code = '"+braModel.getCode()+"' and ";
		
		if(!braModel.getNameth().equals("")) 
			sql += "branch_nameth = '"+braModel.getNameth()+"' and ";
		
		if(!braModel.getNameen().equals("")) 
			sql += "branch_nameen = '"+braModel.getNameen()+"' and ";
		
		sql += "branch_id > 0";
		
		Map<String, String> mapBra = new HashMap<String, String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				mapBra.put(rs.getString("branch_id"), rs.getString("branch_nameth"));
				
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
