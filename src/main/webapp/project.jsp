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
		        <a href="#!" class="breadcrumb">Project</a>
		      </div>
		    </div>
		    <div class="div-container">
		    	<s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
		    	<form action="#" method="post">
		    	<s:if test="%{#session.type == 3 }">
		    		<div class="row" >
				    	<div class="col s12 m6">
				    		<a class="waves-effect waves-light btn-large col s12 " href="inputProjectData">
		      					<i class="material-icons left">add</i>Add Project
		      				</a>
				    	</div>
				    	<div class="col s12 m6">
				    		<a href="randomSequenceProject" class="waves-effect waves-light light-green darken-3 btn-large col s12">
				    			<i class="material-icons left">shuffle</i>Random Project
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
				    			<th data-priority="1">ID.</th>
				    			<th data-priority="1">ชื่อโครงการ(TH)</th>
				    			<th data-priority="1">ชื่อโครงการ(EN)</th>
				    			<th data-priority="1">คำอธิบายโปรเจค</th>
				    			<th data-priority="2">อาจารย์ที่ปรึกษา</th>
				    			<th data-priority="2">คะแนนเต็ม</th>
				    			<th data-priority="2">คะแนนที่สอบได้</th>
				    			<th data-priority="2">จำนวนคนให้คะแนน</th>
				    			<th data-priority="1">สถานะ</th>
				    			<th data-priority="3">วิชา</th>
				    			<th data-priority="3">คณะ</th>
				    			<th data-priority="3">วันที่สร้างโครงการ</th>
				    		</tr>
				    		
				    	</thead>
				    	<tbody>
				    		<s:iterator value="listProModel">
				    			<tr>
					    			<td><s:property value="project_id"/> </td>
					    			<s:url action="viewProjectDetail" var="urlLink">
					    				<s:param name='proModel.project_id'><s:property value="project_id"/></s:param>
					    			</s:url>
					    			<td><a href='<s:property value="urlLink"/>'> <s:property value="project_nameth"/></a></td>
					    			<td><s:property value="project_nameen"/></td>
					    			<td><s:property value="project_description"/></td>
					    			<td><s:property value="firstname"/></td>
					    			<td><s:property value="exam_fullscore"/></td>
					    			<td><s:property value="exam_score"/></td>
					    			<td><s:property value="personadded"/></td>
					    			<td><s:property value="project_status_name"/></td>
					    			<td><s:property value="course_nameth"/></td>
					    			<td><s:property value="faclulty_nameth"/></td>
					    			<td><s:property value="createdatetime"/></td>
					    		</tr>
				    		</s:iterator>
				    		
				    	</tbody>
				    </table>
			    </div>
			  </form>
		    </div>
		    
		    
		    
		</main>
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.responsive.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m1').addClass('active');
			 $('.m1-1').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Project');
			 $('select').material_select();
			 var table =  $('#project-table').DataTable({
			 });
			 $('#icon_search').on( 'keyup', function () {
				    table.search( this.value ).draw();
				});
		  });
		</script>
		
	</body>
</html>