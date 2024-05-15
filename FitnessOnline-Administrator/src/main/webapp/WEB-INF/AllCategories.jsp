<%@page import="etf.ip.dto.Category"%>
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
				<a href="?action=Categories"> &lt&ltBack To Categories</a>
			</div>
			
			<table class="table">
			  <thead>
			  	<tr>
			      <th scope="col">#</th>
			      <th scope="col">Name</th>
			      <th scope="col">Image</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  
			      <%
			      	int index = 1;
			      	ArrayList<Category> categories = (ArrayList<Category>)session.getAttribute("categories");
			      	for(Category cat : categories){
			      %>
			      		<tr>
					      <th scope="row"> <%= index++ %> </th>
					      <td> <%= cat.getName() %> </td>
					      <td> <%= cat.getImage() %> </td>
					    </tr>
				  <%
			      	}
				  %>
				  
			   </tbody>
			  </table>
			
			<br><br>
			
		</div>
		
	<%@ include file="Footer.jsp" %>
</body>
</html>