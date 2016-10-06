<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header>
	<nav class="top-nav light-blue darken-3" style="padding-left:10px;">
		<div class="nav-warpper">
			<a data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
			<a class="page-title">Dashboard</a>
			
		</div>
	</nav>
	<ul id="slide-out" class="side-nav fixed collapsible"  data-collapsible="accordion" >
		<li class="logo  light-blue-text text-darken-3 ">
			<i class="large material-icons ">web</i><p>Project Controller</p>
		</li>
		<li >
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m1"><i class="material-icons">view_module</i>Project</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m1-1"><a class="waves-effect waves-light" href="project.jsp"><i class="material-icons">view_list</i>Project List</a></li>
	      		<li class="m1-2"><a class="waves-effect waves-light" href="project-add.jsp"><i class="material-icons">playlist_add</i>Add Project</a></li>
				<li class="m1-3"><a class="waves-effect waves-light" href="project-random.jsp"><i class="material-icons">shuffle</i>Random Project</a></li>
	      	</ul>
	      </div>
	    </li>
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m2"><i class="material-icons">recent_actors</i>Student</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m2-1"><a href="Student.jsp"><i class="material-icons">recent_actors</i>Student List</a></li>
	      		<li class="m2-2"><a href="student-add.jsp"><i class="material-icons">note_add</i>Add Student</a></li>
	      	</ul>
	      </div>
	    </li>
	     <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m3"><i class="material-icons">supervisor_account</i>Teacher</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m3-1"><a href="teacher.jsp"><i class="material-icons">supervisor_account</i>Teacher List</a></li>
	      		<li class="m3-2"><a href="teacher-add.jsp"><i class="material-icons">note_add</i>Add Teacher</a></li>
	      	</ul>
	      </div>
	    </li>
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m4"><i class="material-icons">description</i>File</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m4-1"><a href="#"><i class="material-icons">description</i>File List</a></li>
	      		<li class="m4-2"><a href="file-group.jsp"><i class="material-icons">work</i>File Group List</a></li>
	      	</ul>
	      </div>
	    </li>
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m5"><i class="material-icons">assignment_ind</i>Employee</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m5-1"><a href="employee.jsp"><i class="material-icons">assignment_ind</i>Employee List</a></li>
	      		<li class="m5-2"><a href="employee-add.jsp"><i class="material-icons">note_add</i>Add Employee</a></li>
	      	</ul>
	      </div>
	    </li>
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange m6"><i class="material-icons">settings</i>Setting</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li class="m6-1"><a href="viewAllFaculty"><i class="material-icons">assignment_ind</i>Faculty</a></li>
	      		<li class="m6-2"><a href="branch.jsp"><i class="material-icons">assignment_ind</i>Branch</a></li>
	      		<li class="m6-3"><a href="course.jsp"><i class="material-icons">note_add</i>Course</a></li>
	      	</ul>
	      </div>
	    </li>
	    <li>
	      <div class="collapsible-header light-blue-text text-darken-4 waves-effect waves-orange"><i class="material-icons">settings_power</i>Power</div>
	      <div class="collapsible-body">
	      	<ul>
	      		<li><a href="#"><i class="material-icons">perm_identity</i> <s:property value="%{#session.firstname}"/> <s:property value="%{#session.lastname}"/></a></li>
	      		<s:url action="Logout" var="LogoutAction" />
	      		<li><a href='<s:property value="LogoutAction"/>'><i class="material-icons">power_settings_new</i>Logout</a></li>
	      	</ul>
	      </div>
	    </li>
    </ul>
</header>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.js"></script>
		<script>
		$(document).ready(function(){
			$(".button-collapse").sideNav();
			$('#alertMessage').delay(3500).fadeOut('slow');
		});
		
		
		</script>