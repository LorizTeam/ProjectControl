<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Add Course</title>
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
		        <a href="#!" class="breadcrumb">Add Course</a>
		      </div>
		    </div>
		    <div class="div-container ">
				<form class="container" method="post">
				<h4 class="center-align light-blue-text text-darken-1">Add Course</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Course Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col 12 m6">
									<select>
										<option value="" disabled selected>Choose Your Faculty</option>
										<option value="1">ICT</option>
										<option value="2">BUS</option>
									</select>
									<label>Faculty</label>
								</div>
								<div class="input-field col s12 m6">
									<input  id="first_name" type="text" class="validate">
									<label for="first_name">Course Code</label>
								</div>
								<div class="input-field col s12 m6">
									<input id="last_name" type="text" class="validate">
									<label for="last_name">Course Name (TH)</label>
								</div>
								<div class="input-field col s12 m6">
									<input  id="first_nameen" type="text" class="validate">
									<label for="first_nameen">Course Name(EN)</label>
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
			 $('.m6').addClass('active');
			 $('.m6-3').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Course');
			 $('select').material_select();
			
			 
		});
		</script>
		
	</body>
</html>