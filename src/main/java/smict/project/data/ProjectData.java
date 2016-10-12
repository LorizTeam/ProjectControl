package smict.project.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
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
				+ "CONCAT(project.exam_fullscore,'/',project.exam_score) as score,"
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
	
	public List<ProjectModel> getListProjectSequence(){
		
		String sql = "SELECT "
				+ "project.project_id,"
				+ "project.project_nameth,"
				+ "project.project_nameen,"
				+ "CONCAT(pre_name.prename_name_short,' ',teacher.firstname,' ',teacher.lastname) as teachername,"
				+ "CONCAT(project.exam_fullscore,'/',project.exam_score) as score,"
				+ "course_nameth,"
				+ "project.createdatetime,"
				+ "faculty_nameth "
					+ "FROM "
				+ "project "
				+ "INNER JOIN teacher ON teacher.teacher_id = project.teacher_id "
				+ "INNER JOIN pre_name ON pre_name.prename_id = teacher.prename_id  "
				+ "INNER JOIN course on course.course_id = project.course_id "
				+ "INNER JOIN branch on branch.branch_id = course.branch_id "
				+ "INNER JOIN faculty on faculty.faculty_id = branch.branch_id"
				+ "where project.project_id not in (select project_id from project where exam_score > 0)";
		
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
	
	public ProjectModel getProjectModelValue(ProjectModel proModel){
		String sql = "SELECT * FROM project where project_id = "+proModel.getProject_id();
		
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				proModel.setProject_nameth(rs.getString("project_nameth"));
				proModel.setProject_nameen(rs.getString("project_nameen"));
				proModel.setTeacher_id(rs.getInt("teacher_id"));
				proModel.setExam_fullscore(rs.getInt("exam_fullscore"));
				proModel.setScore_pass(rs.getInt("score_pass"));
				proModel.setCourse_id(rs.getInt("course_id"));
				proModel.setCreatedatetime(rs.getDate("createdatetime"));
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
		return proModel;
	}
	
	public List<String> getListExaminerInProject(ProjectModel proModel){
		String sql = "SELECT * FROM project_examiner where project_id = "+proModel.getProject_id();
		List<String> listExaminer = new ArrayList<String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				listExaminer.add(rs.getString("teacher_id"));
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
		return listExaminer;
	}
	
	public List<String> getListStudentInProject(ProjectModel proModel){
		String sql = "SELECT * FROM project "
				+ "INNER JOIN student on (project.project_id = student.project_id) "
				+ " where project.project_id = "+proModel.getProject_id();
		List<String> listStudent = new ArrayList<String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				listStudent.add(rs.getString("student_id"));
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
		return listStudent;
	}
	
	public List<String> getProjectWaitingExam(){
		String sql = "SELECT * FROM `project` where exam_score = 0 ";
		List<String> listProjectWaitingExam = new ArrayList<String>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				listProjectWaitingExam.add(rs.getString("project_id"));
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
		return listProjectWaitingExam;
	}
	
	public boolean isAvailableUseExamNumber(int examNumber){
		String sql = "SELECT * FROM `project` where exam_number = "+examNumber;
		boolean isAvailable = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next()) {
				isAvailable = true;
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
		}finally {
			
		}
		return isAvailable;
	}
	
	public void clearExamNumberWithProjectExamScoreEmpty(){
		String sql = "update project set exam_number = 0 where exam_score = 0";
		
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
	
	public List<Integer> getNumberProjectMinMax(){
		String sql = "SELECT min(project_id) as minProject, MAX(project_id) as maxProject FROM `project`";
		List<Integer> listMinMax = new ArrayList<Integer>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				listMinMax.add(rs.getInt("minProject"));
				listMinMax.add(rs.getInt("maxProject"));
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
		return listMinMax;
	}
	
	public int addProject(ProjectModel proModel){
		String sql = "insert into project (project_nameth, project_nameen, teacher_id,createdatetime, "
						+ "exam_fullscore, score_pass, course_id) values "
					+ "('"+proModel.getProject_nameth()+"', '"+proModel.getProject_nameen()+"', '"+proModel.getTeacher_id()+"', now(),"
						+ ""+proModel.getExam_fullscore()+", "+proModel.getScore_pass()+", "+proModel.getCourse_id()+")";
		
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
	
	public void updateProjectExamNumber(ProjectModel proModel){
		
		String sql = "update project set exam_number = "+proModel.getExam_number()+" where project_id = '"+proModel.getProject_id()+"'";
		
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
	
	public int getRandomInteger(int minInt, int maxInt){
		int randomInt = 0;
		randomInt = ThreadLocalRandom.current().nextInt(minInt, maxInt + 1);
		return randomInt;
	}
}