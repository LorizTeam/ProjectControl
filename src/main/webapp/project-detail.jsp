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
		
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="index.jsp" class="breadcrumb">Dash board</a>
		        <a href="project.jsp" class="breadcrumb">Project List</a>
		        <a href="#!" class="breadcrumb">Project Details</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container"> 
			   <h4 class="center-align light-blue-text text-darken-1">Project Details</h4>
			   
			    <div class="card " style="padding:10px;">
			    <h5 class="cyan-text text-darken-1">Project Details</h5><br>
			      <div class="row">
				    <form class="col s12">
				      <div class="row">
				        <div class="input-field col s12">
				          <input  id="first_name" type="text" class="validate ip" value="ร้านขายของ" disabled>
				          <label for="first_name">Project Name(TH)</label>
				        </div>
				        <div class="input-field col s12">
				          <input id="last_name" type="text" class="validate ip" value="Store"disabled>
				          <label for="last_name">Project Name (EN)</label>
				        </div>
				        <div class="input-field col s12 s">
						    <input id="Teacher" type="text" class="validate " value="Aj.Pong"disabled>
				          	<label for="Teacher">Teacher Adviser</label>
						</div>
						<div class="input-field col s12 se"style="display:none;">
							<select>
								<option value="" disabled selected>Choose your option</option>
								<option value="1">aj.aod</option>
								<option value="1">aj.kob</option>
							</select>
							<label>Teacher</label>
						</div>
						<div class="input-field col s12">
							<div class="chips ">
								 <div class="chip">
								  56013506 Noppol kongsattra.
								  </div>
								  <div class="chip">
								  56013509 Manuwat Chaichana.
								  </div>
							</div>
						</div>
						<div class="input-field col s6 auc"style="display:none;">
						  <i class="material-icons prefix">recent_actors</i>
						  <input type="text" id="autocomplete-input2" class="autocomplete">
						  <label for="autocomplete-input2">Add Student</label>
						</div>
				      </div>
				    </form>
				  </div>
			      <div class="center-align">
			      <button value="0" type="button" id="btn-e" class="modal-action modal-close waves-effect waves-orange  orange btn ">Edit</button>
			      <a href="project.jsp" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
			      </div>
		    </div>
		    </div>
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
			 $('.m1').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Project Details');
			 $('select').material_select();
			 $('input.autocomplete').autocomplete({
			    data:{
			    	 "56013506 Noppol kongsattra. ": null,
				     "56013509 Manuwat Chaichana. ": null
			      }
			 });
			 
			 $('#autocomplete-input2').on('keyup', function (e) {
		            // Capture Enter
		            if (e.which === 13) {
		            	$('.chips').append('<div class="chip">'+$('#autocomplete-input2').val()+'<i class="close material-icons">close</i></div>');
		            	$('#autocomplete-input2').val('');
		            	
		              return;
		            }
			 });
			
			$('#btn-e').on('click',function(){
				if($('#btn-e').val()==0){
					
					$('.chip').append('<i class="close material-icons">close</i>');
					$('.s').hide();
					$('.se').show();
					$('.auc').show();
					$('.ip').removeAttr('disabled');
					$('#btn-e').removeClass('orange waves-orange').addClass('waves-green').text('Save').val(1);
				}else{
			
					
					$('.close').remove();
					$('.s').show();
					$('.se').hide();
					$('.auc').hide();
					$('.ip').attr('disabled','disabled');
					$('#btn-e').removeClass('waves-green').addClass('orange waves-orange').text('Edit').val(0);
				}
			});
			
		});
		</script>
		
	</body>
</html>