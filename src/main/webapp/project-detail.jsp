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
		
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="index.jsp" class="breadcrumb">Dash board</a>
		        <a href="project.jsp" class="breadcrumb">Project List</a>
		        <a href="#!" class="breadcrumb">Project Details</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container"> 
			   <h4 class="center-align light-blue-text text-darken-1">Project Details</h4>
			   
			    <div class="card " style="padding:10px;">
			    <s:url action="viewProjectDetailExam" var="urlLink">
	   				<s:param name='proModel.project_id'><s:property value="proModel.project_id"/></s:param>
	   			</s:url>
			    <h5 class="cyan-text text-darken-1">Project Details 
				    <s:if test='proModel.canAddExamScore == true'>
				    	<a href='<s:property value="urlLink"/>' class="modal-action modal-close waves-effect waves-light blue lighten-1 btn "><i class="material-icons">input</i> ให้คะแนนสอบ</a>
				    </s:if>
			    </h5><br>
			      <div class="row">
				    <form class="col s12">
				      <div class="row">
				        <div class="input-field col s12">
				          <s:textfield name="proModel.project_nameth" id="project_nameth" class="validate ip" readonly="true"/>
				          <label for="first_name">Project Name(TH)</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.project_nameen" id="project_nameen" class="validate ip" readonly="true"/>
				          <label for="last_name">Project Name (EN)</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.exam_fullscore" class="validate ip" />
				          <label for="last_name">Full Score</label>
				        </div>
				        <div class="input-field col s12">
				          <s:textfield name="proModel.score_pass" class="validate ip" />
				          <label for="last_name">Score Pass</label>
				        </div>
				        <div class="input-field col s12">
						    <s:select list="mapCourse" name="proModel.course_id" class="validate ip" value="proModel.course_id" readonly="true"></s:select>
						    <label>Course</label>
						</div>
				        <div class="input-field col s12">
						    <s:select list="mapTeacher" name="proModel.teacher_id" class="validate ip" value="proModel.teacher_id"  readonly="true"></s:select>
						    <label>Teacher Adviser</label>
						</div>
				      </div>
				    </form>
				  </div>
				  <div class="card " style="padding:10px;">
				    	<h5 class="cyan-text text-darken-1">Student</h5>
				    	<div class="row">
							<div class="input-field col s12">
							  <s:select style="width: 100%" list="mapStudent" id="ddl_student" value="listStudent" name="inputStudentId" multiple="true"></s:select>
							</div>
						</div>
				    </div>
				    <div class="card " style="padding:10px;">
				    	<h5 class="cyan-text text-darken-1">Project Examiner</h5>
				    	<div class="row">
							<div class="input-field col s12">
							  <s:select style="width: 100%" list="mapExaminer" id="ddl_examiner" value="listExaminer" name="inputTeacherId" multiple="true"></s:select>
							  
							</div>
						</div>
				    </div>
			      <div class="center-align">
			     <s:if test="%{#session.type == 3 }">
			     	<button value="0" type="button" id="btn-e" class="modal-action modal-close waves-effect waves-orange  orange btn ">Edit</button>
			     </s:if>
			      
			      <a href="viewProjectAll" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
			      </div>
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
			 $('.collapsible').collapsible();
			 $('.page-title').text('Project Details');
			 $("#ddl_student option:first").attr('disabled', 'disabled');
			 $("#ddl_examiner option:first").attr('disabled', 'disabled');
			 $('select').material_select();
			 
			
			$('#btn-e').on('click',function(){
				if($('#btn-e').val()==0){
					$('.ip').removeAttr('readonly');
					$('#btn-e').removeClass('orange waves-orange').addClass('waves-green').text('Save').val(1);

				}else{
					
					$('.ip').attr('readonly','true');
					$('#btn-e').removeClass('waves-green').addClass('orange waves-orange').text('Edit').val(0);
					$('#btn-e').attr('type','submit');
				}
			});
			
		});
		</script>
		
	</body>
</html>