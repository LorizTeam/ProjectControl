<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Student Detail</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">Student Detail</a>
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
				<form class="container" method="post" action="UpdateStudent">
				<h4 class="center-align light-blue-text text-darken-1">Student Detail</h4>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Branch Details</h5>
					<div class="row">
						<div class="input-field col s12">
							<s:select list="mapBranch" name="stdModel.branchId" value="stdModel.branchId" class="validate ip" readonly="true"></s:select>
							<label>Branch</label>
						</div>
						<div class="input-field col s6">
							<s:textfield name="stdModel.receiveYear" class="validate ip" readonly="true" maxlength="4"/>
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
									<s:select list="mapPrename" name="stdModel.prename_id" id="ddlPrename" value="stdModel.prename_id" class="validate ip" readonly="true"></s:select>
									<label>คำนำหน้าชื่อ</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.student_id" class="validate ip" readonly="true"/>
									<s:hidden name="stdModel.oldstudent_id" value='%{stdModel.student_id}'/>
									<label>รหัสนักศึกษา</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.firstname" class="validate ip" readonly="true"/>
									<label for="first_name">First Name(TH)</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.lastname" class="validate ip" readonly="true"/>
									<label for="last_name">Last Name (TH)</label>
								</div>
								<div class="input-field col s6">
									<select name="stdModel.identification_type_id" class="validate ip" readonly="true">
										<option value="" disabled selected>โปรดเลือกรูปแบบรหัสประจำตัว</option>
										<option value="1" selected="selected">รหัสประจำตัวประชาชน</option>
										<option value="2">Passport</option>
									</select>
									<label>Identification Type</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.identification" class="validate ip" readonly="true"/>
									<label for="Identification">Identification</label>
								</div>
								<div class="input-field col s12">
									<s:textfield name="stdModel.email" class="validate ip" readonly="true"/>
									<label for="mail">E-mail</label>
								</div>
								<div class="input-field col s6">
									<s:textfield name="stdModel.tel_number" class="validate ip" readonly="true"/>
									<label for="Tel">Tel</label>
								</div>
								
								<div class="input-field col s6">
									<s:textfield name="stdModel.line_id" class="validate ip" readonly="true"/>
									<label for="LINE">ID LINE</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Section</h5>
					    <table id="sectionTable" class="highlight  responsive" >
					    	<thead>
					    		<tr>
					    			<th data-priority="1">เซคชั่น</th>
					    			<th data-priority="1">ปี</th>
					    			<th data-priority="1">จัดการ</th>
					    		</tr>
					    		
					    	</thead>
					    	<tbody>
					    		<s:iterator value="listStudentSection">
					    			<tr>
						    			<td><s:property value="sectionName"/></td>
						    			<td><s:property value="year"/></td>
						    			<td><s:property value="sectionId"/></td>
						    		</tr>
					    		</s:iterator>
					    	</tbody>
					    </table>
					</div>
				</div>
				<div class="center-align">
					<button id="btn-e" type="button" class="modal-action modal-close waves-effect waves-orange  orange btn " value="0">Edit</button>
					<s:url action="DeleteStudent" var="delLink">
						<s:param name="stdModel.student_id"><s:property value="stdModel.student_id"/></s:param>
					</s:url>
					<a href='<s:property value="delLink"/>' class="waves-effect waves-red  red btn ">Delete</a>
					<a href="viewAllStudent" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
				</div>
		    </form>
		  </div>  
		    
		</main>
	    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Student Detail');
			 $('select').material_select();
			 var table =  $('#sectionTable').DataTable();
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