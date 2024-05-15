<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>






<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MESSAGE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">

		<style>
			.content{
				min-height: 450px;
				padding-left: 5%;
				padding-right: 5%
			}
			
			.header{
				text-align: center;
				width: 100%;
			}

			@media screen and (max-width: 590px) {
				.content{
					min-height: 600px;
				}
			}
		</style>	
		
	</head>



<body>
	<%@ include file="WEB-INF/Header.jsp" %>

	<div class="content">
		<div style="text-align: right; padding-top: 20px; padding-bottom: 40px;">
			<a href="Messages.jsp" style="text-decoration:none; font-style: italic;"> &lt&ltBack To Messages</a>
		</div>

		<table class="table">
			<thead>
			  <tr>
				<th class="header"> User ID: <%= request.getParameter("sendersId") %> </th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td> 
					<div style="text-align:center;"> Message id: <%=request.getParameter("messageId") %> </div> 
				 	<div style="min-height: 200px;"> <%= request.getParameter("content") %> </div>  
				</td>
			</tbody>
		  </table>

		<div class="mb-3" style="text-align: center; padding-top: 50px;">
			<button class="btn btn-primary" name="replyButton" id="replyButton"> Reply </button>
		</div>
	</div>
	
	<%@ include file="WEB-INF/Footer.jsp" %>

	<script>
		document.getElementById("replyButton").addEventListener("click", function() {
			window.location.href = "NewMessage.jsp";
		});
	</script>

</body>
</html>