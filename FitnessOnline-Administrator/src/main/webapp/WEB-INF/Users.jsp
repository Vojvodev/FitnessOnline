<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>USERS</title>
	
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
		
		.card{
			width: 24rem;
			height: 14rem;
		}
		
		a{
			text-decoration: none !important;
			font-style: italic !important;
		}
		
		.back{
			text-align: right;
			padding-bottom: 50px;
			padding-right: 30px;
		}
		
		.dashed-line {
	        border-top: 2px dashed #808080;
	        margin: 20px 90px; 
	        margin-bottom: 80px;
    	}
		
		
		
		@media screen and (max-width: 400px) {
			.card{
				width: 20rem;
				height: 10rem;
			}
		}
		
	</style>
	
</head>
		
<body>
	<%@ include file="Header.jsp" %>
	
	<div class="content"> 
			
			<div class="back">
				<a href="?action=Welcome"> &lt&ltBack To Welcome Page</a>
			</div>
			
			
			<div class="card text-white bg-primary mb-5" style=" display: inline-block;">
			  <div class="card-header">Create</div>
			  <a href="?action=NewUser" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Create A New User</h5>
		    			<p class="card-text">Every new User should be unique.</p>
		  			</div>
		  		</a>
			</div>
			
			<div class="card text-white bg-danger mb-5" style=" display: inline-block;">
			  <div class="card-header">Retrieve</div>
			  <a href="?action=AllUsers" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Get All Users</h5>
		    			<p class="card-text">Get the List of All Users.</p>
		  			</div>
		  		</a>
			</div>
			
			<br>

			<div class="card text-white bg-warning mb-5" style=" display: inline-block;">
			  <div class="card-header">Update</div>
			  <a href="?action=UpdateUser" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Update User Info</h5>
		    			<p class="card-text">Update the Information About a User.</p>
		  			</div>
		  		</a>
			</div>
			
			<div class="card text-white bg-dark mb-5" style=" display: inline-block;">
			  <div class="card-header">Delete</div>
			  <a href="?action=DeleteUser" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Delete A User</h5>
		    			<p class="card-text">Remove a User Indefinitely.</p>
		  			</div>
		  		</a>
			</div>
			
			
			<div class="dashed-line"></div>
			
			
			<div class="card text-white bg-primary mb-5" style=" display: inline-block;">
			  <div class="card-header">Create</div>
			  <a href="?action=NewTrainer" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Create A New Trainer</h5>
		    			<p class="card-text">Every new Trainer should be unique.</p>
		  			</div>
		  		</a>
			</div>
			
			<div class="card text-white bg-danger mb-5" style=" display: inline-block;">
			  <div class="card-header">Retrieve</div>
			  <a href="?action=AllTrainers" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Get All Trainers</h5>
		    			<p class="card-text">Get the List of All Trainers.</p>
		  			</div>
		  		</a>
			</div>
			
			<br>
					
			<div class="card text-white bg-warning mb-5" style=" display: inline-block;">
			  <div class="card-header">Update</div>
			  <a href="?action=UpdateTrainer" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Update Trainer Info</h5>
		    			<p class="card-text">Update the Information About a Trainer.</p>
		  			</div>
		  		</a>
			</div>
			
			<div class="card text-white bg-dark mb-5" style=" display: inline-block;">
			  <div class="card-header">Delete</div>
			  <a href="?action=DeleteTrainer" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Delete A Trainer</h5>
		    			<p class="card-text">Remove a Trainer Indefinitely.</p>
		  			</div>
		  		</a>
			</div>
			
			<br>
			
			<h3 style="padding-top: 50px; padding-bottom: 20px;"> <%= session.getAttribute("notification") %> </h3>
	</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>









