<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Teacher Detail</title>
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
		        <a href="viewAllTeacher" class="breadcrumb">Teacher Detail</a>
		        <a href="#!" class="breadcrumb">Teacher Detail</a>
		      </div>
		    </div>
		    <div class="div-container ">
		    	<s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
				<form class="container" method="post" action="updateTeacher">
				<h4 class="center-align light-blue-text text-darken-1">Teacher Detail</h4>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Personal Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s6">
									<s:select list="mapPrename" name="teaModel.prename_id" id="ddlPrename" value="teaModel.prename_id"  class="validate ip" readonly="true" ></s:select>
									<label>คำนำหน้าชื่อ</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="teaModel.teacher_id" required="true" class="validate ip" readonly="true"/>
									<s:hidden name="teaModel.oldteacher_id" value="%{teaModel.teacher_id}"/> 
									<label>รหัสอาจารย์</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="teaModel.firstname" required="true" class="validate ip" readonly="true"/>
									<label for="first_name">First Name(TH)</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="teaModel.lastname" required="true" class="validate ip" readonly="true"/>
									<label for="last_name">Last Name (TH)</label>
								</div>
								<div class="input-field col s6">
									<select name="teaModel.identification_type_id" class="validate ip" readonly="true">
										<option value="" disabled selected>โปรดเลือกรูปแบบรหัสประจำตัว</option>
										<option value="1" selected>รหัสประจำตัวประชาชน</option>
										<option value="2">Passport</option>
									</select>
									<label>Identification Type</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="teaModel.identification" required="true" class="validate ip" readonly="true"/>
									<label for="Identification">Identification</label>
								</div>
								<div class="input-field col s12">
									<s:textfield name="teaModel.email" required="true" class="validate ip" readonly="true"/>
									<label for="mail">E-mail</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="teaModel.tel_number" required="true" class="validate ip" readonly="true"/>
									<label for="Tel">Tel</label>
								</div>
								
								<div class="input-field col s6">
									<s:textfield name="teaModel.line_id"  class="validate ip" readonly="true"/>
									<label for="LINE">ID LINE</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="center-align">
					<button id="btn-e" type="button" class="modal-action modal-close waves-effect waves-orange  orange btn " value="0">Edit</button>
					<s:url action="deleteTeacher" var="delLink" >
	    				<s:param name="teaModel.teacher_id"><s:property value="teaModel.teacher_id"/></s:param>
	    			</s:url>
	    			<a href='<s:property value="delLink"/>' class="waves-effect waves-red  red btn ">Delete</a>
					<a href="project.jsp" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
				</div>
		    </form>
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
			 $('.m3').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Teacher Detail');
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