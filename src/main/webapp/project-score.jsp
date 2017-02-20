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
		<style>
		.errorMessage {
			color: red;
		}
		</style>
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <a href="viewProjectAll" class="breadcrumb">Project List</a>
		        <a href="#!" class="breadcrumb">Project Details</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container"> 
			   <h4 class="center-align light-blue-text text-darken-1">Project Details</h4>
			    <form action="addExamScore" method="post">
				    <s:hidden name="proModel.project_id" id="project_id" class="validate ip"/>
				    <div class="card " style="padding:10px;">
				    	<h5 class="cyan-text text-darken-1">Project Score</h5>
				    	<div class="row">
					    	<div class="input-field col s12">
					          <s:textfield name="addScore1" id="addScore1" required="true" class="validate ip"/>
					          <label for="score">คะแนน รูปเล่ม</label>
					        </div>
				        </div>
				        <div class="row">
					    	<div class="input-field col s12">
					          <s:textfield name="addScore2" id="addScore2" required="true" class="validate ip"/>
					          <label for="score">คะแนน ความรู้</label>
					        </div>
				        </div>
				        <div class="row">
					    	<div class="input-field col s12">
					          <s:textfield name="addScore3" id="addScore3" required="true" class="validate ip"/>
					          <label for="score">คะแนน การตอบคำถาม</label>
					        </div>
				        </div>
				    	<div class="center-align">
					    	<button  type="submit" id="btn-e" class="modal-action modal-close waves-effect waves-green  btn ">Save</button>
					    	<a href="viewProjectAll" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
					    </div>
				    </div>
			    </form>
			    <div class="card " style="padding:10px;">
			    <h5 class="cyan-text text-darken-1">Project Details</h5><br>
			      <div class="row">
				    
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
						    <s:select list="mapCourse" name="proModel.course_id" class="validate ip" value="proModel.course_id" readonly="true"></s:select>
						    <label>Course</label>
						</div>
				        <div class="input-field col s12">
						    <s:select list="mapTeacher" name="proModel.teacher_id" class="validate ip" value="proModel.teacher_id"  readonly="true"></s:select>
						    <label>Teacher Adviser</label>
						</div>
				      </div>
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
			 $('select').material_select();
			 $('input.autocomplete').autocomplete({
			    data:{
			    	 "56013506 Noppol kongsattra. ": null,
				     "56013509 Manuwat Chaichana. ": null
			      }
			 });
			 
			 $('#autocomplete-input2').on('keyup', function (e) {
		            // Capture Enter
		            if (e.which === 13) {
		            	$('.chips').append('<div class="chip">'+$('#autocomplete-input2').val()+'<i class="close material-icons">close</i></div>');
		            	$('#autocomplete-input2').val('');
		            	
		              return;
		            }
			 });
			
			$('#btn-e').on('click',function(){
				if($('#btn-e').val()==0){
					
					$('.chip').append('<i class="close material-icons">close</i>');
					$('.s').hide();
					$('.se').show();
					$('.auc').show();
					$('.ip').removeAttr('disabled');
					$('#btn-e').removeClass('orange waves-orange').addClass('waves-green').text('Save').val(1);
				}else{
			
					
					$('.close').remove();
					$('.s').show();
					$('.se').hide();
					$('.auc').hide();
					$('.ip').attr('disabled','disabled');
					$('#btn-e').removeClass('waves-green').addClass('orange waves-orange').text('Edit').val(0);
				}
			});
			
		});
		</script>
		
	</body>
</html>