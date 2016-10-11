<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Add project</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/select2.css">
		
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="index.jsp" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">Add Project</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container">
			   <h4 class="center-align light-blue-text text-darken-1">Add Project</h4>
			    <div class="card " style="padding:10px;">
			    <h5 class="cyan-text text-darken-1">Project Details</h5>
			      <div class="row">
				    <div class="col s12">
				      <div class="row">
				        <div class="input-field col s12">
				          <s:textfield name="proModel.project_nameth" class="validate" />
				          <label for="first_name">Project Name(TH)</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.project_nameen" class="validate" />
				          <label for="last_name">Project Name (EN)</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.exam_score" class="validate" />
				          <label for="last_name">Full Score</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.score_pass" class="validate" />
				          <label for="last_name">Score Pass</label>
				        </div>
				        
				        
				        <div class="input-field col s12">
						    <s:select list="mapCourse" name="proModel.course_id"></s:select>
						    <label>Course</label>
						</div>
				        <div class="input-field col s12">
						    <s:select list="mapTeacher" name="proModel.teacher_id"></s:select>
						    <label>Teacher Adviser</label>
						</div>
						
				      </div>
				    </div>
				  </div>
			     
		    </div>
		    <div class="card " style="padding:10px;">
		    	<h5 class="cyan-text text-darken-1">Student</h5>
		    	<div class="row">
					<div class="input-field col s12">
					  <s:select list="mapStudent" name="inputStudentId" multiple="true"></s:select>
					  <label for="autocomplete-input2">Add Student</label>
					</div>
				</div>
		    </div>
		    <div class="card " style="padding:10px;">
		    	<h5 class="cyan-text text-darken-1">Project Examiner</h5>
		    	<div class="row">
					<div class="input-field col s12">
					  <s:select list="mapTeacher" name="inputTeacherId" multiple="true"></s:select>
					  <label for="autocomplete-input2">Add Student</label>
					</div>
				</div>
		    </div>
		     <div class="center-align">
		      <button type="submit" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
		      <button type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</button>
		      </div>
		    </div>
		  </div>  
		    
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
			 
			 $('.m1').addClass('active');
			 $('.m1-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Project');
			 $('select').select2({
			 });
		});
		</script>
		
	</body>
</html>