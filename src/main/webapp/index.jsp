<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Dashboard</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
		<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="index.jsp" class="breadcrumb">Dash board</a>
		      </div>
		</div>
        <ul id="dashboard-list" class="row">
        	<li class=" col s12 m4 ">
        		<div class="card blue-grey darken-1 z-depth-2 small ">
					<div class="card-content white-text center-align">
						<span class="card-title">Project </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align blue-grey-text text-darken-4">
						<a href="project.jsp">Project List</a>
						<a href="project-add.jsp">Add Project</a>
					</div>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card grey darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Student </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align">
						<a href="Student.jsp">Student List</a>
						<a href="student-add.jsp">Add Student</a>
					</div>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card teal darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Teacher </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align">
						<a href="teacher.jsp">Teacher List</a>
						<a href="teacher-add.jsp">Add Teacher</a>
					</div>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card light-blue darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Course </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align">
						<a href="course.jsp">Course List</a>
						<a href="course-add.jsp">Add Course</a>
					</div>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card brown darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Employee </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align">
						<a href="employee.jsp">Employee List</a>
						<a href="employee-add.jsp">Add Employee</a>
					</div>
				</div>
        	</li>
        </ul>
		</main>
		<div class="fixed-action-btn horizontal click-to-toggle">
	        <a class="btn-floating btn-large" href="#"><i class="material-icons">more_vert</i></a>
	        <ul>
		      <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
		      <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
		      <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
		      <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
		    </ul>
	    </div>

		<script type="text/javascript">
		 $(document).ready(function(){
			    Materialize.showStaggeredListSlideDown('#dashboard-list');
		  });
		</script>
		
	</body>
</html>