package smict.project.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
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
