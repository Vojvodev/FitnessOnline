<%@page import="etf.ip.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ALL</title>
	
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
		
		@media screen and (max-width: 800px) {
            .table {
                overflow-x: auto;
                display: block;
                max-width: 100%;
                white-space: nowrap;
            }
            .table thead{
            	display: none;
            }
            .table tbody,
            .table tr,
            .table th,
            .table td {
                display: block;
                max-width: 345px;
            }
            .table tr {
                border-bottom: 1px solid #ddd;
            }
            .table td,
            .table th {
                border: none;
                text-align: left;
                padding: 8px;
                white-space: normal;
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
			
			<table class="table">
			  <thead>
			  	<tr>
			      <th scope="col">#</th>
			      <th scope="col">FName</th>
			      <th scope="col">LName</th>
			      <th scope="col">Uname</th>
			      <th scope="col">Email</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			      
			      <%
			      	int index = 1;
			      	ArrayList<User> users = (ArrayList<User>)session.getAttribute("users");
			      	for(User usr : users){
			      %>
			      		<tr>
					      <th scope="row"> <%= index++ %> </th>
					      <td> <%= usr.getFname() %> </td>
					      <td> <%= usr.getLname() %> </td>
					      <td> <%= usr.getUsername() %> </td>
					      <td> <%= usr.getEmail() %> </td>
					    </tr>
				  <%
			      	}
				  %>
		
			   </tbody>
			  </table>
			
		</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>