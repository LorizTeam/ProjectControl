<%@page import="smartict.study.data.SectionData"%>
<%@page import="smartict.model.SectionModel"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@ page language="java" import="java.util.*,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.codehaus.jettison.json.JSONException" %>
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%
		SectionModel secModel = new SectionModel();
		secModel.setId(Integer.parseInt(request.getParameter("courseId").toString()));
		
		secModel.setStudentId(request.getParameter("studentId").toString());
		
		SectionData secDB = new SectionData();
		JSONObject jOBJ = new JSONObject();
		JSONArray jsonResponse = secDB.getJsonArrayStudentSection(secModel);
		jOBJ.put("more", false);
		jOBJ.put("results", jsonResponse);
		response.setContentType("application/json");
		response.setHeader("cache-control", "no-cache");
		PrintWriter pw = response.getWriter();
		pw.println(jOBJ.toString());
		pw.flush();
%>