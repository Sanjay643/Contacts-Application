package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

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
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.apphosting.api.DatastorePb.Query.Filter;

public class Login extends HttpServlet {  
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
        String name=request.getParameter("username");  
        String password=request.getParameter("password");
//        Integer userid = name.hashCode();
//        Entity user = new Entity("User",userid.toString());
//        user.setProperty("Username", name);
//        user.setProperty("Password",password);
//        ds.put(user);
//        Key key = KeyFactory.createKey("User", userid.toString());
        
        Query validuser = new Query("User").addFilter("Username", FilterOperator.EQUAL, name);
        		Entity entity = ds.prepare(validuser).asSingleEntity();
     
    	 
      if(entity!=null && password.equals(entity.getProperty("Password"))){    
            HttpSession session=request.getSession();  
            session.setAttribute("name",name); 
            session.setAttribute("Userid", entity.getProperty("Userid"));
            response.sendRedirect("/home");
            }
        else 
        	{
                writer.print("Sorry, username or password error!");  
                request.getRequestDispatcher("login.html").include(request, response);  
            }  
            writer.close();
    }
    
}

