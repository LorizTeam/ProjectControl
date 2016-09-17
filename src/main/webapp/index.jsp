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
        <ul id="dashboard-list" class="row">
        	<li class=" col s12 m4">
        		<div class="card blue-grey darken-1 z-depth-2 small">
					<div class="card-content white-text center-align">
						<span class="card-title">Project </span>
						<h2>0</h2>
					</div>
					<div class="card-action center-align blue-grey-text text-darken-4">
						<a href="#">Project List</a>
						<a href="#">Add Project</a>
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
						<a href="#">Student List</a>
						<a href="#">Add Student</a>
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
						<a href="#">Teacher List</a>
						<a href="#">Add Teacher</a>
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
						<a href="#">Course List</a>
						<a href="#">Add Course</a>
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
						<a href="#">Employee List</a>
						<a href="#">Add Employee</a>
					</div>
				</div>
        	</li>
        </ul>
			


		</main>
		<div class="fixed-action-btn horizontal">
	        <a class="btn-floating btn-large" href="#"><i class="material-icons">more_vert</i></a>
	        <ul>
		      <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
		      <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
		      <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
		      <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
		    </ul>
	    </div>


		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.js"></script>
		<script type="text/javascript">
			$(".button-collapse").sideNav();
		 $(document).ready(function(){
			    $('.collapsible').collapsible();
			    $(".button-collapse").sideNav();
			    Materialize.showStaggeredListSlideDown('#dashboard-list');
			    
		  });

		</script>
	</body>
</html>