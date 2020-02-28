package com.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheck extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setHeader("Expiers", "0");
		if (session == null) {
			response.sendRedirect("index.html");
		} else if (session.getAttribute("name") != null) {
			response.sendRedirect("/mycontact");

		}
	}

}
