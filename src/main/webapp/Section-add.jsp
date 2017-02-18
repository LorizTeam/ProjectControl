<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Add Branch</title>
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
		        <a href="#!" class="breadcrumb">Add Branch</a>
		      </div>
		    </div>
		    <div class="div-container ">
				<form class="container" action="addBranch" method="post">
				<s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
				<h4 class="center-align light-blue-text text-darken-1">Add Branch</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Branch Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col 12 m6">
									<s:select list="mapFacModel" name="braModel.facultyId"></s:select>
									<label>Faculty</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="code" type="text"  class="validate" name="braModel.code"/>
									<label for="code">Branch Code</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameth" type="text"  class="validate" name="braModel.nameth"/>
									<label for="nameth">Branch Name (TH)</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameen" type="text"  class="validate" name="braModel.nameen"/>
									<label for="nameen">Branch Name(EN)</label>
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
			 $('.m6-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Branch');
			 $('select').material_select();
			
			 
		});
		</script>
		
	</body>
</html>