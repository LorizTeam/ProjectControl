<%@ page language="java" import="java.util.*,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@ page import="smartict.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONValue"%>
<%
	List listjson = new LinkedList();
	DBConnect dbcon = new DBConnect();
	ResultSet rs = null; 
	
	String method_type = request.getParameter("method_type");
	Connection conn = null;
	Statement Stmt = null;
	if(method_type.equals("get")){
		String sql = "select CONCAT(prename.prename_name_short, ' ', firstname, ' ', lastname) as studentname "
					+ "from student "
					+ "INNER JOIN pre_name as prename on (student.prename_id = prename.prename_id)";
		
		conn = dbcon.getConnectMYSql();
		Stmt = conn.createStatement();
		rs = Stmt.executeQuery(sql); 
		 System.out.println(sql);
		while(rs.next()){  
			
			JSONObject obj=new JSONObject();
			
			obj.put("studentname", rs.getString("studentname"));  
			obj.put("link", null);  
			listjson.add(obj);
				
		}
	}
	System.out.println(listjson);
		out.println(listjson); 
	rs.close();
	Stmt.close(); 
	conn.close();
	  		
%>