package com.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadContact extends HttpServlet{
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) 
                    throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setHeader("Expiers", "0");

        response.setContentType("text/csv");
        String reportName =  "Download.csv"
                +System.currentTimeMillis()+".csv";     
        response.setHeader("Content-disposition", "attachment; " +
                "filename=" + reportName); 
        ArrayList<String> contact = new ArrayList<String>();
        contact.add("Name,Email,Phone number,Address");
        contact.add("\n");
        contact.add("sanjay,sanjay@gmail.com,8765678987,72 ram street chennai");
        contact.add("\n");
        contact.add("ajith,ajith@gmail.com,7689878987,87 raj street coimbatore");
        contact.add("\n");
        contact.add("nithin,nithin@gmail.com,7689878987,98 LGB nagar karur");
        
        Iterator<String> iter = contact.iterator();
        while (iter.hasNext()){
            String outputString = (String) iter.next();
            response.getOutputStream().print(outputString);
        }

        response.getOutputStream().flush();
        
        
        
	}

}
