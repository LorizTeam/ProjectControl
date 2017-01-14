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
		    	<s:if test="alertStatus != null ">
		    		<div class="row" >
		    			<div class="col s12 m12">
			            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
			            		<s:property value="alertMessage"/>
			            	</div>
		            	</div>
		    		</div>
				</s:if>
				<div class="row" >
					<div class="col s12 m6">
						<a class="waves-effect waves-light btn-large col s12 " href="getAllFile">
						<i class="material-icons left">clear_all</i>File List
						</a>
					</div>
					<div class="col s12 m6">
						<a class="waves-effect waves-light light-green darken-3  btn-large col s12 " href="inputFile">
						<i class="material-icons left">add</i>Add File
					</a>
					</div>
				</div>
				<div class="card" style="padding:10px;">
				<h5 class="cyan-text text-darken-1">Add Group</h5>
				<form action="addFile" method="post"  enctype="multipart/form-data">
			    	<div class="row">
						<div class="file-field input-field col s12 m6">
					      <div class="btn">
					        <span>File</span>
					        <s:file type="file" name="fileUpload"/>
					      </div>
					      <div class="file-path-wrapper">
					        <input class="file-path validate" type="text" placeholder="Upload one or more files">
					      </div>
					    </div>
					    <div class="input-field col s12 m6">
							<s:select list="mapFileGroup" name="fileModel.fileGroupId"></s:select>
							<label>กลุ่มไฟล์</label>
						</div>
						<div class="input-field col s12 m6">
							<s:textfield name="fileModel.fileNameTh" required="true" />
							<label>ชื่อไฟล์ภาษาไทย</label>
						</div>
						<div class="input-field col s12 m6">
							<s:textfield name="fileModel.fileNameEn" required="true" />
							<label>ชื่อไฟล์ภาษาอังกฤษ</label>
						</div>
						
						<div class="col s12 center-align">
							<button type="submit" name="add" class="waves-effect waves-light light-green darken-3 btn center-align" ><i class="fa fa-plus left"></i> เพิ่มกลุ่มเก็บไฟล์</button>
						</div>
					</div>
				</form>
			    </div>
			    <div class="card" style="padding:10px;">
			    	<div class="row">
						<div class="input-field col s12 m4 offset-m8">
							<i class="material-icons prefix right">search</i>
					        <input type="text" id="icon_search" class="validate"/>
					        <label for="icon_search">Search</label>
						</div>
					</div>
				    <table id="project-table" class="highlight  responsive" >
				    	<thead>
				    		<tr>
				    			<th data-priority="1">File</th>
				    			<th data-priority="1">ชื่อไฟล์ไทย</th>
				    			<th data-priority="1">ชื่อไฟล์อังกฤษ</th>
				    			<th data-priority="1">ประเภทไฟล์</th>
				    			<th data-priority="1">วันที่อัพโหลด</th>
				    			<th data-priority="1">กลุ่มไฟล์</th>
				    			<th data-priority="1">ลบข้อมูล</th>
				    		</tr>
				    		
				    	</thead>
				    	<tbody>
				    		<s:iterator value="listFileModel">
				    			<tr>
					    			<td><a href="<s:property value="filePath"/>" target="_blank" class="waves-effect waves-light light-green darken-3 btn center-align"><i class="fa fa-download"></i> </a> </td>
					    			<td><s:property value="fileNameTh"/></td>
					    			<td><s:property value="fileNameEn"/></td>
					    			<td><s:property value="contentType"/></td>
					    			<td><s:property value="addedDateTime"/></td>
					    			<td><s:property value="fileGroupNameTh"/></td>
					    			<td>
					    			<s:url action="deleteFile" var="delFile" >
					    				<s:param name="fileModel.fileId"><s:property value="fileId"/></s:param>
					    			</s:url>
					    			<a href='<s:property value="delFile"/>' ><i class="material-icons">delete</i></a>
					    			</td>
					    		</tr>
				    		</s:iterator>
				    	</tbody>
				    </table>
			    </div>
		    </div>
		</main>
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.responsive.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $('.m4').addClass('active');
			 $('.m4-2').addClass('active');
			 $('.collapsible').collapsible();
			 $('.page-title').text('File');
			 $('select').material_select();
		  });
		 
		</script>
		
	</body>
</html>