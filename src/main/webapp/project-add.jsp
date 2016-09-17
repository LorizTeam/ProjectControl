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
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
		<style>
			#stu-table_filter,#stu-table_length{
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
		        <a href="#!" class="breadcrumb">Add Project</a>
		      </div>
		    </div>
		    <div class="div-container ">
			   <div class="container">
			    <div class="card " style="padding:10px;">
				     <h4 class="center-align">Add Project</h4>
				     
			      <div class="row">
				    <form class="col s12">
				      <div class="row">
				        <div class="input-field col s12">
				          <input  id="first_name" type="text" class="validate">
				          <label for="first_name">Project Name(TH)</label>
				        </div>
				        <div class="input-field col s12">
				          <input id="last_name" type="text" class="validate">
				          <label for="last_name">Project Name (EN)</label>
				        </div>
				        <div class="input-field col s12">
						    <select >
						      <option value="" disabled selected>Choose Project Teacher</option>
						      <option value="1">aj.benz</option>
						      <option value="2">aj.rorh</option>
						      <option value="3">aj.ring</option>
						    </select>
						    <label>Teacher Adviser</label>
						</div>
						<div class="input-field col s12 m4 offset-m8">
							<i class="material-icons prefix right">search</i>
					        <input type="text" id="icon_search" class="validate"/>
					        <label for="icon_search">Search</label>
						</div>
				       	<table class="highlight responsive-table " id="stu-table">
				    	<thead>
				    		<tr>
				    			<th>Choose</th>
				    			<th>Student ID</th>
				    			<th>Student Name</th>
				    			<th>Faculty</th>
				    			<th>Branch</th>
				    		</tr>
				    		
				    	</thead>
				    	<tbody>
				    		<tr>
				    			<td>
							      <input type="checkbox" value="56013506" id="56013506" />
							      <label for="56013506"></label>
							    </td>
				    			<td>56013506</td>
				    			<td>student name</td>
				    			<td>ICT</td>
				    			<td>IT</td>
				    		</tr>
				    		<tr>
				    			<td>
							      <input type="checkbox" value="56013507" id="56013507" />
							      <label for="56013507"></label>
							    </td>
				    			<td>56013507</td>
				    			<td>student name</td>
				    			<td>ICT</td>
				    			<td>IT</td>
				    			
				    		</tr>
				    		<tr>
				    			<td>
							      <input type="checkbox" value="56013508" id="56013508" />
							      <label for="56013508"></label>
							    </td>
				    			<td>56013508</td>
				    			<td>student name</td>
				    			<td>ICT</td>
				    			<td>IT</td>
				    		</tr>
				    	</tbody>
				    </table>
				      </div>
				    </form>
				  </div>
			      <div class="center-align">
			      <button type="submit" class="modal-action modal-close waves-effect waves-green btn ">Submit</button>
			      <button type="button" class="modal-action modal-close waves-effect waves-yellow orange btn ">Cancel</button>
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
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m1').addClass('active');
			 $('.m1-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Add Project');
			 $('select').material_select();
			var table =  $('#stu-table').DataTable();
			 $('#icon_search').on( 'keyup', function () {
				    table.search( this.value ).draw();
				});
		});
		</script>
		
	</body>
</html>