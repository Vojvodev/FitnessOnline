<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>NEW</title>
	
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
			padding-bottom: 20px;
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
		
	</style>
	
</head>

<body>
	<%@ include file="Header.jsp" %>
		
		<div class="content">
		
			<div class="back">
				<a href="?action=Categories"> &lt&ltBack To Categories</a>
			</div>
		
			<div class="title"> Create A New Category </div> 
		
			<form action="?action=CreateCategory" method="POST" class="my-form">
				<div class="mb-3">
					<label for="name" class="form-label">Name</label>
					<input type="text" class="form-control login-input"	name="name" id="name" required>
				</div>
				
				<div class="mb-3">
					<label for="image"  class="form-label">Image</label>
					<input type="text" class="form-control login-input" name="image" id="image" required>
				</div>
				
				<div class="mb-3">
					<input type="submit" name="submit" value="Create"  class="btn btn-primary"> 
				</div>
				
				<h3 style="padding-top: 50px;"> <%= session.getAttribute("notification") %> </h3>
			</form>
		
		</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>