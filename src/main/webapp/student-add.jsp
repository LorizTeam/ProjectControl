<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Add Student</title>
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
		        <a href="#!" class="breadcrumb">Add Student</a>
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
				<form class="container" method="post" action="AddStudent">
				<h4 class="center-align light-blue-text text-darken-1">Add Student</h4>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Branch Details</h5>
					<div class="row">
						<div class="input-field col s12">
							<s:select list="mapBranch" name="stdModel.branchId" ></s:select>
							<label>Branch</label>
						</div>
						<div class="input-field col s6">
							<s:textfield name="stdModel.receiveYear" required="true" maxlength="4"/>
							<label for="receiveYear">รุ่น </label>
						</div>
					</div>
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Personal Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s6">
									<s:select list="mapPrename" name="stdModel.prename_id" id="ddlPrename" ></s:select>
									<label>คำนำหน้าชื่อ</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.student_id" required="true"/>
									<label>รหัสนักศึกษา</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.firstname" required="true"/>
									<label for="first_name">First Name(TH)</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.lastname" required="true"/>
									<label for="last_name">Last Name (TH)</label>
								</div>
								<div class="input-field col s6">
									<select name="stdModel.identification_type_id">
										<option value="" disabled selected>โปรดเลือกรูปแบบรหัสประจำตัว</option>
										<option value="1" selected>รหัสประจำตัวประชาชน</option>
										<option value="2">Passport</option>
									</select>
									<label>Identification Type</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.identification" required="true"/>
									<label for="Identification">Identification</label>
								</div>
								<div class="input-field col s12">
									<s:textfield name="stdModel.email" required="true"/>
									<label for="mail">E-mail</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.tel_number" required="true"/>
									<label for="Tel">Tel</label>
								</div>
								
								<div class="input-field col s6">
									<s:textfield name="stdModel.line_id" />
									<label for="LINE">ID LINE</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="center-align">
					<button type="submit" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
					<button type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</button>
				</div>
		    </form>
		  </div>  
		    
		</main>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $("#ddlPrename option:first").attr('disabled', 'disabled');
			 $('.m2').addClass('active');
			 $('.m2-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Student');
			 $('select').material_select();
			
			 
		});
		</script>
		
	</body>
</html>