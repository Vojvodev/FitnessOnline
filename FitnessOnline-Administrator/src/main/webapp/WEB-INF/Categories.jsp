<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CATEGORIES</title>
	
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
			  <a href="?action=NewCategory" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Create A New Category</h5>
		    			<p class="card-text">A Workout Category should be unique.</p>
		  			</div>
		  		</a>
			</div>
			
			
			<div class="card text-white bg-danger mb-5" style=" display: inline-block;">
			  <div class="card-header">Retrieve</div>
			  <a href="?action=AllCategories" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Get All Categories</h5>
		    			<p class="card-text">Get the list of All Categories.</p>
		  			</div>
		  		</a>
			</div>

			<br>

			<div class="card text-white bg-warning mb-5" style=" display: inline-block;">
			  <div class="card-header">Update</div>
			  <a href="?action=UpdateCategory" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Update Category Info</h5>
		    			<p class="card-text">Update the information about a category.</p>
		  			</div>
		  		</a>
			</div>
			
			<div class="card text-white bg-dark mb-5" style=" display: inline-block;">
			  <div class="card-header">Delete</div>
			  <a href="?action=DeleteCategory" style="color: white !important;">
		  			<div class="card-body">
		    			<h5 class="card-title">Delete A Category</h5>
		    			<p class="card-text">Remove a Category Indefinitely.</p>
		  			</div>
		  		</a>
			</div>
			
			<br>
			
			<h3 style="padding-top: 50px; padding-bottom: 20px;"> <%= session.getAttribute("notification") %> </h3>
	</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>









