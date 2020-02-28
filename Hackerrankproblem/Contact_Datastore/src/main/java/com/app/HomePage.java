package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

//@WebServlet(
//    name = "HelloAppEngine",
//    urlPatterns = {"/hello"}
//)
public class HomePage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setHeader("Expires", "0");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");
			writer.print("<h2>Welcome " + name + "</h2>");

			writer.print("<form action=\"/add.html\"><input type=\"submit\" value=\"Add contact\"></form>");
			
			writer.print("<form action=\"/home\"><input type=\"text\" placeholder=\"Search..\"name=\"search\"><input type=\"submit\" value=\"Search\"></form>");
			
			writer.print("<h2>Contacts available</h2>");

			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			 Integer sessionid = (Integer) session.getAttribute("Userid");
			
			Query q = new Query("Contact").addFilter("Userid",FilterOperator.EQUAL, sessionid);
			PreparedQuery pq = ds.prepare(q);
		
			for (Entity detail : pq.asIterable()) {
				String cname = detail.getProperty("Name").toString();
				String email = detail.getProperty("Email").toString();
				String phone = detail.getProperty("Phone number").toString();
				String address = detail.getProperty("Address").toString();

				writer.println(cname + "   " + email + "   " + phone + "   " + address + "<br>");

			}

			writer.print("<br><form action=\"/logout\"><input type=\"submit\" value=\"Logout\"></form>");

		} else {
			writer.print("<h3>Sorry Please Login first!!!</h3>");
			request.getRequestDispatcher("login.html").include(request, response);

		}

	}
}