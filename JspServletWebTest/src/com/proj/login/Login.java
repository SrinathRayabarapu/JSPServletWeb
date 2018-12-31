package com.proj.login;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proj.testbean.TestBean;

public class Login extends HttpServlet{
	DBCon dbcon;
	TestBean bean;
	HashMap hashMap;
	RequestDispatcher dispatcher;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		dbcon=DBCon.getDBCon();	
		String action = req.getParameter("action");
		
		
		if(action.equals("login")){
			String uname = (String) req.getParameter("uname");
			String password = (String) req.getParameter("pname");
	
			hashMap=dbcon.getCredentials(uname);
			bean = (TestBean)hashMap.get("credentials");
			String pwd = bean.getPassword();
	
			if(password.equals(pwd)){
				String welcomeJSP = "/Welcome.jsp";
				dispatcher = getServletContext().getRequestDispatcher(welcomeJSP);
				dispatcher.forward(req,resp);
			}else{
				dispatcher = getServletContext().getRequestDispatcher("/Registration.jsp");
				dispatcher.forward(req,resp);
			}
		}else
		if(action.equals("register")){
			System.out.println("entered bla bla");
			String uname = (String) req.getParameter("uname");
			String password = (String) req.getParameter("pname");
			String rollno = (String) req.getParameter("rollno");
			TestBean bean = new TestBean();
			
			bean.setUsername(uname);
			bean.setPassword(password);
			bean.setRollno(rollno);

			hashMap.put("regestervalues",bean);
			
			boolean bool = dbcon.getRegister(hashMap);
			System.out.println(bool);
			
			if(bool){
				System.out.println("Successfully registered");
			}
			else{
				System.out.println("Probably some mistake is there, check out");
			}
		}
	}
}
