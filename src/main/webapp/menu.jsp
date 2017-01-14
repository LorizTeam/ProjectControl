<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="smict.project.data.ProjectData" %>
<header>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<nav class="top-nav light-blue darken-3" style="padding-left:10px;">
		<div class="nav-warpper">
			<a data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
			<a class="page-title">Dashboard</a>
			
		</div>
	</nav>
	<ul id="slide-out" class="side-nav fixed collapsible"  data-collapsible="accordion" >
		<li class="logo  light-blue-text text-darken-3 ">
		  <div class="row">
	      	<div class="col s1">
	      		<img class="materialboxed" src="img/industrial_technology.png" width="200">
      		</div>
	      </div>
	        <p>Project Controller</p>
		</li>
		<li >
			<%
				ProjectData proDB = new ProjectData();
				int exam_number = proDB.getNextExamQueue();
			%>
			<div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m1">Next project queue: <%=exam_number %></div>
		</li>
		<s:if test="%{#session.type == 3 }">
			<li >
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m1"><i class="material-icons">view_module</i>โปรเจค</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m1-1"><a class="waves-effect waves-light" href="viewProjectAll"><i class="material-icons">view_list</i>รายการโปรเจค</a></li>
		      		<li class="m1-2"><a class="waves-effect waves-light" href="inputProjectData"><i class="material-icons">playlist_add</i>เพิ่มโปรเจค</a></li>
					<li class="m1-3"><a class="waves-effect waves-light" href="viewProjectSequence"><i class="material-icons">shuffle</i>ลำดับของโปรเจค</a></li>
		      	</ul>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m2"><i class="material-icons">recent_actors</i>นักศึกษา</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m2-1"><a href="viewAllStudent"><i class="material-icons">recent_actors</i>รายการนักศึกษา</a></li>
		      		<li class="m2-2"><a href="inputStudent"><i class="material-icons">note_add</i>เพิ่มนักศึกษา</a></li>
		      	</ul>
		      </div>
		    </li>
		     <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m3"><i class="material-icons">supervisor_account</i>อาจารย์</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m3-1"><a href="viewAllTeacher"><i class="material-icons">supervisor_account</i>รายการอาจารย์</a></li>
		      		<li class="m3-2"><a href="inputTeacher"><i class="material-icons">note_add</i>เพิ่มอาจารย์</a></li>
		      	</ul>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m4"><i class="material-icons">description</i>ไฟล์</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m4-1"><a href="getAllFile"><i class="material-icons">description</i>รายการไฟล์</a></li>
		      		<li class="m4-2"><a href="inputFile"><i class="fa fa-plus-circle fa-2x"></i>จัดการไฟล์</a></li>
		      		<li class="m4-3"><a href="FileGroup"><i class="material-icons">work</i>ข้อมูลกลุ่มไฟล์</a></li>
		      	</ul>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m6"><i class="material-icons">settings</i>ตั้งค่า</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m6-1"><a href="viewAllFaculty"><i class="material-icons">assignment_ind</i>คณะ</a></li>
		      		<li class="m6-2"><a href="viewAllBranch"><i class="material-icons">assignment_ind</i>สาขา</a></li>
		      		<li class="m6-3"><a href="viewAllCourse"><i class="material-icons">note_add</i>วิชา</a></li>
		      	</ul>
		      </div>
		    </li>
		</s:if>
		<s:elseif test="%{#session.type == 2 }">
			<li >
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m1"><i class="material-icons">view_module</i>โปรเจค</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m1-1"><a class="waves-effect waves-light" href="viewMyProject"><i class="material-icons">view_list</i>รายการโปรเจค</a></li>
		      	</ul>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m4"><i class="material-icons">description</i>ไฟล์</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m4-1"><a href="getAllFile"><i class="material-icons">description</i>รายการไฟล์</a></li>
		      	</ul>
		      </div>
		    </li>
		</s:elseif>
		<s:elseif test="%{#session.type == 1 }">
			<li >
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m1"><i class="material-icons">view_module</i>โปรเจค</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m1-1"><a class="waves-effect waves-light" href="viewMyProject"><i class="material-icons">view_list</i>รายการโปรเจค</a></li>
					<li class="m1-3"><a class="waves-effect waves-light" href="viewProjectSequence"><i class="material-icons">shuffle</i>ลำดับโปรเจค</a></li>
		      	</ul>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m4"><i class="material-icons">description</i>ไฟล์</div>
		      <div class="collapsible-body">
		      	<ul>
		      		<li class="m4-1"><a href="getAllFile"><i class="material-icons">description</i>รายการไฟล์</a></li>
		      	</ul>
		      </div>
		    </li>
		</s:elseif>
		
	    
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange person"><i class="material-icons">settings_power</i>ข้อมูลผู้ใช้งาน</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li><a href="#"><i class="material-icons">perm_identity</i> <s:property value="%{#session.firstname}"/> <s:property value="%{#session.lastname}"/></a></li>
	      		<li class="changePass"><a href="inputChangePassword"><i class="material-icons">mode_edit</i> เปลี่ยนพาสเวิร์ด</a></li>
	      		<s:url action="Logout" var="LogoutAction" />
	      		<li><a href='<s:property value="LogoutAction"/>'><i class="material-icons">power_settings_new</i>ออกจากระบบ</a></li>
	      	</ul>
	      </div>
	    </li>
    </ul>
</header>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.js"></script>
		<script type="text/javascript" src="js/select2.js"></script>
		<script>
		$(document).ready(function(){
			$(".button-collapse").sideNav();
			$('#alertMessage').delay(3500).fadeOut('slow');
		});
		
		
		</script>