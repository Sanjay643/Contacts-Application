package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class AddContact extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		doPost(request,response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Expires", "0");
      
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
       
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        HttpSession session = request.getSession(false);
        Integer contactid = email.hashCode();
        Entity contacts = new Entity("Contact",contactid.toString());
        Integer sessionid = (Integer) session.getAttribute("Userid");
        contacts.setProperty("Contactid",contactid);
        contacts.setProperty("Name",name);
        contacts.setProperty("Email",email);
        contacts.setProperty("Phone number",phone);
        contacts.setProperty("Address",address);
        contacts.setProperty("Userid",sessionid);
        ds.put(contacts);
        
        
       request.getRequestDispatcher("/home").include(request, response);
        
        
        
    }
}