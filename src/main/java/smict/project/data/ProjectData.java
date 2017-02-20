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
import smartict.model.TeacherExamProjectModel;
import smartict.util.DBConnect;
import smartict.util.DateUtil;
import smartict.util.SmartSetParameter;
import smartict.util.Validate;

public class ProjectData {
	DBConnect agent = new DBConnect();
	DateUtil dateUtil = new DateUtil();
	Validate cValidate = new Validate();
	SmartSetParameter setParam = new SmartSetParameter();
	
	public List<TeacherExamProjectModel> getListTeacherExamProjectModel(ProjectModel proModel){
		String sql = "SELECT "
				+ "		pre_name.prename_name_short,"
				+ "		teacher.firstname,"
				+ "		teacher.lastname,"
				+ "		project_examiner.add_score,"
				+ "		project_examiner.score1,"
				+ "		project_examiner.score2,"
				+ "		project_examiner.score3 "
				+ "		FROM "
				+ "		project "
				+ "		INNER JOIN project_examiner ON project.project_id = project_examiner.project_id "
				+ "		INNER JOIN teacher ON project_examiner.teacher_id = teacher.teacher_id "
				+ "		INNER JOIN pre_name on (teacher.prename_id = pre_name.prename_id) "
				+ "		where (project.project_id = "+proModel.getProject_id()+" or project.project_id IS NULL)";
		
		List<TeacherExamProjectModel> listTeacherExamProject = new ArrayList<TeacherExamProjectModel>();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				TeacherExamProjectModel teacherExamProjectModel = new TeacherExamProjectModel();
				teacherExamProjectModel.setFirstname(rs.getString("firstname"));
				teacherExamProjectModel.setLastname(rs.getString("lastname"));
				teacherExamProjectModel.setExam_score(rs.getDouble("add_score"));
				teacherExamProjectModel.setPrename_name_short(rs.getString("prename_name_short"));
				teacherExamProjectModel.setScore1(rs.getInt("score1"));
				teacherExamProjectModel.setScore2(rs.getInt("score2"));
				teacherExamProjectModel.setScore3(rs.getInt("score3"));
				listTeacherExamProject.add(teacherExamProjectModel);
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
		
		return listTeacherExamProject;
	}
	
	public List<ProjectModel> getListProject(String orderBy, String teacherId, String studentId, String statusId){
		Validate validClass = new Validate();
		String sql = "SELECT "
				+ "project.project_id,"
				+ "project.project_nameth,"
				+ "project.project_nameen,"
				+ "project.project_description,"
				+ "CONCAT(pre_name.prename_name_short,' ',teacher.firstname,' ',teacher.lastname) as teachername,"
				+ "project.exam_fullscore, project.exam_score, "
				+ "course_nameth, project.createdatetime, faculty_nameth, (SELECT count(*) as personadded FROM project_examiner where project_id = project.project_id and addexam_statusid = 2) as personadded,"
				+ "project_status.project_status_name, sec.id section_id, sec.name section_name "
					+ "FROM "
				+ "project "
				+ "INNER JOIN teacher ON teacher.teacher_id = project.teacher_id "
				+ "INNER JOIN pre_name ON pre_name.prename_id = teacher.prename_id  "
				+ "INNER JOIN course on course.course_id = project.course_id "
				+ "INNER JOIN branch on branch.branch_id = course.branch_id "
				+ "INNER JOIN faculty on faculty.faculty_id = branch.faculty_id "
				+ "INNER JOIN project_status on project_status.project_status_id = project.project_status_id "
				+ "INNER JOIN section sec on (sec.id = project.section_id) "
				+ "LEFT JOIN student on project.project_id = student.project_id "
				+ "where ";
				
			if(validClass.Check_String_notnull_notempty(studentId)) sql += "student_id = '"+studentId+"' and ";
			
			if(validClass.Check_String_notnull_notempty(teacherId)) sql += "teacher.teacher_id = '"+teacherId+"' and ";
				
			if(validClass.Check_String_notnull_notempty(statusId)) sql += "project.project_status_id IN ( "+statusId+") and ";
			
				sql += "project.project_id != '' group by project.project_id ";
		
			if(cValidate.Check_String_notnull_notempty(orderBy)){
				sql += "order by "+orderBy;
			}
		
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
				proModel.setExam_fullscore(rs.getInt("exam_fullscore"));
				proModel.setExam_score(rs.getDouble("exam_score"));
				proModel.setCourse_nameth(rs.getString("course_nameth"));
				proModel.setCreatedatetime(rs.getDate("createdatetime"));
				proModel.setFaclulty_nameth(rs.getString("faculty_nameth"));
				proModel.setPersonadded(rs.getInt("personadded"));
				proModel.setProject_status_name(rs.getString("project_status_name"));
				proModel.setProject_description(rs.getString("project_description"));
				proModel.setSectionId(rs.getInt("section_id"));
				proModel.setSectionName(rs.getString("section_name"));
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
	
	public void updateProjectStatus(ProjectModel proModel){
		
		proModel.setNow(false);
		int examiner = getCountProjectExamier(proModel);
		proModel.setNow(true);
		int nowExaminer = getCountProjectExamier(proModel);
		
		if(examiner == nowExaminer){
			int scorePass = getScorePass(proModel);
			
			String sql = "";
			if(isOverScorePass(scorePass, proModel.getProject_id())) {
				sql += "update project set project_status_id = 4 where project_id = "+proModel.getProject_id();
			}else{
				sql += "update project set project_status_id = 3 where project_id = "+proModel.getProject_id();
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
	}
	
	public boolean isOverScorePass(int score_pass, int projectId){
		boolean isPass = false;
		
		List<String> listScore = getScoreProjectModel(projectId);
		double sumscore1 = Double.parseDouble(listScore.get(0)), sumscore2 = Double.parseDouble(listScore.get(1)),
				sumscore3 = Double.parseDouble(listScore.get(2)), maxScore1 = Double.parseDouble(listScore.get(3)),
				maxScore2 = Double.parseDouble(listScore.get(4)), maxScore3 = Double.parseDouble(listScore.get(5));
		
		double percent1 = sumscore1 * 100  / maxScore1, 
				percent2 = sumscore2 * 100  / maxScore2, 
				percent3 = sumscore3 * 100  / maxScore3;
		
		double realScore1 = maxScore1 * percent1 / 100, 
				realScore2 = maxScore2 * percent2 / 100, 
				realScore3 = maxScore3 * percent3 / 100;
		
		double summaryScore = realScore1+realScore2+realScore3;
		
		String sql = "update project set exam_score = "+summaryScore+" where project_id = "+projectId;
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
		
		if(summaryScore > score_pass) isPass = true;
		
		return isPass;
	}
	
	public List<String> getScoreProjectModel(int projectId){
		String sql = "SELECT "
				+ "	sum(project_examiner.score1) sumscore1, "
				+ "	sum(project_examiner.score2) sumscore2,"
				+ "	sum(project_examiner.score3) sumscore3,"
				+ "(project.score1 * COUNT(project_examiner.teacher_id)) as maxscore1,"
				+ "(project.score2 * COUNT(project_examiner.teacher_id)) as maxscore2,"
				+ "(project.score3 * COUNT(project_examiner.teacher_id)) as maxscore3 "
				+ "FROM project_examiner "
				+ "INNER JOIN project on (project.project_id = project_examiner.project_id) "
				+ "where project.project_id = "+projectId;
		List<String> listScore = new ArrayList<String>(); 
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				listScore.add(rs.getString("sumscore1"));
				listScore.add(rs.getString("sumscore2"));
				listScore.add(rs.getString("sumscore3"));
				listScore.add(rs.getString("maxscore1"));
				listScore.add(rs.getString("maxscore2"));
				listScore.add(rs.getString("maxscore3"));
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return listScore;
	}
	
	public int getScorePass(ProjectModel proModel){
		String sql = "SELECT (score1+score2+score3) / 2 as score_pass from project where project_id = "+proModel.getProject_id();
		int scorePass = 0;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				scorePass = rs.getInt("score_pass");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return scorePass;
	}
	
	public String countProject(){
		String sql = "SELECT count(*) as numberProject from project";
		String numberProject = "";
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				numberProject = rs.getString("numberProject");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return numberProject;
	}
	
	public boolean isAvailableAddExamScore(ProjectModel proModel){
		boolean isAvailable = false;
		if(currentProjectScore(proModel) <= 500 && !isMaxPersonAddExamScore(proModel)){
			isAvailable = true;
		}
		
		return true;
	}
	
	public int currentProjectScore(ProjectModel proModel){
		String sql = "SELECT * from project where project_id = "+proModel.getProject_id();
		int currentScore = 0;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				currentScore = rs.getInt("exam_score");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return currentScore;
	}
	
	public int getCountProjectExamier(ProjectModel proModel){
		String sql = "SELECT count(*) as countExaminer from project "
				+ "inner join project_examiner on (project.project_id = project_examiner.project_id) "
				+ "where project.project_id = "+proModel.getProject_id();
				
		if(proModel.isNow()) sql += " and project_examiner.addexam_statusid = 2 ";
			
				sql += " group by project.project_id";
		int examiner = 0;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				examiner = rs.getInt("countExaminer");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return examiner;
	}
	
	public boolean isMaxPersonAddExamScore(ProjectModel proModel){
		boolean isMax = false;
		if(getCurrentPersonAddedExamscore(proModel) == 6){
			isMax = true;
		}
		return isMax;
	}
	
	public int getCurrentPersonAddedExamscore(ProjectModel proModel){
		String sql = "SELECT count(*) as personadded FROM project_examiner where project_id = "+proModel.getProject_id()+" and addexam_statusid = 2";
		int personadded = 0;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				personadded = rs.getInt("personadded");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return personadded;
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
				proModel.setScore1(rs.getInt("score1"));
				proModel.setScore2(rs.getInt("score2"));
				proModel.setScore3(rs.getInt("score3"));
				proModel.setCourse_id(rs.getInt("course_id"));
				proModel.setCreatedatetime(rs.getDate("createdatetime"));
				proModel.setSectionId(rs.getInt("section_id"));
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
	
	public ProjectModel getTeacherAddExamScoreStatus(ProjectModel proModel){
		String sql = "SELECT * from project_examiner where project_id = "+proModel.getProject_id()+" and teacher_id = "+proModel.getTeacher_id();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				proModel.setAddExamScoreStatusId(rs.getInt("addexam_statusid"));
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proModel;
	}
	
	public int getTeacherId(String username){
		int teacherId = 0;
		String sql = "SELECT * FROM `teacher` where username = '"+username+"'";
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				teacherId = rs.getInt("teacher_id");
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherId;
	}
	
	public boolean isAvailableInput(String username, int projectId){
		int teacherId = getTeacherId(username);
		boolean canInput = false;
		String sql = "select * from project_examiner where project_id = "+projectId+" and teacher_id = "+teacherId+" and addexam_statusid = '1'";
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				canInput = true;
			}
			
			if(!rs.isClosed()) rs.close();
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return canInput;
	}
	
	public int addProject(ProjectModel proModel){
		String sql = "insert into project (project_nameth, project_nameen, teacher_id,createdatetime, "
						+ "course_id, project_description, score1, score2, "
						+ "score3, section_id) values "
					+ "('"+proModel.getProject_nameth()+"', '"+proModel.getProject_nameen()+"', '"+proModel.getTeacher_id()+"', now(),"
						+ ""+proModel.getCourse_id()+", '"+proModel.getProject_description()+"', "+proModel.getScore1()+", "+proModel.getScore2()+","
						+ ""+proModel.getScore3()+", "+proModel.getSectionId()+")";
		
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
	
	public boolean deletedProject(ProjectModel proModel){
		String sql = "delete from project where project_id = "+proModel.getProject_id();
		
		boolean isDeleted = false;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				isDeleted = true;
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
		return isDeleted;
	}
	
	public int addProjectExamScore(ProjectModel proModel){
		String sql = "update project set exam_score = exam_score+"+proModel.getExam_score()+",project_status_id = 2 where project_id = "+proModel.getProject_id();
		
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
	
	public void updateProjectExaminer(ProjectModel proModel){
		String sql = "update project_examiner set "
				+ "addexam_statusid = 2,score1 = "+proModel.getScore1()+","
				+ "score2 = "+proModel.getScore2()+","
				+ "score3 = "+proModel.getScore3()+" "
				+ "where project_id = "+proModel.getProject_id()+" and teacher_id = "+proModel.getTeacher_id();
		
		int projectId = 0;
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
	
	
	public void updateProjectToStudent(int projectId, String[] arrayStudentId){
		clearProjectFromStudent(projectId);
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
	
	public boolean clearProjectFromStudent(int ProjectId){
		
		boolean isUpdated = false;
		String sql = "update student set project_id = null where student_id = "+ProjectId;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			
			if(stmt.executeUpdate(sql) > 0) isUpdated = true;
				
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}
	
	public boolean updateProject(ProjectModel projModel){
		
		projModel.setProject_nameth(setParam.StringIsNullOrEmpty(projModel.getProject_nameth()));
		projModel.setProject_nameen(setParam.StringIsNullOrEmpty(projModel.getProject_nameen()));
		
		String score1, score2, score3, teacherId;
		score1 = setParam.checkIntegerNotZero(projModel.getScore1());
		score2 = setParam.checkIntegerNotZero(projModel.getScore2());
		score3 = setParam.checkIntegerNotZero(projModel.getScore3());
		teacherId = setParam.checkIntegerNotZero(projModel.getTeacher_id());
		boolean isUpdated = false;
		String sql = "update project set "
				+ "project_nameth =  IFNULL("+projModel.getProject_nameth()+",project_nameth),"
				+ "project_nameen =  IFNULL("+projModel.getProject_nameen()+",project_nameen),"
				+ "teacher_id = IFNULL("+teacherId+",teacher_id),"
				+ "score1 = IFNULL("+score1+",score1),"
				+ "score2 = IFNULL("+score2+",score2),"
				+ "score3 = IFNULL("+score3+",score3) "
				+ "where project_id = "+projModel.getProject_id();
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			
			if(stmt.executeUpdate(sql) > 0) isUpdated = true;
				
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
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
		clearProjectExaminer(projectId);
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
	
	public boolean clearProjectExaminer(int ProjectId){
		
		boolean isDeleted = false;
		String sql = "delete from project_examiner where project_id = "+ProjectId;
		try {
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			
			if(stmt.executeUpdate(sql) > 0) isDeleted = true;
				
			if(!stmt.isClosed()) stmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isDeleted;
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
	
	public int getNextExamQueue(){
		String sql ="SELECT * FROM project where exam_score = 0 ORDER BY exam_number LIMIT 2,3";
		int exam_number = 0;
		try {
			
			Connection conn = agent.getConnectMYSql();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				exam_number = rs.getInt("project_id");
				
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
		
		return exam_number;
	}
}
