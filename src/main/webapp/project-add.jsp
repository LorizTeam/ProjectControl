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
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">Add Project</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container">
			   <s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
			   <form action="addProject" method="post">
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
				          <s:textarea name="proModel.project_description" class="validate materialize-textarea" />
				          <label for="last_name">Project Description (TH)</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.score1" class="validate" required="true" maxlength="3" />
				          <label for="score1">คะแนน รูปเล่ม</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.score2" class="validate" required="true" maxlength="3"/>
				          <label for="score2">คะแนน ความรู้</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.score3" class="validate" required="true" maxlength="3"/>
				          <label for="score3">คะแนน ตอบคำถาม</label>
				        </div>
				        <div class="col s12">
				        	<p style="margin-bottom: 0; color:#26a69a !important;">Course</p>
							<s:select style="width: 100%"  list="mapCourse" name="proModel.course_id"></s:select>
						 </div>
				        <div class=" col s12">
				        	<p style="margin-bottom: 0; color:#26a69a !important;">Teacher Adviser</p>
						    <s:select style="width: 100%" list="mapTeacher" name="proModel.teacher_id"></s:select>
						</div>
						
				      </div>
				    </div>
				  </div>
			     
		    </div>
		    <div class="card " style="padding:10px;">
		    	<h5 class="cyan-text text-darken-1">Student</h5>
		    	<div class="row">
					<div class="input-field col s12">
					  <s:select style="width: 100%" list="mapStudent" id="ddl_student" name="inputStudentId" multiple="true"></s:select>
					  
					</div>
				</div>
		    </div>
		    <div class="card " style="padding:10px;">
		    	<h5 class="cyan-text text-darken-1">Project Examiner</h5>
		    	<div class="row">
					<div class="input-field col s12">
					  <s:select style="width: 100%" list="mapExaminer" id="ddl_examiner" name="inputTeacherId" multiple="true"></s:select>
					  
					</div>
				</div>
		    </div>
		     <div class="center-align">
		      <button type="submit" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
		      <a href="viewProjectAll" type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</a>
		      </div>
		      </form>
		    </div>
		  </div>  
		    
		</main>
		<script type="text/javascript">
		 $(document).ready(function(){
			 
			 $('.m1').addClass('active');
			 $('.m1-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Project');
			 $("#ddl_student option:first").attr('disabled', 'disabled');
			 $("#ddl_examiner option:first").attr('disabled', 'disabled');
			 $('select').material_select();
			 
			 
			 //$("#target option:first").attr('selected','selected');
		});
		</script>
		
	</body>
</html>