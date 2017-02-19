<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Project List</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="css/responsive.dataTables.css"/>
		<style>
			#project-table_filter,#project-table_length{
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
		        <a href="#!" class="breadcrumb">Project Random</a>
		      </div>
		    </div>
		    <div class="div-container">
		    	<s:if test="%{#session.type == 3 }">
		    		<div class="row" >
				    	<div class="col s12 m6">
				    		<a class="waves-effect waves-light btn-large col s12 " href="viewProjectAll">
		      					<i class="material-icons left">view_list</i>Project List
		      				</a>
				    	</div>
				    	<div class="col s12 m6">
				    		<a type="button" href="randomSequenceProject" class="waves-effect waves-light light-green darken-3 btn-large col s12">
				    			<i class="material-icons left">replay</i>Random Project Again
				    		</a>
				    	</div>
				    </div>
				</s:if>
			    
			    <div class="card" style="padding:10px;">
			    	<div class="row">
					<div class="input-field col s12 m4 offset-m8">
						<i class="material-icons prefix right">search</i>
				        <input type="text" id="icon_search" class="validate"/>
				        <label for="icon_search">Search</label>
					</div>
					</div>
				    <table id="project-table" class="responsive highlight">
				    	<thead>
				    		<tr>
				    			<th data-priority="1">Queue</th>
				    			<th data-priority="1">Project ID</th>
				    			<th data-priority="1">Project Name TH</th>
				    			<th data-priority="1">Project Name EN</th>
				    			<th data-priority="2">Adviser</th>
				    			<th data-priority="3">Score</th>
				    			<th data-priority="2">Course</th>
				    			<th data-priority="2">Section</th>
				    			<th data-priority="3">Faculty</th>
				    			<th data-priority="3">Creation Date</th>
				    		</tr>
				    		
				    	</thead>
				    	<tbody>
				    		<s:iterator value="listProModel" status="statusList">
				    			<tr>
					    			<td><s:property value="#statusList.count"/> </td>
					    			<td><s:property value="project_id"/> </td>
					    			<s:url action="viewProjectDetail" var="urlLink">
					    				<s:param name='proModel.project_id'><s:property value="project_id"/></s:param>
					    			</s:url>
					    			<td><a href='<s:property value="urlLink"/>'> <s:property value="project_nameth"/></a></td>
					    			<td><s:property value="project_nameen"/></td>
					    			<td><s:property value="firstname"/></td>
					    			<td><s:property value="showScoreProject"/></td>
					    			<td><s:property value="course_nameth"/></td>
					    			<td><s:property value="sectionName"/></td>
					    			<td><s:property value="faclulty_nameth"/></td>
					    			<td><s:property value="createdatetime"/></td>
					    		</tr>
				    		</s:iterator>
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
			 $('.m1').addClass('active');
			 $('.m1-3').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Project');
			 $('select').material_select();
			 var table =  $('#project-table').DataTable({
				 "bSort": false
			 });
			 $('#icon_search').on( 'keyup', function () {
				    table.search( this.value ).draw();
				});
		  });
		</script>
		
	</body>
</html>