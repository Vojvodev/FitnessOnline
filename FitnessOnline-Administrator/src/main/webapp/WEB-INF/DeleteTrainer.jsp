<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>DELETE</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
	
	<style>
		.content{
				min-height: 500px;
				padding-top: 40px;
				padding-left: 2%;
				padding-right: 2%;
				text-align: center;
			}
			
		.back{
			text-align: right;
			padding-bottom: 50px;
			padding-right: 30px;
		}
		
		a{
			text-decoration: none !important;
			font-style: italic !important;
		}
		
		.my-form{
			text-align: center;
		}
		
		.login-input{
		    width: 65% !important; 
		    margin-left: 20vw;
		}
		
		.title{
			color: #059;
			font-size: 60px;
			padding-bottom: 40px;
		}
		
		
		@media screen and (max-width: 600px){
			.content{
				min-height: 600px;
			}
		}
		
	</style>
	
</head>

<body>
	<%@ include file="Header.jsp" %>
		
		<div class="content">
			<div class="back">
				<a href="?action=Users"> &lt&ltBack To Users</a>
			</div>
			
			<div class="title"> Delete A Trainer </div> 
			
			<form action="?action=SendTrainerDelete" method="POST" class="my-form">
				
				<div class="mb-3">
					<label for="id" class="form-label">Trainer ID</label>
					<input type="number" class="form-control login-input" name="id" id="id">
				</div>
				
				<div class="mb-3">
					<input type="submit" name="submit" value="Delete"  class="btn btn-primary" required> 
				</div>
				
				<h3 style="padding-top: 50px; padding-bottom: 20px;"> <%= session.getAttribute("notification") %> </h3>
				
			</form>
			
		</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>