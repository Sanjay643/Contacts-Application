package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.users.User;

//@WebServlet(
//    name = "HelloAppEngine",
//    urlPatterns = {"/hello"}
//)
public class Datastore_sample extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
	  DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	  //Creating entity without identifier
	  
	  Entity e = new Entity("Person");
	  e.setProperty("First Name","Nithin");
	  e.setProperty("Last Name","Ramesh");
	  e.setProperty("Age", "15");
	  
	  ds.put(e);
	  
	  //Creating entity using identifier
	  
	  Entity user = new Entity("User", "100");
	  user.setProperty("Userid","100");
	  user.setProperty("Username","Vijay");
	  user.setProperty("Age","30");
	  ds.put(user);
	  
	  
	  //GQL query
	  
	  Query q = new Query("User").addFilter("Age",FilterOperator.EQUAL,"30");
	  PreparedQuery pq = ds.prepare(q);
	  
	  for(Entity detail:pq.asIterable()) {
		  String userid = detail.getProperty("Userid").toString();
		  String username = detail.getProperty("Username").toString();
		  String age = detail.getProperty("Age").toString();
		  
		  System.out.println("Userid: "+userid+"Username: "+username+"Age: "+age);
		  
	  }
	  
	  //Batch entity
	  
	  Entity emp1 = new Entity("Emp1","102");
	  Entity emp2 = new Entity("Emp2","103");
	  Entity emp3 = new Entity("Emp3","105");
	  emp1.setProperty("Name", "Sanjay");
	  emp2.setProperty("Name", "Ajith");
	  emp3.setProperty("Name", "Nithin");
	  List<Entity> list = Arrays.asList(emp1,emp2,emp3);
	  ds.put(list);
	  //Creating a key
	  Key key = KeyFactory.createKey("User", "101");
	  System.out.println("The key value is "+key);
	  
	  //creating ancestor key
	// Key key1 = KeyFactory.Builder("User","Grandpa").addchild("User","Father").addchild("User","Son").getKey();
	  
	  //Creating an Entity group
	  Entity emp = new Entity("Emp","User.getKey()");
	  ds.put(emp);

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
   PrintWriter writer = response.getWriter();

    writer.print("Welcome to Google app engine Datastore!\r\n");

  }
}