<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>

<%@ page import="etf.ip.model.TrainerBean" %>
<%@ page import="etf.ip.model.MessageBean" %>

<jsp:useBean id="messageService"	class="etf.ip.service.MessageService"	scope="application" />
<jsp:useBean id="trainer" 		 	class="etf.ip.model.TrainerBean" 		scope="session"/>


<% if(trainer == null || !trainer.isLoggedIn()) {response.sendRedirect("Login.jsp");} %>


<% 
	ArrayList<MessageBean> messages = new ArrayList<MessageBean>();
	messages = messageService.getMessagesByEmail(trainer.getEmail());	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MESSAGES</title>
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">

		<style>
			.content{
				min-height: 500px;
				padding-left: 5%;
				padding-right: 5%
			}
			
			.link{
				text-decoration: none; 
				font-style: italic; 
				color: #059;
			}
			
			.new-message{
				text-align:center;
			}

			.truncate {
			  max-width: 250px; 
			  white-space: nowrap;
			  overflow: hidden;
			  text-overflow: ellipsis;
			}
			
			.submit-field{
				background-color: white;
				color: #059;	
				border-style: none;
			}
			


			@media screen and (max-width: 800px) {
			.logout{
					width: 25vw !important;
			}
			.content{
				min-height: 600px;
			}
			
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
		<%@ include file="WEB-INF/Header.jsp" %>
		
		<div class="content">
			<br>
			Welcome: <h3 style="display: inline;"><%= trainer.getFname() %> <%= trainer.getLname() %></h3>  


			<div class="container" style="padding-top: 150px; text-align:center;">
				<div class="row">
					<div class="col-md-6">
						<div class="new-message">
							<a class="link" href="NewMessage.jsp">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
									  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
								</svg>
								Write A New Message
							</a>
						</div>
					</div>
					
					<div class="col-md-6">
						<form class="d-flex">
						      <input class="form-control me-2" type="search" name="search" id="search" placeholder="Search" aria-label="Search">
						      <button type="submit" onclick="searchMessages()" class="search" name="submitSearch">
						      	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
								</svg>
						      </button>
						</form>
					</div>
				</div>
			</div>
			
			
			<table class="table" style="margin-top: 50px; margin-bottom: 50px;">
				<thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Sender ID</th>
				      <th scope="col">Content</th>
				      <th scope="col">Created At</th>
					  <th scope="col">Mark As Read</th>
				    </tr>
				</thead>
				
				<tbody>
				
					<% 
						int index = 1;
						for(MessageBean message : messages){  
					%>
							<tr>
								<th scope="row"> 		<%= index++ %> 						</th>
							    <td> 					<%= message.getSendersId() %> 		</td>
							    
								<td class="truncate"> 
							    	<form action="InboxMessage.jsp" method="post">
										<input type="hidden" name="sendersId" value='<%= message.getSendersId() %>'>
										<input type="hidden" name="content" value='<%= message.getContent() %>'>
										<input type="hidden" name="messageId" value='<%= message.getId() %>'>
										
										<input type="submit" name="submit" class="submit-field truncate" value='<%= message.getContent() %>' >
									</form>	
								</td> 
	
	
														
							    <td> 					<%= message.getCreatedAt() %>	 	</td>
				    	        <td> <input type="checkbox" name="checkbox" id="checkboxId_<%= index %>"
				    	        		onclick="checkboxClicked('checkboxId_<%= index %>', '<%= message.getId() %>')" > </td>
				    	     </tr>
			    	<% 	} %>
				</tbody>
			</table>
			
			<br><br>
			
		</div>
		
		
		
		<%@ include file="WEB-INF/Footer.jsp" %>
		
		
		<script>
			function searchMessages(){
				event.preventDefault();
				
				word = document.getElementById('search').value;
				
				fetch("seen-status?search=" +  word, {
	                method: "GET"
	            })
	            .then(response => {
	                if (!response.ok) {
	                    throw new Error("Network response was not ok");
	                }
	                return response.json(); // Assuming the response is JSON
	            })
	            .then(data => {
	            	messages = data;
	                console.log(messages);
	            	
	                // Update page table
	                updateTableWithMessages(messages);
	                
	                
	            })
	            .catch(error => {
	                console.error("There was a problem with the fetch operation:", error);
	            });
			}
		
			
			// private help function
			function updateTableWithMessages(messages) {
			    var tableBody = document.querySelector('tbody');

			    tableBody.innerHTML = '';

			    messages.forEach(function(message, index) {
			        var row = '<tr>' +
			                      '<th scope="row">' + (index + 1) + '</th>' +
			                      '<td>' + message.sendersId + '</td>' +
			                      '<td class="truncate">' +
			                          '<form action="InboxMessage.jsp" method="post">' +
			                              '<input type="hidden" name="sendersId" value="' + message.sendersId + '">' +
			                              '<input type="hidden" name="content" value="' + message.content + '">' +
			                              '<input type="hidden" name="messageId" value="' + message.id + '">' +
			                              '<input type="submit" name="submit" class="submit-field truncate" value="' + message.content + '">' +
			                          '</form>' +
			                      '</td>' +
			                      '<td>' + message.createdAt + '</td>' +
			                      '<td><input type="checkbox" name="checkbox" id="checkboxId_' + index + '" onclick="checkboxClicked(\'checkboxId_' + index + '\', \'' + message.id + '\')" ></td>' +
			                  '</tr>';
			        tableBody.insertAdjacentHTML('beforeend', row);
			    });
			}
			
			
			
			function checkboxClicked(checkboxId, messageId) {
		        var checkbox = document.getElementById(checkboxId);
		        var isChecked = checkbox.checked;
		        
		        console.log(messageId);
		        console.log(isChecked);
		        
		        var data = {
		                messageId: messageId,
		                isChecked: isChecked
		            };
		        
		        fetch("seen-status", {
		        	method: "POST",
		        	headers: {
		                "Content-Type": "application/json"
		            },
		        	body: JSON.stringify(data)
		        })
		        .then(response => {
		            if (!response.ok) {
		                throw new Error("Network response was not ok");
		            }
		            return response.text(); 
		        })
		        .then(data => {
		            console.log("Response from server:", data);
		        })
		        .catch(error => {
		            console.error("There was a problem with the fetch operation:", error);
		        });
		    }
			
			
			
		</script>
		
		
		
	</body>
</html>