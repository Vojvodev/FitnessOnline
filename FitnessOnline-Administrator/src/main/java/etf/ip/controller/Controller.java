package etf.ip.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import etf.ip.beans.AdministratorBean;
import etf.ip.dao.CategoryDAO;
import etf.ip.dao.LogDAO;
import etf.ip.dao.TrainerDAO;
import etf.ip.dao.UserDAO;
import etf.ip.dto.Category;
import etf.ip.dto.Log;
import etf.ip.dto.Trainer;
import etf.ip.dto.User;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String currentAdmin = ""; 
		String address = "/WEB-INF/Login.jsp";
		String action = request.getParameter("action");
		
		
		session.setAttribute("notification", "");
		
		if (action == null || action.equals("")) {
			address = "/WEB-INF/Login.jsp";
		} 
		else if (action.equals("Logout")) {
			session.invalidate();
			address = "/WEB-INF/Login.jsp";
		} 
		else if (action.equals("Login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdministratorBean adminBean = new AdministratorBean();
			if (adminBean.login(username, password)) {
				session.setAttribute("adminBean", adminBean);
				address = "/WEB-INF/Welcome.jsp";
			}
			else {
				session.setAttribute("notification", "Wrong username/password!");
			}
		} 

		else {
			AdministratorBean adminBean = (AdministratorBean) session.getAttribute("adminBean");
			
			if (adminBean == null || !adminBean.isLoggedIn()) {
				address = "/WEB-INF/Login.jsp";
			}
			else {	// IF USER IS LOGGED IN AND ...
				currentAdmin = adminBean.getAdministrator().getUsername();
				if (action.equals("Welcome")) {
					address = "/WEB-INF/Welcome.jsp";
				}
				
	// ------------------------------------------- CATEGORIES FRONT PAGE --------------------------------------------------------
				
				else if(action.equals("Categories")) {
					address = "/WEB-INF/Categories.jsp";
				}
				
	// ------------------------------------------- CATEGORIES -------------------------------------------------------------------
				
					else if(action.equals("NewCategory")) {
						address = "/WEB-INF/NewCategory.jsp";
					}
						else if(action.equals("CreateCategory")) {
							// A NEW CATEGORY IS CREATED
							
							Category category = new Category(request.getParameter("name"), request.getParameter("image"));
							
							if( category.getName() != null && category.getImage() != null && 
									category.getName() != "" && category.getImage() != "" && 
										CategoryDAO.insert(category)) {
								
								String actvity = "Category Successfully Created";
										
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Categories.jsp";
							}
							else {
								String actvity = "Could Not Create A Category";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/NewCategory.jsp";
							}
							
							
						}
				
					else if(action.equals("AllCategories")) {
						// CATEGORIES LOADED INTO SESSION
						
						ArrayList<Category> categories = CategoryDAO.selectAll();
						
						session.setAttribute("categories", categories);
						
						address = "/WEB-INF/AllCategories.jsp";
					}
				
					else if(action.equals("UpdateCategory")) {
						address = "/WEB-INF/UpdateCategory.jsp";
					}
						else if(action.equals("SendCategoryUpdate")) {
							// SEND UPDATE
							
							Category category = new Category(request.getParameter("name"), request.getParameter("image"));
							category.setId(Integer.parseInt(request.getParameter("id")));
							
							if( category.getName() != null && category.getImage() != null && 
									category.getName() != "" && category.getImage() != "" && 
										CategoryDAO.update(category)) {
								
								String actvity = "Category Successfully Updated";
										
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Categories.jsp";
							}
							else {
								String actvity = "Could Not Update Category";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/UpdateCategory.jsp";
							}
							
							
						}
				
					else if(action.equals("DeleteCategory")) {
						address = "/WEB-INF/DeleteCategory.jsp";
					}
						else if(action.equals("SendCategoryDelete")) {
							// SEND DELETE
							
							int myId = -1;
							if(request.getParameter("id") != null && request.getParameter("id") != "") {
								myId = Integer.parseInt(request.getParameter("id"));
							}
							
							if( myId != -1 && CategoryDAO.delete(myId)) {
								String actvity = "Category Successfully Deleted";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Categories.jsp";
							}
							else {
								String actvity = "Could Not Delete A Category";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/DeleteCategory.jsp";
							}
							
						}
				
	// ----------------------------------- USERS FRONT PAGE ---------------------------------------------------
				
				else if(action.equals("Users")) {
					address = "/WEB-INF/Users.jsp";
				}
				
	// ------------------------------------ USERS -------------------------------------------------------------
				
					else if(action.equals("NewUser")) {
						address = "/WEB-INF/NewUser.jsp";
					}
						else if(action.equals("CreateUser")) {
							// A NEW USER IS CREATED
							
							User user = new User(
													request.getParameter("fname"),
													request.getParameter("lname"),
													request.getParameter("username"),
													request.getParameter("email"),
													request.getParameter("password"),
													false,								// TRAINER
													request.getParameter("contact"),
													request.getParameter("city"),
													request.getParameter("avatar")
												);
							
							if(user != null && UserDAO.insert(user)) {
								String actvity = "User Successfully Created";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Create A User";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/NewUser.jsp";
							}
							
						}
				
					else if(action.equals("AllUsers")) {
						// USERS STORED IN SESSION
						
						ArrayList<User> users = UserDAO.selectAll();
						session.setAttribute("users", users);
						
						address = "/WEB-INF/AllUsers.jsp";
					}
				
					else if(action.equals("UpdateUser")) {
						address = "/WEB-INF/UpdateUser.jsp";
					}
						else if(action.equals("SendUserUpdate")) {
							// SEND UPDATE
							
							User user = new User(
									request.getParameter("fname"),
									request.getParameter("lname"),
									request.getParameter("username"),
									request.getParameter("email"),
									request.getParameter("password"),
									false,								// TRAINER
									request.getParameter("contact"),
									request.getParameter("city"),
									request.getParameter("avatar")
								);
							
							int myInt = -1;
							if(request.getParameter("id") != null && request.getParameter("id") != ""){
								myInt = Integer.parseInt(request.getParameter("id"));
							}
							
							user.setId(myInt);
							
							if(user != null && myInt != -1 && UserDAO.update(user)) {
								String actvity = "User Successfully Updated";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Update A User";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/UpdateUser.jsp";
							}	
		
						}
				
					else if(action.equals("DeleteUser")) {
						address = "/WEB-INF/DeleteUser.jsp";
					}
						else if(action.equals("SendUserDelete")) {
							// SEND DELETE
							
							int myInt2 = -1;
							if(request.getParameter("id") != null && request.getParameter("id") != "") {
								myInt2 = Integer.parseInt(request.getParameter("id"));
							}
							
							
							if(myInt2 != -1 && UserDAO.delete(myInt2)) {
								String actvity = "User Successfully Deleted";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Delete A User";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/DeleteUser.jsp";
							}
							
							
						}
				
	// -------------------------------------------------- TRAINERS ----------------------------------------------
					
					else if(action.equals("NewTrainer")) {
						address = "/WEB-INF/NewTrainer.jsp";
					}
						else if(action.equals("CreateTrainer")) {
							// KREIRANJE TRENERA
							Trainer trainer = new Trainer(
									request.getParameter("fname"),
									request.getParameter("lname"),
									request.getParameter("email"),
									request.getParameter("password")
								);
			
							if(trainer != null && TrainerDAO.insert(trainer)) {
								String actvity = "Trainer Successfully Created";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Create Trainer";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/NewTrainer.jsp";
							}
						}
					else if(action.equals("AllTrainers")) {
						// Trainers STORED IN SESSION
						
						ArrayList<Trainer> trainers = TrainerDAO.selectAll();
						session.setAttribute("trainers", trainers);
						
						address = "/WEB-INF/AllTrainers.jsp";
					}
				
					else if(action.equals("UpdateTrainer")) {
						address = "/WEB-INF/UpdateTrainer.jsp";
					}
						else if(action.equals("SendTrainerUpdate")) {
							// SEND UPDATE
							
							Trainer trainer = new Trainer(
									request.getParameter("fname"),
									request.getParameter("lname"),
									request.getParameter("email"),
									request.getParameter("password")
								);
							
							int myInt3 = -1;
							if(request.getParameter("id") != null && request.getParameter("id") != "") {
								myInt3 = Integer.parseInt(request.getParameter("id"));
							}
							
							trainer.setId(myInt3);
							
							if(myInt3 != -1 && trainer != null && TrainerDAO.update(trainer)) {
								String actvity = "Trainer Successfully Updated";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Update Trainer";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/UpdateTrainer.jsp";
							}	
						}
				
					else if(action.equals("DeleteTrainer")) {
						address = "/WEB-INF/DeleteTrainer.jsp";
					}
						else if(action.equals("SendTrainerDelete")) {
							// SEND DELETE
							
							int myInt4 = -1;
							if(request.getParameter("id") != null && request.getParameter("id") != "") {
								myInt4 = Integer.parseInt(request.getParameter("id"));
							}
							
							
							if(myInt4 != -1 && TrainerDAO.delete(myInt4)) {
								String actvity = "Trainer Successfully Deleted";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/Users.jsp";
							}
							else {
								String actvity = "Could Not Delete Trainer";
								
								session.setAttribute("notification", actvity);
								LogDAO.insertLog(currentAdmin, actvity);
								address = "/WEB-INF/DeleteTrainer.jsp";
							}
						}
	
	// -------------------------------------------------- STATISTICS ---------------------------------------------------
				
				else if(action.equals("Statistics")) {
					// READ LOGS FROM TABLE
					
					ArrayList<Log> logs = (ArrayList<Log>) LogDAO.selectAll();
					session.setAttribute("logs", logs);
					
					address = "/WEB-INF/Statistics.jsp";
				}
		
	// --------------------------------------------------- NOT FOUND ---------------------------------------------------
				
				else {
					address="/WEB-INF/NotFound.jsp";
				}
			}
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
