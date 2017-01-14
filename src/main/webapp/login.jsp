<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Controller : Login</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	<div class="container">
	
       	<div class="row">
	        <ul id="frm-login" class="col s12  offset-m3 m6 frm-login">
	        	<li>
	        	
		          <div  class="card blue-grey darken-1">
		          	
		            <div class="card-content white-text center-align">
		            <s:if test="alertStatus != null ">
		            	<div id="alertMessage" class='card-panel lighten-3 text-darken-4 <s:property value="alertStatus"/> '> 
		            		<s:property value="alertMessage"/>
		            	</div>
					</s:if>
	            	<div class="card-image">
		              <img class="materialboxed" src="img/pnru.png">
		            </div>
		              <p>Project Control</p>
		              <form class="row" method="post" action="Login">
			              <div class="input-field col s12 left-align">
					          <input id="Username" name="username" type="text" class="validate" required />
					          <label for="Username">User name</label>
					      </div>
					      <div class="input-field col s12 left-align">
					          <input id="password" name="password" type="password" class="validate" required/>
					          <label for="password">password</label>
					      </div>
					      <div class=" col s12 center-align ">
				              <button type="submit" class="waves-effect  col s12 waves-light btn-large">Login</button>
				           </div>
				      </form>
		            </div>
		            
		          </div>
		          
	          	</li>
	        </ul>
	      </div>
	</div>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 
			    Materialize.showStaggeredListSlideDown('#frm-login');
			    
			    $('#alertMessage').delay(3500).fadeOut('slow');
		  });
		</script>
	</body>
</html>