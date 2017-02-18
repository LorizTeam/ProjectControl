<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Course Detail</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <a href="#!" class="breadcrumb">Course Detail</a>
		      </div>
		    </div>
		    <div class="div-container ">
				<form class="container" action="updateCourse" method="post">
				<s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
				<h4 class="center-align light-blue-text text-darken-1">Course Detail</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Course Details</h5>
					
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col 12 m6">
									<s:select list="mapBraModel" class="validate ip" name="couModel.branchId" readonly="true" value="couModel.branchId" ></s:select>
									<label>Branch</label>
								</div>
								<div class="input-field col s12 m6">
									<s:hidden name="couModel.id" />
									<s:textfield id="code" type="text" class="validate ip" readonly="true" name="couModel.code"/>
									<label for="code">Course Code</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameth" type="text" class="validate ip" readonly="true" name="couModel.nameth"/>
									<label for="nameth">Course Name (TH)</label>
								</div>
								<div class="input-field col s12 m6">
									<s:textfield id="nameen" type="text" class="validate ip" readonly="true" name="couModel.nameen"/>
									<label for="nameen">Course Name(EN)</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="center-align">
					<button value="0" type="button" id="btn-e" class="modal-action modal-close waves-effect waves-orange  orange btn ">Edit</button>
			    	<s:url action="deleteCourse" var="delLink">
						<s:param name="couModel.id"><s:property value="couModel.id"/></s:param>
					</s:url>
					<a href='<s:property value="delLink"/>' class="waves-effect waves-red  red btn ">Delete</a>
			    	<a href="viewAllCourse" class="modal-action modal-close waves-effect waves-light grey lighten-1 btn ">Close</a>
				</div>
		    </form>
		    <form class="container" action="addSection" method="post">
				<s:hidden name="couModel.id" />
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Section </h5>
					<div class="row">
						<div class="input-field col s12 m6">
							<s:textfield id="sectionName" type="text"  class="validate ip" name="secModel.sectionName"/>
							<label for="sectionName">Section Name</label>
						</div>
						<div class="input-field col s12 m6">
							<s:textfield id="sectionYear" type="text"  class="validate ip" name="secModel.sectionYear"/>
							<label for="sectionYear">Section Year</label>
						</div>
					</div>
					<div class="center-align">
				      	<button type="submit" class="modal-action modal-close waves-effect waves-green btn ">Add Section</button>
			      	</div>
			      	
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Section List</h5>
					<div class="row">
						<table id="sectionTable" class="highlight  responsive" >
					    	<thead>
					    		<tr>
					    			<th data-priority="1">เซคชั่น</th>
					    			<th data-priority="1">ปี</th>
					    			<th data-priority="1">จัดการ</th>
					    		</tr>
					    		
					    	</thead>
					    	<tbody>
					    		<s:iterator value="listSectionModel">
					    			<tr>
						    			<td><s:property value="sectionName"/></td>
						    			<td><s:property value="sectionYear"/></td>
						    			<s:url action="deleteSection" var="urlLink" escapeAmp="false">
					    				<s:param name="couModel.id"><s:property value="couModel.id" /></s:param>
					    				<s:param name="secModel.sectionId"><s:property value="sectionId" /></s:param>
					    				</s:url>
						    			<td><a href='<s:property value="urlLink"/>' ><i class="material-icons">delete</i></a></td>
						    		</tr>
					    		</s:iterator>
					    	</tbody>
					    </table>
					</div>
				</div>
		    </form>
		  </div>  
		    
		</main>
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m6').addClass('active');
			 $('.m6-3').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Course Detail');
			 $('#sectionTable').DataTable();
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