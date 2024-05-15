<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<jsp:useBean id="adminBean" class="etf.ip.beans.AdministratorBean" scope="session"/>



<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>WELCOME</title>
			
			<meta name="viewport" content="width=device-width, initial-scale=1">
		  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
			
			
			<style type="text/css">
				.content{
					min-height: 500px;
					padding-top: 60px;
					padding-left: 5%;
					padding-right: 5%
				}
			
				.card a{
					text-decoration: none;
				}
				
				.card-title{
					font-weight: 900;
					text-align: center;
				}
				
				.card-text{
					min-height: 150px;
					text-align: center;
					padding-top: 40px;
				}
				
				
				
			</style>
			
			
		</head>
		
		
		
		<body>
			<%@ include file="Header.jsp" %>
			
			<div class="content">
				
				Welcome: <h3 style="display: inline;"><%= adminBean.getAdministrator().getFirstName() %> <%= adminBean.getAdministrator().getLastName() %></h3>  
			
				<div class="card-group" style="padding-top: 50px;">
				  <div class="card">
				  	<a href="?action=Categories">
					    <div class="card-body">
					      <h5 class="card-title">Manage Categories</h5>
					      <p class="card-text"><small class="text-muted"> CRUD Operations Including Categories	</small></p>
					    </div>				  	
				  	</a>
				  </div>
				  
				  <div class="card">
				  	<a href="?action=Users">
					    <div class="card-body">
					      <h5 class="card-title">Manage Users And Trainers</h5>
					      <p class="card-text"><small class="text-muted">CRUD Operations Including Users</small></p>
					    </div>
				    </a>
				  </div>
				  
				  <div class="card">
					    <a href="?action=Statistics">
						    <div class="card-body">
						      <h5 class="card-title">Statistics</h5>
						      <p class="card-text"><small class="text-muted">Check out Statistics Overview</small></p>
						    </div>
						</a>
					</div>
				</div>
			</div>
			
			
			<%@ include file="Footer.jsp" %>
		</body>
	</html>