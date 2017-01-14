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
		        <a href="#!" class="breadcrumb">Change Password Student</a>
		        
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
				<form class="container" method="post" action="ChangePasswordStudent" id="updatePassword">
				<h4 class="center-align light-blue-text text-darken-1">Change Password Student</h4>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Personal Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s12">
									<s:textfield name="stdModel.username" required="true" readonly="true"/>
									<label>Username</label>
								</div>
								<div class="input-field col s12">
									<s:password name="stdModel.password" id="password" class="password" required="true"/>
									<label>Password</label>
								</div>
								<div class="input-field col s12">
									<s:password name="stdModel.cpassword" id="cpassword" class="password" required="true"/>
									<label>Comfirm Password</label>
								</div>
								<div class="col s12">
									<div class="red-text text-darken-1" id="textAlert"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="center-align">
					<button type="submit" id="save" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
					<button type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</button>
				</div>
		    </form>
		  </div>  
		    
		</main>
		<script type="text/javascript">
		function validatePassword() {
			var password = $("#password").val();
			var cpassword = $("#cpassword").val();
			if(password == cpassword){
				$("#textAlert").html("");
			     return true;
			}else{
				$("#textAlert").html("Password not match");
				 return false;
			}
		}
		 $(document).ready(function(){
			 
			 
			 $('.m2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Change Password Student');
			 $('select').material_select();
			 $('.password').keyup(function(){
				 validatePassword();
			 });
			 $('#save').click(function(event){
				 if(!validatePassword()){
					 event.preventDefault();
				 }
			 });
			 
		});
		</script>
		
	</body>
</html>