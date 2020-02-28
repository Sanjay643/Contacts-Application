package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(
//    name = "HelloAppEngine",
//    urlPatterns = {"/hello"}
//)
public class MyContact extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		doPost(request,response);
	}

  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.setHeader("Expires", "0");
    PrintWriter writer = response.getWriter();
    HttpSession session=request.getSession(false);
    if(session!=null) {
    	String name=(String)session.getAttribute("name");
    	writer.print("<h2>Welcome " + name + "</h2>");
    	
    	 writer.print("<form action=\"/details.html\"><input type=\"submit\" value=\"Add contact\"></form>");
    	 //request.getRequestDispatcher("/add.html").include(request, response);

    	 ServletContext context = getServletConfig().getServletContext();
       // writer.println("<h2>Contacts available for you:</h2>");

//        writer.print("<h4>"+context.getInitParameter("1")+"</h4><br>");
//        writer.print("<h4>"+context.getInitParameter("2")+"</h4><br>");
//        writer.print("<h4>"+context.getInitParameter("3")+"</h4><br>");
        
        
        
        ArrayList<String> list = Collections.list(context.getAttributeNames());

		for (String email : list) {
			String form = "\\w+@\\w+\\.\\w+";
			Pattern pat = Pattern.compile(form);
			Matcher match = pat.matcher(email);
			if (match.matches()) {
				ContactDetails contact = (ContactDetails) context.getAttribute(email);
				//writer.print(email + " ");
				writer.print("<h3>"+contact.getName() + "</h3>  ");
				writer.print("<h3>"+contact.getEmail()+"</h3>  ");
				writer.print("<h3>"+contact.getPhone()+"</h3>  ");
				writer.print("<h3>"+contact.getAddress()+"</h3>" );
               
			}
		}
        
        
        
        writer.print("<form action=\"/download\"><input type=\"submit\" value=\"Download\"></form>");
       
        writer.print("<br><form action=\"/logout\"><input type=\"submit\" value=\"Logout\"></form>");
        
    }
    else {
    	writer.print("<h3>Sorry Please Login first!!!</h3>");
    	request.getRequestDispatcher("index.html").include(request, response);
    	
    }
    
    
    
    

  }
}