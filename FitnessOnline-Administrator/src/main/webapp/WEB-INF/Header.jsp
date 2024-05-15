<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="etf.ip.beans.AdministratorBean" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Header Title</title>
		
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<!-- <link href="../css/header.css" rel="stylesheet"> --> 
	  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
	  	
	  	<style type="text/css">
	  		.welcome-title {
			    text-align: center;
			    line-height: 50px;
			    background-color: #059;
			    height: 50px;
			    padding-left: 20%;
			    width:100%;
			}
			.line{
				color: white;
				text-align: center;
				font-style: italic;
				font-family: "Anton";
				-webkit-text-stroke: 2%;
				font-size: 4vw;
				display:inline;
			}
			
			.logout{
				display:inline;
				margin-left: 15%;
			}
			
			.logout-link{
				display:inline;
				color: white !important;
				text-decoration: none;
				font-style: italic;
				font-size: 12px;
				text-align: right;
				vertical-align: middle;
			}
			
	  	</style>
	  	
	</head>

	<body>
		<nav class="welcome-title">
			<div class="line">
				Fitness Online - Administrator App
			</div>
			
			<div class="logout">
				<%
					AdministratorBean adminBean1 = (AdministratorBean)session.getAttribute("adminBean");
					if(adminBean1 != null && adminBean1.isLoggedIn()){ 
				%> 
						<a class="logout-link" href="?action=Logout">LOG OUT
							<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-person-bounding-box" viewBox="0 0 16 16">
							  <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5M.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5m15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5"/>
							  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
							</svg>
						</a>
				<% } %>
			</div>
			
			
		</nav>
	</body>

</html>