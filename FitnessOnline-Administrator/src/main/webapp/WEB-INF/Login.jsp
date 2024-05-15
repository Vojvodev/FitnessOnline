<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>LOGIN</title>
  	
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">

	<style>
		.content{
			min-height: 500px;
			padding-top: 60px;
		}
		
		.title{
			text-align: center; 
			padding-top: 20px;
			padding-bottom: 20px;
		}
		
		.my-form{
			text-align: center;
		}
		
		.login-input{
		    width: 65% !important; 
		    margin-left: 20vw;
		}
		
		@media screen and (max-width: 400px) {
			.content{
				min-height: 600px;
			}
		}
		
	</style>

</head>
<body>
	<%@ include file="Header.jsp" %>
	
	<div class="content">
		<h2 class="title" style=""> Log In As An Administrator </h2> 
	
		<form action="?action=Login" method="POST" class="my-form">
			<div class="mb-3">
				<label for="username" class="form-label">Username</label>
				<input type="text" class="form-control login-input"	name="username" id="username">
			</div>
			
			<div class="mb-3">
				<label for="password"  class="form-label">Password</label>
				<input type="password" class="form-control login-input" name="password" id="password">
			</div>
			
			<div class="mb-3">
				<input type="submit" name="submit" value="Log In"  class="btn btn-primary"> 
			</div>
			
			<h3 style="padding-top: 50px;"> <% if(session.getAttribute("notification") != null){out.println(session.getAttribute("notification"));} %> </h3>
		</form>
		<br><br>
	</div>
	
	<%@ include file="Footer.jsp" %>
</body>
</html>