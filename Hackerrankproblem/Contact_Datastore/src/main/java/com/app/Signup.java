package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Signup extends HttpServlet {  
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
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
       // HttpSession session = request.getSession();
        
          
        String name=request.getParameter("username");  
        String password=request.getParameter("password");
        String cpwd = request.getParameter("Cpassword");
        
       
        Integer userid = (name+password).hashCode();
        Entity user = new Entity("User",userid.toString());
        user.setProperty("Userid", userid);
        user.setProperty("Username", name);
        user.setProperty("Password",password);
        ds.put(user);
        
        // session.setAttribute("Userid",userid);
        
        
        Key key = KeyFactory.createKey("User", userid);
       // System.out.println("The key of user is"+key);
        request.getRequestDispatcher("login.html").include(request, response); 
    }

}
