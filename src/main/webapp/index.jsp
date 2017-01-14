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
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		      </div>
		</div>
        <ul id="dashboard-list" class="row">
        	<li class=" col s12 m4 ">
        		<div class="card blue-grey darken-1 z-depth-2 small ">
					<div class="card-content white-text center-align">
						<span class="card-title">Project </span>
						<h2><s:property value="numberProject"/> </h2>
					</div>
					<s:if test="%{#session.type == 3 }">
						<div class="card-action center-align blue-grey-text text-darken-4">
							<a href="viewProjectAll">Project List</a>
							<a href="inputProjectData">Add Project</a>
						</div>
					</s:if>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card grey darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Student </span>
						<h2><s:property value="numberStudent"/></h2>
					</div>
					<s:if test="%{#session.type == 3 }">
						<div class="card-action center-align">
							<a href="viewAllStudent">Student List</a>
							<a href="inputStudent">Add Student</a>
						</div>
					</s:if>
				</div>
        	</li>
        	<li class=" col s12 m4">
        		<div class="card teal darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Teacher </span>
						<h2><s:property value="numberTeacher"/></h2>
					</div>
					<s:if test="%{#session.type == 3 }">
						<div class="card-action center-align">
							<a href="viewAllTeacher">Teacher List</a>
							<a href="inputTeacher">Add Teacher</a>
						</div>
					</s:if>
				</div>
        	</li>
        </ul>
		</main>

		<script type="text/javascript">
		 $(document).ready(function(){
			    Materialize.showStaggeredListSlideDown('#dashboard-list');
		  });
		</script>
		
	</body>
</html>