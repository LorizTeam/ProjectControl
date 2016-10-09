<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Branch Detail</title>
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
		        <a href="#!" class="breadcrumb">Branch Detail</a>
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
				<form class="container" action="updateBranch" method="post">
				<h4 class="center-align light-blue-text text-darken-1">Branch Detail</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Branch Details</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s12 se"style="display:none;">
									<s:select list="mapFacModel" name="braModel.facultyId"  readonly="true" value="braModel.facultyId"></s:select>
									<label>Faculty</label>
								</div>
								<div class="input-field col s12 m6">
									<s:hidden name="braModel.id" />
									<s:textfield id="code" type="text"  class="validate ip" readonly="true" name="braModel.code"/>
									<label for="code">Branch Code</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameth" type="text"  class="validate ip" readonly="true" name="braModel.nameth"/>
									<label for="nameth">Branch Name (TH)</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameen" type="text"  class="validate ip" readonly="true" name="braModel.nameen"/>
									<label for="nameen">Branch Name(EN)</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="center-align">
					<button value="0" type="button" id="btn-e" class="modal-action modal-close waves-effect waves-orange  orange btn ">Edit</button>
			    	<s:url action="deleteBranch" var="delLink">
						<s:param name="braModel.id"><s:property value="braModel.id"/></s:param>
					</s:url>
					<a href='<s:property value="delLink"/>' class="waves-effect waves-red  red btn ">Delete</a>
			    	<a href="viewAllBranch" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
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
			 $('.page-title').text('Branch Detail');
			 $('select').material_select();
			
			 $('#btn-e').on('click',function(){
			 	if($('#btn-e').val()==0){
			 		$('.s').hide();
					$('.se').show();
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