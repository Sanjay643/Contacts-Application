package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Expires", "0");
		 response.setContentType("text/html");  
	        PrintWriter writer=response.getWriter(); 
	        HttpSession session=request.getSession(false); 
	        if(session!=null)
	        {
	        	String name=(String)session.getAttribute("name");
	        	writer.print("<h3>Login Successfull</h3>");
				writer.print("<h2>Welcome to login page </h2>");
				writer.print("<h2>Login Person Name: " + name + "</h2>");
				writer.print("<br><h2>If you want to logout of these page!! Please click the link below<h2/>");
	        	writer.println("<br><a href=\"/logout\" >Logout</a>");
	        }
	        else
	        {
	        	writer.print("Sorry Please Login first!!!");
	        	request.getRequestDispatcher("index.html").include(request, response);
	        }
	        writer.close();
	        
	}

}
