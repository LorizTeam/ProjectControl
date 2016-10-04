<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Branch Controller : Branch List</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="css/responsive.dataTables.css"/>
		<style>
			#Branch-table_filter,#Branch-table_length{
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
		        <a href="#!" class="breadcrumb">Branch</a>
		      </div>
		    </div>
		    <div class="div-container">
			    <div class="row" >
			    	<div class="col s12 m6">
			    		<a class="waves-effect waves-light btn-large col s12 " href="branch-add.jsp">
	      					<i class="material-icons left">add</i>Add Branch
	      				</a>
			    	</div>
			    </div>
			    <div class="card" style="padding:10px;">
			    	<div class="row">
					<div class="input-field col s12 m4 offset-m8">
						<i class="material-icons prefix right">search</i>
				        <input type="text" id="icon_search" class="validate"/>
				        <label for="icon_search">Search</label>
					</div>
					</div>
				    <table id="Branch-table" class="responsive highlight">
				    	<thead>
				    		<tr>
				    			<th data-priority="1">No.</th>
				    			<th data-priority="1">Branch ID</th>
				    			<th data-priority="1">Branch Code</th>
				    			<th data-priority="1">Branch Name TH</th>
				    			<th data-priority="1">Branch Name EN</th>
				    		</tr>
				    		
				    	</thead>
				    	<tbody>
				    		<tr>
				    			<td>1</td>
				    			<td>รหัสสาขา</td>
				    			<td>โค๊ดสาขา</td>
				    			<td><a href="Branch-detail.jsp">ชื่อสาขา TH</a></td>
				    			<td>ชื่อสาขา EN</td>
				    		</tr>
				    		<tr>
				    			<td>2</td>
				    			<td>รหัสสาขา</td>
				    			<td>โค๊ดสาขา</td>
				    			<td><a href="Branch-detail.jsp">ชื่อสาขา TH</a></td>
				    			<td>ชื่อสาขา EN</td>
				    		</tr>
				    		<tr>
				    			<td>3</td>
				    			<td>รหัสสาขา</td>
				    			<td>โค๊ดสาขา</td>
				    			<td><a href="Branch-detail.jsp">ชื่อสาขา TH</a></td>
				    			<td>ชื่อสาขา EN</td>
				    		</tr>
				    	</tbody>
				    </table>
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
			 $('.m6').addClass('active');
			 $('.m6-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Branch');
			 $('select').material_select();
			 var table =  $('#Branch-table').DataTable({
				    responsive: true
			 });
			 $('#icon_search').on( 'keyup', function () {
				    table.search( this.value ).draw();
				});
		  });
		</script>
		
	</body>
</html>