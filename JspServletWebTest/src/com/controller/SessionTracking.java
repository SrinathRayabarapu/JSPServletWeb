package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTracking extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String uname=req.getParameter("username");
		String password=req.getParameter("upass");
		String page = req.getParameter("page");
		
		if(page.equals("index"))
		{
            HttpSession session=req.getSession();
            session.setAttribute("username",uname);
            System.out.println(session.getAttribute("username"));
			resp.sendRedirect("/webproj/welcome.html");
		}
		else if(page.equals("welcome"))
		{
			HttpSession session=req.getSession();
			String username=session.getAttribute("username").toString();
			System.out.println("Name:" +username);
			String vipnumber=req.getParameter("VipPass");
				System.out.println("vipnumber "+vipnumber);
			resp.sendRedirect("/webproj/vip.html");
			}
		else if(page.equals("vip"))
		{
			HttpSession session=req.getSession();
			String username=session.getAttribute("username").toString();
				System.out.println("Name :" +username);
			String VipPass=req.getParameter("VipPass");
				System.out.println("vippass " +VipPass);
			RequestDispatcher rd=req.getRequestDispatcher("/vvip.html");
			rd.forward(req, resp);
		}
	}
}