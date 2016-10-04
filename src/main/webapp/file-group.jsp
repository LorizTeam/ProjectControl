<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>File Controller : File List</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="css/responsive.dataTables.css"/>
		<style>
			#File-table_filter,#File-table_length{
				display:none;
			}
		</style>
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="index.jsp" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">File</a>
		      </div>
		    </div>
		    <div class="div-container">
				<div class="row" >
					<div class="col s12">
						<div class="input-field col s12 m8">
							<div class="chips ">
							</div>
						</div>
						<div class="input-field col s4 auc">
							<i class="material-icons prefix">search</i>
							<input type="text" id="autocomplete-input2" class="autocomplete">
							<label for="autocomplete-input2">Search</label>
						</div>
					</div>
					<div class="col s12 m6">
						<a class="waves-effect waves-light btn-large col s12 " href="File-add.jsp">
						<i class="material-icons left">clear_all</i>File List
						</a>
					</div>
					<div class="col s12 m6">
						<a class="waves-effect waves-light light-green darken-3  btn-large col s12 " href="File-add.jsp">
						<i class="material-icons left">add</i>Add File
					</a>
					</div>
				</div>
			    <div class="row ">
			    	<div class="col s12 m4 ">
					    <div class="card  hoverable" style="padding:10px;">
					    	 <blockquote>Information and Communication Technology </blockquote>
							 <ul class="collapsible" data-collapsible="accordion">
							    <li>
							      <div class="collapsible-header">HUM 203 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							    <li>
							      <div class="collapsible-header">ICT 403 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							    <li>
							      <div class="collapsible-header">CSC 401 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							  </ul>
					    </div>
				    </div>
				    <div class="col s12 m4 ">
					    <div class="card  hoverable" style="padding:10px;">
					    	 <blockquote>Information and Communication Technology </blockquote>
							 <ul class="collapsible" data-collapsible="accordion">
							    <li>
							      <div class="collapsible-header">HUM 203 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							    <li>
							      <div class="collapsible-header">ICT 403 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							    <li>
							      <div class="collapsible-header">CSC 401 ชื่อวิชา</div>
							      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
							    </li>
							  </ul>
					    </div>
				    </div>
				    <div class="col s12 m4 ">
					    <div class="card  hoverable" style="padding:10px;">
					    	 <blockquote>Information and Communication Technology </blockquote>
							 <ul class="collapsible" data-collapsible="accordion">
							    <li>
							      <div class="collapsible-header">HUM 203 ชื่อวิชา</div>
							      <div class="collapsible-body collection">
								        <a href="#!" class="collection-item"><i class="material-icons">description</i> </a>
								        <a href="#!" class="collection-item "><i class="material-icons">description</i> Lession</a>
								        <a href="#!" class="collection-item"><i class="material-icons">description</i> Alvin</a>
								        <a href="#!" class="collection-item"><i class="material-icons">description</i> Alvin</a>
								  </div>
							    </li>
							    <li>
							      <div class="collapsible-header">ICT 403 ชื่อวิชา</div>
							      <div class="collapsible-body">
							      
							      </div>
							    </li>
							    <li>
							      <div class="collapsible-header">CSC 401 ชื่อวิชา</div>
							      <div class="collapsible-body">
							      
							      </div>
							    </li>
							  </ul>
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
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.responsive.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m4').addClass('active');
			 $('.m4-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('File');
			 $('select').material_select();
			 $('input.autocomplete').autocomplete({
				    data:{
				        "IT Information Technology. ": null,
				        "BUS Business Computer ": null
				      }
			 });
			 $('#autocomplete-input2').on('keyup', function (e) {
		            // Capture Enter
		            if (e.which === 13&&$('#autocomplete-input2').val()!='') {
		            	$('.chips').append('<div class="chip">'+$('#autocomplete-input2').val()+'<i class="close material-icons">close</i></div>');
		            	$('#autocomplete-input2').val('');
		            	
		              return;
		            }
			 });
			 $('.addstu').on('click', function(){
				 
				 if ($('#autocomplete-input2').val()!='') {
				 
	            	$('.chips').append('<div class="chip">'+$('#autocomplete-input2').val()+'<i class="close material-icons">close</i></div>');
	            	$('#autocomplete-input2').val('');
	            	
	              return;
				 }
			 });
		  });
		 
		</script>
		
	</body>
</html>