package etf.ip.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import etf.ip.model.MessageBean;


@WebServlet("/seen-status")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService;
	
    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }

    
    // ONLY TO CHANGE THE SEEN STATUS OF THE MESSAGE
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        // Parse JSON data manually
        String jsonString = requestBody.toString();
        String[] keyValuePairs = jsonString.split(",");
        
        int start1 = keyValuePairs[0].indexOf(":") + 2;
        int start2 = keyValuePairs[1].indexOf(":") + 1;
        
        int messageId = Integer.parseInt(keyValuePairs[0].substring(start1, keyValuePairs[0].length() - 1));
        String forBool = keyValuePairs[1].substring(start2, keyValuePairs[1].length() - 1);
        boolean isChecked = Boolean.parseBoolean(forBool);
        
        
	
        messageService.setSeenStatus(isChecked, messageId);
        
        response.setContentType("text/plain");
        response.getWriter().write("Success");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String searchValue = request.getParameter("search");
    	
        if (searchValue != null) {
            List<MessageBean> messages = messageService.getMessagesByContent(searchValue);
            
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String jsonMessages = gson.toJson(messages);
            out.println(jsonMessages);
            
        } else {
            // Handle case where search value is not provided
        }
    }

}