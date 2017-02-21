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
		<link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
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
				          <s:textfield name="proModel.score4" class="validate" required="true" maxlength="3" autocomplete="off" />
				          <label for="score4">คะแนนสอบครั้งที่ 1</label>
				        </div>
				        <div class="col s12">
				        	<p style="margin-bottom: 0; color:#26a69a !important;">Course</p>
							<s:select style="width: 100%" list="mapCourse" name="proModel.course_id" id="course_id"></s:select>
						 </div>
						 <div class="col s12">
				        	<p style="margin-bottom: 0; color:#26a69a !important;">Section</p>
				        	<select style="width: 100%" id="ddlSection" name="proModel.sectionId">
								<option  value="">Select an option</option>
							</select>
						 </div>
				        <div class=" col s12">
				        	<p style="margin-bottom: 0; color:#26a69a !important;">Teacher Adviser</p>
						    <s:select style="width: 100%" list="mapTeacher" name="proModel.teacher_id" id="teacher_id"></s:select>
						    
						</div>
				      </div>
				    </div>
				  </div>
			     
		    </div>
		     <div class="center-align">
		      <button type="submit" id="save" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
		      <a href="viewProjectAll" type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</a>
		      </div>
		      </form>
		    </div>
		  </div>  
		    
		</main>
		<script type="text/javascript" src="js/sweetalert2.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 
			 $('.m1').addClass('active');
			 $('.m1-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Project');
			 $('#course_id, #teacher_id').select2();
			 $('#save').click(function(e){
				if($('#ddlSection').val() == ''){
					swal(
					  'ไม่สามารถเพิ่มข้อมูล Project',
					  'กรุณาเลือกข้อมูล Section ให้แก่ Project',
					  'warning'
					)
					e.preventDefault();
				}
			 });
			 
			 $('#course_id').change(function(){
				$('#ddlSection').val("").trigger("change");
			 });
			 
			 $("#ddlSection").select2({
					ajax: {
					    url: "ajax/getSection.jsp",
					    delay: 1000,
					    data: function (params) {
					      return {
					        q: params.term, // search term
					        courseId:$('#course_id').val()
					      };
					    },
					    processResults: function (data, params) {
					      // parse the results into the format expected by Select2
					      // since we are using custom formatting functions we do not need to
					      // alter the remote JSON data, except to indicate that infinite
					      // scrolling can be used
					      params.page = params.page || 1;

					      return {
					        results: data.results,
					        pagination: {
					          more: (params.page * 30) < data.total_count
					        }
					      };
					    },
					    cache: true
				  	}
			  	});
			 //$("#target option:first").attr('selected','selected');
		});
		</script>
		
	</body>
</html>