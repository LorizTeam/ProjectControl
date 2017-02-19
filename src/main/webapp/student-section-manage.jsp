<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Student Detail</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/select2.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
	</head>
	<body>
		<%@include file="menu.jsp" %>
		<main>
        	<div class="nav-wrapper bread">
		      <div class="col s12 light-blue darken-1" style="padding-left:10px;">
		        <a href="Dashboard" class="breadcrumb">Dash board</a>
		        <s:url action="viewStudentDetail" var="viewDetail" >
	   				<s:param name="stdModel.student_id"><s:property value="stdModel.student_id"/></s:param>
	   			</s:url>
		        <a href='<s:property value="viewDetail"/>' class="breadcrumb">Student Detail</a>
		        <a href="#!" class="breadcrumb">Student Manage Section</a>
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
				<form class="container" method="post" action="addStudentSection">
				<h4 class="center-align light-blue-text text-darken-1">Student Detail</h4>
				
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Add Section</h5>
					<div class="row">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s12">
									<s:hidden name="stdModel.branchId"/>
									<s:textfield name="stdModel.student_id" id="studentId" class="validate ip" readonly="true"/>
									<label>รหัสนักศึกษา</label>
								</div>
								<div class="col s12">
						        	<p style="margin-bottom: 0; color:#26a69a !important;">Course</p>
									<s:select style="width: 100%" list="mapCourse" name="stdModel.course_id" id="course_id"></s:select>
								</div>
								<div class="col s12">
						        	<p style="margin-bottom: 0; color:#26a69a !important;">Section</p>
						        	<select style="width: 100%" id="ddlSection" name="stdModel.sectionId">
										<option  value="">Select an option</option>
									</select>
								 </div>
								
							</div>
						</div>
					</div>
				</div>
				<div class="center-align">
					<button id="save" type="submit" class="modal-action modal-close waves-effect waves-green green btn " value="0">Add Section</button>
				</div>
				<div class="card " style="padding:10px;">
					<h5 class="cyan-text text-darken-1">Section</h5>
					    <table id="sectionTable" class="highlight  responsive" >
					    	<thead>
					    		<tr>
					    			<th data-priority="1">เซคชั่น</th>
					    			<th data-priority="1">ปี</th>
					    			<th data-priority="1">จัดการ</th>
					    		</tr>
					    		
					    	</thead>
					    	<tbody>
					    		<s:iterator value="listStudentSection">
					    			<tr>
						    			<td><s:property value="sectionName"/></td>
						    			<td><s:property value="year"/></td>
						    			<s:url action="deleteStudentSection" var="linkDelete" escapeAmp="false">
							 				<s:param name="stdModel.student_id"><s:property value="stdModel.student_id"/></s:param>
							 				<s:param name="stdModel.branchId"><s:property value="stdModel.branchId"/></s:param>
							 				<s:param name="stdModel.studentSectionId"><s:property value="studentSectionId"/></s:param>
							 			</s:url>
						    			<td><a href='<s:property value="linkDelete"/>' ><i class="material-icons">delete</i></a></td>
						    		</tr>
					    		</s:iterator>
					    	</tbody>
					    </table>
					</div>
				 </form>
			</div>
				 
		</main>
	    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	    <script type="text/javascript" src="js/sweetalert2.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('Student Detail');
			 $('#course_id').select2();
			 var table =  $('#sectionTable').DataTable();
			 $('#save').click(function(e){
				if($('#ddlSection').val() == ''){
					e.preventDefault();
					swal(
					  'ไม่สามารถเพิ่มข้อมูล Section',
					  'กรุณาเลือกข้อมูล Section',
					  'warning'
					)
				}
			 });
				 
			 $('#course_id').change(function(){
				$('#ddlSection').val("").trigger("change");
			 });
			 
			 $("#ddlSection").select2({
				ajax: {
				    url: "ajax/getStudentSection.jsp",
				    delay: 1000,
				    data: function (params) {
				      return {
				        q: params.term, // search term
				        courseId:$('#course_id').val(),
				        studentId:$('#studentId').val(),
				      };
				    },
				    processResults: function (data, params) {
				      // parse the results into the format expected by Select2
				      // since we are using custom formatting functions we do not need to
				      // alter the remote JSON data, except to indicate that infinite
				      // scrolling can be used
				      params.page = params.page || 1;

				      return {
				        results: data.results,
				        pagination: {
				          more: (params.page * 30) < data.total_count
				        }
				      };
				    },
				    cache: true
			  	}
	  		});
			 
		});
		</script>
		
	</body>
</html>