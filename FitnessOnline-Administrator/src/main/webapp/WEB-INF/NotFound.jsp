<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
		
		<style>
			.not-found{
			    margin: 0;
			    color: #059;
			    text-align: center;
			    font-style: italic;
			    font-family: "Anton";
			    -webkit-text-stroke: 2%;
			    font-size: 10vw;
			    padding-top: 10%;
			    padding-bottom: 10%;
			}
			
			.content{
				min-height: 500px;
				padding-top: 40px;
				padding-left: 2%;
				padding-right: 2%;
				text-align: center;
			}
			
			@media screen and (max-width: 900px){
			    .not-found{
			        padding-bottom: 130%;
			    }
			}
			
		</style>
		
	</head>
	
	<body>
		<%@ include file="Header.jsp" %>
		
		<div class="content">
			<div class="container-xs fit" style="width: 100% !important;">
   
			    <div class="not-found">
			        <p>Page not found</p>
			    </div>
			</div>	
		</div>
		
		
		<%@ include file="Footer.jsp" %>
	</body>
</html>