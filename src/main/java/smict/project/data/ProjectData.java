package smict.project.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smartict.model.FacultyModel;
import smartict.model.ProjectModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;
import smartict.util.Validate;

public class ProjectData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	Validate cValidate = new Validate();
	
	public List<ProjectModel> getListProject(){
		
		String sql = "SELECT "
				+ "project.project_id,"
				+ "project.project_nameth,"
				+ "project.project_nameen,"
				+ "CONCAT(pre_name.prename_name_short,' ',teacher.firstname,' ',teacher.lastname) as teachername,"
				+ "CONCAT(project.score_pass,'/',project.exam_score) as score,"
				+ "course_nameth,"
				+ "project.createdatetime,"
				+ "faculty_nameth "
					+ "FROM "
				+ "project "
				+ "INNER JOIN teacher ON teacher.teacher_id = project.teacher_id "
				+ "INNER JOIN pre_name ON pre_name.prename_id = teacher.prename_id  "
				+ "INNER JOIN course on course.course_id = project.course_id "
				+ "INNER JOIN branch on branch.branch_id = course.branch_id "
				+ "INNER JOIN faculty on faculty.faculty_id = branch.branch_id";
		
		List<ProjectModel> listProModel = new ArrayList<ProjectModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ProjectModel proModel = new ProjectModel();
				proModel.setProject_id(rs.getInt("project_id"));
				proModel.setProject_nameth(rs.getString("project_nameth"));
				proModel.setProject_nameen(rs.getString("project_nameen"));
				proModel.setFirstname(rs.getString("teachername"));
				proModel.setShowScoreProject(rs.getString("score"));
				proModel.setCourse_nameth(rs.getString("course_nameth"));
				proModel.setCreatedatetime(rs.getDate("createdatetime"));
				proModel.setFaclulty_nameth(rs.getString("faculty_nameth"));
				listProModel.add(proModel);
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
		
		return listProModel;
	}
	
	public int addProject(ProjectModel proModel){
		String sql = "insert into project (project_nameth, project_nameen, teacher_id,createdatetime, "
						+ "exam_score, score_pass, course_id) values "
					+ "('"+proModel.getProject_nameth()+"', '"+proModel.getProject_nameen()+"', '"+proModel.getTeacher_id()+"', now(),"
						+ ""+proModel.getExam_score()+", "+proModel.getScore_pass()+", "+proModel.getCourse_id()+")";
		
		int projectId = 0;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				projectId = getProjectId();
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
		return projectId;
	}
	
	public void updateProjectToStudent(int projectId, String[] arrayStudentId){
		
		for(String studentId : arrayStudentId){
			studentId = studentId.trim();
			String sql = "update student set project_id = "+projectId+" where student_id = '"+studentId+"'";
			
			try {
				Connection conn = agent.getConnectMYSql();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				if(!stmt.isClosed()) stmt.close();
				if(!conn.isClosed()) conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addProjectExaminer(int projectId, String[] arrayTeacherId){
		
		String sql = "insert into project_examiner (project_id, teacher_id) values ";
		int count = 0;
		for(String teacherId : arrayTeacherId){
			if(count > 0) sql+=",";
			sql +="("+projectId+","+teacherId+")";
			count++;
		}
		
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getProjectId(){
		String sql ="select * from project ORDER BY project.project_id DESC limit 1";
		int projectId = 0;
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				projectId = rs.getInt("project_id");
				
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
		
		return projectId;
	}
}
