package smartict.study.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.model.BranchModel;
import smartict.model.FacultyModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;

public class BranchData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	
	public boolean addBranch(BranchModel braModel){
		String sql = "insert into branch (branch_code, branch_nameth, branch_nameen, faculty_id) values "
						+ "('"+braModel.getCode()+"', '"+braModel.getNameth()+"', '"+braModel.getNameen()+"', '"+braModel.getFacultyId()+"')";
		
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
	
	public boolean updateBranch(BranchModel braModel){
		String sql = "update branch set branch_code = '"+braModel.getCode()+"', branch_nameth = '"+braModel.getNameth()+"', "
						+ "branch_nameen = '"+braModel.getNameen()+"', faculty_id = "+braModel.getFacultyId()+" where branch_id = '"+braModel.getId()+"'";
						
		
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
	
	public boolean deleteBranch(BranchModel braModel){
		String sql = "delete from branch where branch_id = '"+braModel.getId()+"'";
						
		
		boolean hasDeleteBranch = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				hasDeleteBranch = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasDeleteBranch;
	}
	
	public List<BranchModel> getListBranch(BranchModel braModel){
		
		String sql = "select * from branch inner join faculty on (branch.faculty_id = faculty.faculty_id) where ";
		
		if(braModel.getId() > 0) 
			sql += "branch_id = '"+braModel.getId()+"' and ";
		
		if(!braModel.getCode().equals("")) 
			sql += "branch_code = '"+braModel.getCode()+"' and ";
		
		if(!braModel.getNameth().equals("")) 
			sql += "branch_nameth = '"+braModel.getNameth()+"' and ";
		
		if(!braModel.getNameen().equals("")) 
			sql += "branch_nameen = '"+braModel.getNameen()+"' and ";
		
		sql += "branch_id > 0";
		
		List<BranchModel> listBraModel = new ArrayList<BranchModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				listBraModel.add(new BranchModel(rs.getInt("branch_id"), rs.getString("branch_code"), rs.getString("branch_nameth"), rs.getString("branch_nameen"), 
									rs.getInt("faculty_id"), rs.getString("faculty_code"), rs.getString("faculty_nameth"), rs.getString("faculty_nameen")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listBraModel;
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
