<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Faculty Detail</title>
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
		        <a href="#!" class="breadcrumb">Faculty Detail</a>
		      </div>
		    </div>
		    <div class="div-container ">
				<form class="container" method="post" action="updateFaculty">
				<h4 class="center-align light-blue-text text-darken-1">Faculty Detail</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Faculty Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s12 m4">
									<s:hidden name="facModel.id"/>
									<s:textfield id="facModel.code" class="validate ip" readonly="true" name="facModel.code" />
									<label for="code">Faculty Code</label>
								</div>
								<div class="input-field col s12 m4">
									<s:textfield id="facModel.nameth" class="validate ip" readonly="true" name="facModel.nameth" />
									<label for="nameth">Faculty Name (TH)</label>
								</div>
								<div class="input-field col s12 m4">
									<s:textfield id="facModel.nameen" class="validate ip" readonly="true" name="facModel.nameen" />
									<label for="nameen">Faculty Name(EN)</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="center-align">
					<button type="button" id="btn-e" class="modal-action modal-close waves-effect waves-orange  orange btn ">Edit</button>
					<s:url action="deleteFaculty" var="delLink">
						<s:param name="facModel.id"><s:property value="facModel.id"/></s:param>
					</s:url>
					<a href='<s:property value="delLink"/>' class="waves-effect waves-red  red btn ">Delete</a>
					<a href="viewAllFaculty" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
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
			 $('.m6-1').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Faculty Detail');
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