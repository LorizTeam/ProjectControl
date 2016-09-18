<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Employee Detail</title>
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
		        <a href="Employee.jsp" class="breadcrumb">Employee Detail</a>
		        <a href="#!" class="breadcrumb">Employee Detail</a>
		      </div>
		    </div>
		    <div class="div-container ">
				<form class="container" method="post">
				<h4 class="center-align light-blue-text text-darken-1">Employee Detail</h4>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Branch Details</h5>
					<div class="row">
						<div class="input-field col s6 s">
						    <input id="Faculty" type="text" class="validate " value="IT" disabled>
				          	<label for="Faculty">Faculty</label>
						</div>
						<div class="input-field col s6 se"style="display:none;">
							<select>
								<option value="" disabled selected>Choose your option</option>
								<option value="1">Identification number</option>
								<option value="2">Passport number</option>
							</select>
							<label>Faculty</label>
						</div>
						<div class="input-field col s6 s">
						    <input id="Branch" type="text" class="validate " value="ICT" disabled>
				          	<label for="Branch">Branch</label>
						</div>
						<div class="input-field col s6 se"style="display:none;">
							<select>
								<option value="" disabled selected>Choose your option</option>
								<option value="1">Identification number</option>
								<option value="2">Passport number</option>
							</select>
							<label>Branch</label>
						</div>
					</div>
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Personal Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s6">
									<input  id="first_name" type="text" class="validate ip" disabled>
									<label for="first_name">First Name(TH)</label>
								</div>
								<div class="input-field col s6">
									<input id="last_name" type="text" class="validate ip"disabled>
									<label for="last_name">Last Name (TH)</label>
								</div>
								<div class="input-field col s6">
									<input  id="first_nameen" type="text" class="validate ip"disabled>
									<label for="first_nameen">First Name(EN)</label>
								</div>
								<div class="input-field col s6">
									<input id="last_nameen" type="text" class="validate ip"disabled>
									<label for="last_nameen">Last Name (EN)</label>
								</div>
								<div class="input-field col s6 m4">
									<input id="Identification" type="text" class="validate ip"disabled>
									<label for="Identification">Identification</label>
								</div>
								<div class="input-field col s6 m3 s">
								    <input id="IdentificationType" type="text" class="validate " value="Identification" disabled>
						          	<label for="IdentificationType">Identification Type</label>
								</div>
								<div class="input-field col s6 m3 se"style="display:none;">
									<select>
										<option value="" disabled selected>Choose your option</option>
										<option value="1">Identification number</option>
										<option value="2">Passport number</option>
									</select>
									<label>Identification Type</label>
								</div>
								<div class="input-field col s6 m5" >
									<input id="Tel" type="text" class="validate ip" disabled>
									<label for="Tel">Tel</label>
								</div>
								<div class="input-field col s6" >
									<input id="mail" type="email" class="validate ip" disabled>
									<label for="mail">E-mail</label>
								</div>
								<div class="input-field col s6" >
									<input id="LINE" type="text" class="validate ip" disabled>
									<label for="LINE">ID LINE</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Address Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s6 m2">
									<input  id="addr_No" type="text" class="validate ip" disabled>
									<label for="addr_No">No.</label>
								</div>
								<div class="input-field col s6 m4">
									<input id="Bloc" type="text" class="validate ip" disabled>
									<label for="Bloc">Bloc</label>
								</div>
								<div class="input-field col s6">
									<input  id="Village" type="text" class="validate ip" disabled>
									<label for="Village">Village</label>
								</div>
								<div class="input-field col s6">
									<input id="Alley" type="text" class="validate ip" disabled>
									<label for="Alley">Alley</label>
								</div>
								<div class="input-field col s6">
									<input id="Road" type="text" class="validate ip" disabled>
									<label for="Road">Road</label>
								</div>
								<div class="input-field col s6 m4 s">
								    <input id="Province" type="text" class="validate " value="Bangkok" disabled>
						          	<label for="Province">Province</label>
								</div>
								<div class="input-field col s6 m4 se"style="display:none;">
									<select>
										<option value="" disabled selected>Choose your option</option>
										<option value="1">Identification number</option>
										<option value="2">Passport number</option>
									</select>
									<label>Province</label>
								</div>
								<div class="input-field col s6 m4 s">
								    <input id="Amphur" type="text" class="validate " value="BangRak" disabled>
						          	<label for="Amphur">District(Amphur)</label>
								</div>
								<div class="input-field col s6 m4 se"style="display:none;">
									<select>
										<option value="" disabled selected>Choose your option</option>
										<option value="1">Identification number</option>
										<option value="2">Passport number</option>
									</select>
									<label>District(Amphur)</label>
								</div>
								<div class="input-field col s6 m4 s">
								    <input id="District" type="text" class="validate " value="BangRak" disabled>
						          	<label for="District">District</label>
								</div>
								<div class="input-field col s6 m4 se"style="display:none;">
									<select>
										<option value="" disabled selected>Choose your option</option>
										<option value="1">Identification number</option>
										<option value="2">Passport number</option>
									</select>
									<label>District</label>
								</div>
								<div class="input-field col s6 m4">
									<input id="Zipcode" type="text" class="validate ip" disabled>
									<label for="Zipcode">Zipcode</label>
								</div>
								
							</div>
						</div>
					</div>
				</div>
				<div class="center-align">
					<button id="btn-e" type="button" class="modal-action modal-close waves-effect waves-orange  orange btn " value="0">Edit</button>
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
			 $('.m5').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Employee Detail');
			 $('select').material_select();
			 
			 
			 $('#btn-e').on('click',function(){
					if($('#btn-e').val()==0){
						
						$('.s').hide();
						$('.se').show();
						$('.ip').removeAttr('disabled');
						$('#btn-e').removeClass('orange waves-orange').addClass('waves-green').text('Save').val(1);
					}else{
				
						
						$('.s').show();
						$('.se').hide();
						$('.ip').attr('disabled','disabled');
						$('#btn-e').removeClass('waves-green').addClass('orange waves-orange').text('Edit').val(0);
					}
				});
			 
		});
		</script>
		
	</body>
</html>