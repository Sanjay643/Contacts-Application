package com.app;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LoginPage extends HttpServlet {  
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		doPost(request,response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Expires", "0");
        PrintWriter writer=response.getWriter();  
       
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        if(name.isEmpty() || password.isEmpty() || name=="" || password=="")
        {
        	writer.print("Enter the username and password correctly!!");
        	request.getRequestDispatcher("index.html").include(request, response); 
        }
        else if(password.equals(name)){  
        writer.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
        response.sendRedirect("/profile");
        }  
        else{  
            writer.print("Sorry, username or password error!");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
        writer.close();  
    }  
}  