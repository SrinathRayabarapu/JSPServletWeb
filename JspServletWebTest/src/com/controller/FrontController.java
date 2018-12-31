package com.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet
{
    	public void init(ServletConfig config) throws ServletException {
    	
    		String config1=config.getInitParameter("config");
    		String config2=config.getInitParameter("config1");
    		System.out.println(config1 +":"+config2);
    		System.out.println("InitConfig() is called...");
    		Enumeration e=config.getInitParameterNames();
    		while(e.hasMoreElements())
    		{
    			String name=e.nextElement().toString();
    			String value=config.getInitParameter(name);
    			System.out.println(name+":"+value);
    		}
    	}
    	@Override
    	public void destroy() {
    	System.out.println("Destroy method Called..");
    	}
    	@Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    		resp.setContentType("text/html");
    		ServletOutputStream out=resp.getOutputStream();
    		//String name=req.getParameter("username");
    		//String pass=req.getParameter("upass");
    		Enumeration e=req.getParameterNames();
    		while(e.hasMoreElements())
    		{
    			//returning an object and converting it to string
    			String key=e.nextElement().toString();
    			out.println("<h2>"+req.getParameter(key)+"</h2>");
    		   }
    		//out.println("<h3>"+name+":"+pass+"</h3>");
        	out.println("<h4>"+"doGet method called"+"</h4>");
    	}
	}
