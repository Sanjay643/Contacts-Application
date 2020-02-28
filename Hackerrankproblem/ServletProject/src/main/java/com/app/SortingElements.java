package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(
//    name = "HelloAppEngine",
//    urlPatterns = {"/hello"}
//)
public class SortingElements extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    

    response.getWriter().println("<h3>Elements entered:</h3>");
    PrintWriter writer=response.getWriter();
    String elements = request.getParameter("elements");
    String[] str = elements.trim().split("[,.\n]");
    Arrays.sort(str);
    for(int i=0;i<str.length;i++)
    {
       writer.println("<h4>"+str[i]+"</h4>");
    }
   
    
   
    
    

  }
}