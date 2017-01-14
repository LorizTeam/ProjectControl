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
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">File</a>
		      </div>
		    </div>
		    <div class="div-container">
			    <div class="row ">
			    	<s:iterator value="listGroupFile">
				    	<div class="col s12 m6 ">
			    			<div class="card  hoverable" style="padding:10px;">
						    	 <blockquote><s:property value="fileGroupNameTh"/> </blockquote>
								 <ul class="collapsible" data-collapsible="accordion">
								 	<s:iterator value="listFile">
									    <li>
									      <div class="card-content">
									      	<a href="<s:property value="filePath"/>" target="_blank" class="waves-effect waves-light light-green darken-3 btn"><i class="fa fa-download"></i> </a> 
									      	 <s:property value="fileNameTh"/>
									      </div>
									    </li>
								    </s:iterator>
								  </ul>
						    </div>
					    </div>
				  </s:iterator>  
			    </div>
			    
		    </div>
		</main>
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.responsive.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m4').addClass('active');
			 $('.m4-1').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('File');
			 $('select').material_select();
			 
		  });
		 
		</script>
		
	</body>
</html>