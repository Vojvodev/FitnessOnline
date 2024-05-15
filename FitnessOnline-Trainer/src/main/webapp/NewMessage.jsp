<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="etf.ip.model.MessageBean" %>
<%@page import="etf.ip.database.LogDatabase"%>

<jsp:useBean id="messageService"	class="etf.ip.service.MessageService"	scope="application" />
<jsp:useBean id="trainer"        	class="etf.ip.model.TrainerBean"       	scope="session" 	/>
<jsp:useBean id="msg"        		class="etf.ip.model.MessageBean"		scope="request" 	/>

<jsp:setProperty name="msg" property="sendersId" 	param="sendersId" />
<jsp:setProperty name="msg" property="content" 	 	param="content" />


<% if(trainer == null || !trainer.isLoggedIn()) {response.sendRedirect("Login.jsp");} %>

<!DOCTYPE html>
<%
	if(request.getParameter("submit") != null){
		messageService.sendEmail(trainer.getEmail(), msg.getContent(), msg.getSendersId());
		
		String currentTrainer = trainer.getEmail();
		String action = "Sent a response to id:" + msg.getSendersId();
		LogDatabase.insertLog(currentTrainer, action);
		
		response.sendRedirect("Messages.jsp");
	}
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>CREATE A MESSAGE</title>
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">


		<style>
			.content{
				min-height: 500px;
				padding-left: 5%;
				padding-right: 5%;
				padding-top: 5%;
			}
			
			.txt1{
				text-align: center;
				font-family: "Anton";
				-webkit-text-stroke: 2%;
				font-size: 4vw;
			}
			
			
			@media screen and (max-width: 400px) {
				.content{
					min-height: 600px;
				}
			}	
			
		</style>

	</head>

	<body>
		<jsp:include page="WEB-INF/Header.jsp" />
		
		<div class="content">
			
			<div style="text-align: right;">
				<a href="Messages.jsp" style="text-decoration:none; font-style: italic;"> &lt&ltBack To Messages</a>
			</div>
			
			<div class="txt1">
				Create A New Message
			</div>
			
			
		    <form action="NewMessage.jsp" method="post">
		    	<div class="mb-3" style="text-align: center;">
		        	<label for="sendersId" class="form-label" style="font-weight: 900;">For</label>
		        	<input type="number"   class="form-control" name="sendersId" style="width: 90px; display:inline;">
		        </div>
		        
		        <div class="mb-3">
		        	<label for="sendersId" class="form-label">Content</label>
		        	<textarea rows="3"  class="form-control" name="content"> </textarea>
		        </div>
		        
		        <div class="mb-3" style="text-align: center; padding-top: 50px;">
		        	<input type="submit" class="btn btn-primary" name="submit" id="submit" value="Send">
		        </div>
		    </form>
		    
		</div>
		
	    <jsp:include page="WEB-INF/Footer.jsp" />
	</body>
</html>