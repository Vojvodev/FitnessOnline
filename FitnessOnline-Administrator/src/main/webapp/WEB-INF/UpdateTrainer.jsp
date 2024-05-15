<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>UPDATE</title>
	
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
		
		.signup-input{
		    width: 65% !important; 
		    margin-left: 20vw;
		}
		
		.title{
			color: #059;
			font-size: 60px;
			padding-bottom: 40px;
		}
		
		.big-button{
		    width: 100px;
		    margin-top: 20px;
		    margin-bottom: 50px;
		}
		
		
		
	</style>
	
</head>

<body>
	<%@ include file="Header.jsp" %>
		
		<div class="content">
			
			<div class="back">
				<a href="?action=Users"> &lt&ltBack To Users</a>
			</div>
			
			<div class="title"> Update A Trainer </div> 
			
			
			<form action="?action=SendTrainerUpdate" method="POST" class="my-form">
				
				<div class="mb-3">
		            <label for="id" class="form-label">Trainer's ID</label>
		            <input type="number" name="id" class="form-control signup-input" id="id" required>
		        </div>
				
		        <div class="mb-3">
		            <label for="fname" class="form-label">Edit First Name</label>
		            <input type="text" name="fname" class="form-control signup-input" id="fname" required>
		        </div>
		
		        <div class="mb-3">
		            <label for="lname" class="form-label">Edit Last Name</label>
		            <input type="text" name="lname" class="form-control signup-input" id="lname" required>
		        </div>
		        
		        <div class="mb-3">
		            <label for="email" class="form-label">Edit Email</label>
		            <input type="email" name="email" class="form-control signup-input" id="email" email required>
		        </div>
		        
		        <div class="mb-3">
		            <label for="password" class="form-label">Create A New Password</label>
		            <input type="password" name="password" class="form-control signup-input" id="password" required>
		        </div>
		       
		        
		        <button type="submit" class="btn btn-primary big-button">Update</button>
		        
		        <h3 style="padding-top: 50px; padding-bottom: 20px;"> <%= session.getAttribute("notification") %> </h3>
		
	      </form>
			
		</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>